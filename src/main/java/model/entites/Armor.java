package model.entites;

public abstract class Armor {
    private String name;
    private int weight;
    private int price;
    private Material material;
    public Armor(){
    }
    public Armor(String name, int weight, Material material) {
        this.name = name;
        this.weight = weight;
        this.material = material;
        price = material.getPricePerKg()*getWeight();
    }
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Material getMaterial() {
        return material;
    }
    public void setMaterial(Material material) {
        this.material = material;
    }
}
