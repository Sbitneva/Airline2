package sbitneva.entity.aircrafts.internal;

import java.util.ArrayList;

public class PassengerBuilder {

    private Integer id;
    private String firstName;
    private String lastName;
    private ArrayList<Cargo> baggage = new ArrayList<>();

    public PassengerBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PassengerBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PassengerBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public PassengerBuilder setBaggage(ArrayList<Cargo> baggage) {
        this.baggage = baggage;
        return this;
    }

    public Passenger createPassenger() {
        return new Passenger(id, firstName, lastName, baggage);
    }
}
