package model.entites;

public class Wood implements Material {
    @Override
    public int getPricePerKg() {
        return 20;
    }
    @Override
    public String toString() {
        return "Wood";
    }
}
