package sbitneva.entity.aircrafts;

public class AircraftFactory {

    private static final int CARGO_HELICOPTER = 2;
    private static final int CARGO_AIRPLANE = 4;

    private static final int PASS_HELICOPTER = 3;
    private static final int PASS_AIRPLANE = 1;


    public static Aircraft getAircraft(int type) {
        Aircraft aircraft = null;
        switch (type) {
            case CARGO_HELICOPTER:
                aircraft = new CargosHelicopter();
                break;
            case CARGO_AIRPLANE:
                aircraft = new CargosAirplane();
                break;
            case PASS_AIRPLANE:
                aircraft = new PassengerAirplane();
                break;
            case PASS_HELICOPTER:
                aircraft = new PassengerHelicopter();
                break;
        }
        return aircraft;
    }
}
