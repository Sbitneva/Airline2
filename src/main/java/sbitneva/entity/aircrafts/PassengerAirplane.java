package sbitneva.entity.aircrafts;

import sbitneva.entity.aircrafts.internal.Cargo;
import sbitneva.entity.aircrafts.internal.Passenger;

import java.util.ArrayList;

public class PassengerAirplane extends Airplane implements Passengers {

    private ArrayList<Passenger> passengersList = new ArrayList<>();

    public PassengerAirplane() {
        super();
    }

    public PassengerAirplane(int id, int typeId, String name, int capacity, int flightRange, int fuelConsumption, int carriageCapacity) {
        super(id, typeId, name, capacity, flightRange, fuelConsumption, carriageCapacity);
    }

    @Override
    public void addPassenger(Passenger passenger) {
        passengersList.add(passenger);
    }

    @Override
    public ArrayList<Passenger> getPassengersList() {
        return passengersList;
    }

    @Override
    public void setPassengersList(ArrayList<Passenger> passengersList) {
        this.passengersList = passengersList;
    }

    @Override
    public int getCapacity() {
        int carriageCapacity = 0;
        for (Passenger passenger : passengersList) {
            ArrayList<Cargo> baggage = passenger.getBaggage();
            for (Cargo cargo : baggage) {
                carriageCapacity += cargo.getWeight();
            }
        }
        this.setCarriageCapacity(carriageCapacity);
        return carriageCapacity;
    }

}
