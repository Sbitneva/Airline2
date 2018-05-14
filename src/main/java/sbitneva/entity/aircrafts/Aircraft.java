package sbitneva.entity.aircrafts;

public abstract class Aircraft {

    private int id;
    private int typeId;
    private String name;
    private int capacity;
    private int flightRange;
    private int fuelConsumption;
    private int carriageCapacity;

    public Aircraft() {

    }

    public Aircraft(int id, int typeId, String name, int capacity, int flightRange, int fuelConsumption, int carriageCapacity) {
        this.typeId = typeId;
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.flightRange = flightRange;
        this.fuelConsumption = fuelConsumption;
        this.carriageCapacity = carriageCapacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFlightRange() {
        return flightRange;
    }

    public void setFlightRange(int flightRange) {
        this.flightRange = flightRange;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsuption) {
        this.fuelConsumption = fuelConsuption;
    }

    public int getCarriageCapacity() {
        return this.carriageCapacity;
    }

    public void setCarriageCapacity(int carriageCapacity) {
        this.carriageCapacity = carriageCapacity;
    }
    public int getTypeId() {
        return this.typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", flightRange=" + flightRange +
                ", fuelConsumption=" + fuelConsumption +
                ", carriageCapacity=" + carriageCapacity +
                '}';
    }
}
