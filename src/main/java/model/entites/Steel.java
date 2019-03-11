package model.entites;

public class Steel implements Material {
    @Override
    public int getPricePerKg() {
        return 30;
    }
    @Override
    public String toString() {
        return "Steel";
    }
}
