package sbitneva.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbitneva.dao.sqlite.AircraftsDao;
import sbitneva.entity.aircrafts.Aircraft;

import java.util.ArrayList;
import java.util.Comparator;

@Service("sortByFlightRange")
public class SortByFlightRange {

    private static Logger log = Logger.getLogger(SortByFlightRange.class.getName());

    @Autowired
    private AircraftsDao aircraftsDao;

    public  ArrayList<Aircraft> sort() {
        ArrayList<Aircraft> aircrafts = aircraftsDao.readAllAircrafts();
        aircrafts.sort(new Comparator<Aircraft>() {
            @Override
            public int compare(Aircraft aircraft1, Aircraft aircraft2) {
                return aircraft1.getFlightRange() - aircraft2.getFlightRange();
            }
        });

        log.debug(aircrafts);
        return aircrafts;
    }

}
