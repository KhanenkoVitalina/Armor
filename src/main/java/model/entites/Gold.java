package model.entites;

public class Gold implements Material{
    @Override
    public int getPricePerKg() {
        return 50;
    }

    @Override
    public String toString() {
        return "Gold";
    }
}
