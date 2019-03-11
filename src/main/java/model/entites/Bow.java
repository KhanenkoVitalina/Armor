package model.entites;

public class Bow extends Armor {
    private int accuracy;
    public Bow() {
    }

    public Bow(String name, int weight, Material material, int accuracy) {
        super(name, weight, material);
        this.accuracy = accuracy;
    }
    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

}
