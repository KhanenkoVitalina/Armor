package model.database;

public class ArmorDTO {
    private String name;
    private int price;
    private int weight;
    private int additional;

    public ArmorDTO(String name, int price, int weight, int additional) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.additional = additional;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAdditional() {
        return additional;
    }

    public void setAdditional(int additional) {
        this.additional = additional;
    }
}
