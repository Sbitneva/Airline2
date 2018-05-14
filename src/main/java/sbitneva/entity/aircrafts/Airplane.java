package sbitneva.entity.aircrafts;

public class Airplane extends Aircraft {

    public Airplane() {
        super();
    }

    public Airplane(int id, int typeId, String name, int capacity, int flightRange, int fuelConsumption, int carriageCapacity) {
        super(id, typeId, name, capacity, flightRange, fuelConsumption, carriageCapacity);
    }
}
