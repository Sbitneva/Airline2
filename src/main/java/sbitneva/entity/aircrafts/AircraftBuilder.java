package sbitneva.entity.aircrafts;

public class AircraftBuilder {

    private int id;
    private int typeId;
    private String name;
    private int capacity;
    private int flightRange;
    private int fuelConsumption;
    private int carriageCapacity;
    private String type;



    public AircraftBuilder() {

    }

    public AircraftBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public AircraftBuilder setTypeId(int typeId) {
        this.typeId = typeId;
        return this;
    }

    public AircraftBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public AircraftBuilder setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public AircraftBuilder setFlightRange(int flightRange) {
        this.flightRange = flightRange;
        return this;
    }

    public AircraftBuilder setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
        return this;
    }

    public AircraftBuilder setCarriageCapacity(int carriageCapacity) {
        this.carriageCapacity = carriageCapacity;
        return this;
    }

    public AircraftBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public Aircraft buildAircraft() {
        switch (this.type) {
            case "passenger aircraft":
                return createPassengerAirplane();
            case "cargo helicopter":
                return createCargosHelicopter();
            case "passenger helicopter":
                return createPassengerHelicopter();
            case "cargo aircraft":
                return createCargosAirplane();
        }
        return null;
    }

    public PassengerAirplane createPassengerAirplane() {
        return new PassengerAirplane(id, typeId, name, capacity, flightRange, fuelConsumption, carriageCapacity);
    }

    public PassengerHelicopter createPassengerHelicopter() {
        return new PassengerHelicopter(id, typeId, name, capacity, flightRange, fuelConsumption, carriageCapacity);
    }

    public CargosHelicopter createCargosHelicopter() {
        return new CargosHelicopter(id, typeId, name, capacity, flightRange, fuelConsumption, carriageCapacity);
    }

    public CargosAirplane createCargosAirplane() {
        return new CargosAirplane(id, typeId, name, capacity, flightRange, fuelConsumption, carriageCapacity);
    }


}
