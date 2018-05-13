package sbitneva.dao;

import sbitneva.dao.sqlite.AircraftTypesDao;
import sbitneva.dao.sqlite.AircraftsDao;
import sbitneva.dao.sqlite.BaggageDao;
import sbitneva.dao.sqlite.PassengersDao;

public class AirlineDaoFactory {

    private static AirlineDaoFactory airlineDaoFactory = new AirlineDaoFactory();

    private static AircraftsDao aircraftsDao = new AircraftsDao();
    private static AircraftTypesDao aircraftTypesDao = new AircraftTypesDao();
    private static BaggageDao baggageDao = new BaggageDao();
    private static PassengersDao passengersDao = new PassengersDao();

    private AirlineDaoFactory() {

    }

    public static AirlineDaoFactory getAirlineDaoFactory() {
        return airlineDaoFactory;
    }

    public static AircraftsDao getAircraftsDao() {
        return aircraftsDao;
    }

    public static AircraftTypesDao getAircraftTypesDao() {
        return aircraftTypesDao;
    }

    public static BaggageDao getBaggageDao() {
        return baggageDao;
    }

    public static PassengersDao getPassengersDao() {
        return passengersDao;
    }
}