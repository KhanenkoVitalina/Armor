package model.database;

import model.entites.Armor;
import model.entites.Bow;
import model.entites.Shield;
import model.entites.Sword;

public class DBUtility {

    public static Armor getArmorByName(String name, int quality){
        if(name.equals(Entities.NAME_BOW)){
            Bow bow = new Bow();
            bow.setAccuracy(quality);
            return bow;
        } else if (name.equals(Entities.NAME_SHIELD)){
            Shield shield = new Shield();
            shield.setProtection(quality);
            return shield;
        } else if (name.equals(Entities.NAME_SWORD)){
            Sword sword = new Sword();
            sword.setSharpness(quality);
            return sword;
        }else{
            System.out.println("WRONG NAME!!!");
            return null;
        }
    }
}
