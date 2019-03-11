package controller;

import model.database.ArmorDAO;
import model.database.ArmorDTO;
import model.database.Entities;
import model.entites.Armor;
import model.entites.Bow;
import model.entites.Shield;
import model.entites.Sword;
import model.service.RandomGenerator;
import model.service.SortingService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class Controller {
    private static final int ITEMS_ON_PAGE = 4;
    private HttpServletResponse resp;
    private HttpServletRequest req;
    private List<Bow> bows;
    private List<Sword> swords;
    private List<Shield> shields;
    private List<Armor> basketList;
    private Optional<ArmorDAO> armorDAO;
    private Optional<String> nameParam;
    private Optional<String> buyParam;
    private String minPrice;
    private String maxPrice;
    Controller(HttpServletRequest req, HttpServletResponse resp){
        this.req = req;
        this.resp = resp;
        nameParam = Optional.ofNullable(req.getParameter("obj_name"));
        buyParam = Optional.ofNullable(req.getParameter("buy"));
        minPrice = req.getParameter("min_price");
        maxPrice = req.getParameter("max_price");
    }
     void setUpListOfIltems() {
         bows = RandomGenerator.getBowList(ITEMS_ON_PAGE);
         swords = RandomGenerator.getSwordList(ITEMS_ON_PAGE);
         shields = RandomGenerator.getShieldList(ITEMS_ON_PAGE);
     }
     void setListOfArmor(String typeOfArmor){

        if(typeOfArmor.equals(Entities.NAME_BOW)) {
            req.setAttribute("list_of_armor", bows);
        }
        else if(typeOfArmor.equals(Entities.NAME_SWORD)){
            req.setAttribute("list_of_armor", swords);
        }
        else{
            req.setAttribute("list_of_armor", shields);
        }
    }
    public void setBasketWindow(){
        createDAO();
        buyParam.ifPresent(s -> armorDAO.ifPresent(x -> armorDAO.get().deleteAll()));
        nameParam.ifPresent(x ->armorDAO.ifPresent(s -> armorDAO.get().delete(req.getParameter("obj_name"),
                Integer.parseInt(req.getParameter("obj_weight")))));

        req.setAttribute("basket_list", basketList);
        armorDAO.ifPresent(armorDAO1 -> basketList = armorDAO1.getAll());
        List<Armor> sortedBasketList = SortingService.sortByWeight(basketList);
        if(minPrice!= null && maxPrice != null && !(minPrice.equals("") && maxPrice.equals(""))){
            sortedBasketList = SortingService.findArmorInDiapason(Integer.parseInt(minPrice),
                    Integer.parseInt(maxPrice), sortedBasketList);
            System.out.println(minPrice + maxPrice);
        }
        req.setAttribute("basket_list", sortedBasketList);
        req.setAttribute("total_cost", SortingService.getTotalCost(sortedBasketList));
        try {
            req.getRequestDispatcher("views/basket.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    public void getConnection(){
            createDAO();
        if (req.getParameter("obj_name") != null){
            armorDAO.get().save(new ArmorDTO(req.getParameter("obj_name"),Integer.parseInt(req.getParameter("obj_weight")),
                    Integer.parseInt(req.getParameter("obj_price")),Integer.parseInt(req.getParameter("obj_additional"))));
            req.setAttribute("basket_list", basketList);
        }
    }
    private void createDAO(){
        try {
            armorDAO = Optional.of(new ArmorDAO());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
