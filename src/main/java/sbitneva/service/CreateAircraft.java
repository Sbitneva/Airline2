package sbitneva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbitneva.dao.sqlite.AircraftTypesDao;
import sbitneva.dao.sqlite.AircraftsDao;
import sbitneva.entity.aircrafts.Aircraft;

@Service("createAircraft")
public class CreateAircraft {

    @Autowired
    private AircraftTypesDao aircraftTypesDao;
    @Autowired
    private AircraftsDao aircraftsDao;

    public void createAircraft(Aircraft aircraft) {
        aircraft.setTypeId(aircraftTypesDao.getAircraftType(aircraft.getClass().getSimpleName()));
    }

}
