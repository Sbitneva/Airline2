package sbitneva.entity.aircrafts;

public class Helicopter extends Aircraft {

    public Helicopter() {
        super();
    }

    public Helicopter(int id, int typeId, String name, int capacity, int flightRange, int fuelConsumption, int carriageCapacity) {
        super(id, typeId, name, capacity, flightRange, fuelConsumption, carriageCapacity);
    }
}
