package sbitneva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbitneva.dao.sqlite.AircraftsDao;
import sbitneva.entity.aircrafts.Aircraft;

import java.util.ArrayList;

@Service("findByPassengerCapacityAndFlightRangeService")
public class FindByPassengerCapacityAndFlightRangeService {

    @Autowired
    AircraftsDao aircraftsDao;

    public ArrayList<Aircraft> find(int capacity, int fuel) {
        ArrayList<Aircraft> aircrafts = new ArrayList<>();
        aircrafts = aircraftsDao.findByPassengerCapacityAndFlightRange(capacity, fuel);
        return aircrafts;
    }
}
