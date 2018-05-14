package sbitneva.entity.aircrafts;

import sbitneva.entity.aircrafts.internal.Passenger;

import java.util.ArrayList;

public interface Passengers {
    void addPassenger(Passenger passenger);

    ArrayList<Passenger> getPassengersList();

    void setPassengersList(ArrayList<Passenger> passengersList);
}
