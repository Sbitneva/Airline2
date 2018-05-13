package sbitneva.entity.aircrafts.internal;

public class CargoBuilder {

    private String id;
    private int cargoWeight;

    public CargoBuilder() {

    }

    public CargoBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public CargoBuilder setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
        return this;
    }

    public Cargo createCargo() {
        return new Cargo(id, cargoWeight);
    }
}
