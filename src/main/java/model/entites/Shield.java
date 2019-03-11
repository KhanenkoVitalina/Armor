package model.entites;


public class Shield extends Armor {
    private int protection;
    public Shield() {
    }

    public Shield(String name, int weight, Material material, int protection) {
        super(name, weight, material);
        this.protection = protection;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }
}
