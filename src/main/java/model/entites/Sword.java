package model.entites;


public class Sword extends Armor {
    private int sharpness;
    public Sword() {
    }

    public Sword(String name, int weight, Material material, int sharpness) {
        super(name, weight, material);
    }

    public int getSharpness() {
        return sharpness;
    }

    public void setSharpness(int sharpness) {
        this.sharpness = sharpness;
    }
}
