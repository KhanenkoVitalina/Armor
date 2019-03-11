package model.database;

import model.entites.Armor;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArmorDAO extends DAO {
    public  String INSERT_ARMOR = "insert into knight_info (name,weight,price,other) values (?,?,?,?)";
    public  String DELETE_ARMOR = "delete from knight_info where name=? && weight=?";
    public  String SELECT_ARMOR = "select * from knight_info";
    private DataSource source;
    private Connection connection;

    public ArmorDAO() throws Exception {
        ConfigConnection configConnection = new ConfigConnection();
        source = configConnection.setUp();
    }

    @Override
    public List<Armor> getAll() {
        List<Armor> list = new ArrayList();
        try{
            connection = source.getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT_ARMOR);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                String name = rs.getString(2);
                System.out.println("clas: ArmorDAO" + name);
                int qualities = rs.getInt(5);
                Armor armor =  DBUtility.getArmorByName(name, qualities);
                Objects.requireNonNull(armor).setPrice(rs.getInt(4));
                armor.setName(name);
                armor.setWeight(rs.getInt(3));
                list.add(armor);
            }
            connection.close();
        }catch(Exception e){e.printStackTrace();}
        return list;
    }


    @Override
    public void save(ArmorDTO o) {
        try {
            connection = source.getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_ARMOR);
            ps.setString(1,o.getName());
            ps.setInt(2,o.getWeight());
            ps.setInt(3,o.getPrice());
            ps.setInt(4, o.getAdditional());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(String name, int weight) {
        try{
            connection = source.getConnection();
            PreparedStatement ps = connection.prepareStatement(DELETE_ARMOR);
            ps.setString(1, name);
            ps.setInt(2, weight);
            ps.execute();
            connection.close();
        }catch(Exception e){e.printStackTrace();}
    }
    public void deleteAll(){
        List<Armor> armor = getAll();
        armor.forEach(x ->delete(x.getName(),x.getWeight()));
    }
}
