package sbitneva.entity.aircrafts.internal;


import java.util.ArrayList;


public class Passenger {

    private Integer id;
    private String firstName;
    private String lastName;
    private ArrayList<Cargo> baggage = new ArrayList<Cargo>();

    public Passenger() {

    }

    public Passenger(Integer id, String firstName, String lastName, ArrayList<Cargo> luggageWeight) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.baggage = luggageWeight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Cargo> getBaggage() {
        return baggage;
    }

    public void setBaggage(ArrayList<Cargo> baggage) {
        this.baggage = baggage;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", baggage=" + baggage +
                '}';
    }
}
