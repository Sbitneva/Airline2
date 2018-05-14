package sbitneva.service;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbitneva.dao.sqlite.AircraftsDao;
import sbitneva.entity.aircrafts.Aircraft;

import java.util.ArrayList;

@Service("findByFuelRangeService")
public class FindByFuelRangeService {

    private static Logger log = Logger.getLogger(FindByFuelRangeService.class.getName());

    @Autowired
    private AircraftsDao aircraftsDao;

    public ArrayList<Aircraft> findInRange(int minRange, int maxRange){
        ArrayList<Aircraft> aircrafts = aircraftsDao.findByFuelRange(minRange, maxRange);
        return aircrafts;
    }
}
