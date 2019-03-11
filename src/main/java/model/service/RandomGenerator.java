package model.service;

import model.constants.Description;
import model.database.Entities;
import model.entites.*;
import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {
    private final static int MAX_WEIGHT = 100;
    private final static int MAX_BORDER = 10;
    private final static int MED_BORDER = 8;
    private final static int MIN_BORDER = 3;

    private static  Bow getBow(){
        return new Bow(Entities.NAME_BOW, generateWeight(),
                generateSkillsQuality(new Gold(), new Steel(), new Wood()),
                generateSkillsQuality(Description.BAD, Description.NORMAL, Description.GOOD));
    }
    private static Shield getShield(){
        return new Shield(Entities.NAME_SHIELD, generateWeight(),
                generateSkillsQuality(new Gold(), new Steel(), new Wood()),
                generateSkillsQuality(Description.BAD, Description.NORMAL, Description.GOOD));
    }
    private static Sword getSword(){
        return new Sword(Entities.NAME_SWORD, generateWeight(),
                generateSkillsQuality(new Gold(), new Steel(), new Wood()),
                generateSkillsQuality(Description.BAD, Description.NORMAL, Description.GOOD));
    }
    public static List<Bow> getBowList(int count){
        List<Bow> bows = new ArrayList<>(count);
        for(int i = 0; i < count; i++) {
            bows.add(getBow());
        }
        return bows;
    }
    public static List<Sword> getSwordList(int count){
        List<Sword> swords = new ArrayList<>(count);
        for(int i = 0; i < count; i++) {
            swords.add(getSword());
        }
        return swords;
    }
    public static List<Shield> getShieldList(int count){
        List<Shield> shields = new ArrayList<>(count);
        for(int i = 0; i < count; i++) {
            shields.add(getShield());
        }
        return shields;
    }
    private static <T> T generateSkillsQuality(T minValue, T mediumValue, T maxValue){
        int random = (int)(Math.random()*MAX_BORDER);
        if(random <= MIN_BORDER) {
            return minValue;
        } else if( random >= MED_BORDER ){
            return maxValue;
        } else {
            return mediumValue;
        }
    }
    private static int generateWeight(){
        return (int)(Math.random()*MAX_WEIGHT);
    }
}
