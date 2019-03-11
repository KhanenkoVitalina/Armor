package model.database;

import java.util.List;

public abstract class DAO  {

     abstract List getAll();

     abstract void save(ArmorDTO t);

     abstract void delete(String name, int weight);

}
