package model.service;

import model.entites.Armor;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingService {
    private SortingService(){}
    public static List<Armor> sortByWeight(List<Armor> armor){
        return armor.stream().sorted(Comparator.comparing(Armor::getWeight)).collect(Collectors.toList());
    }
     public static <T extends Armor> List<T> findArmorInDiapason(int minPrice, int maxPrice, List<T> armor){
        return armor.stream().filter(x -> x.getPrice() > minPrice && x.getPrice() < maxPrice).collect(Collectors.toList());
    }
    public static int getTotalCost(List<Armor> armor){
        return armor.stream().mapToInt(Armor::getPrice).sum();
    }
}
