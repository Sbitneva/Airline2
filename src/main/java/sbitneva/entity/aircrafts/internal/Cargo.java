package sbitneva.entity.aircrafts.internal;

public class Cargo {

    private String id;
    private int weight;

    public Cargo() {

    }

    public Cargo(String id, int cargoWeight) {
        this.id = id;
        this.weight = cargoWeight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
