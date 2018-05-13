package sbitneva.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbitneva.dao.sqlite.AircraftsDao;
import sbitneva.entity.aircrafts.Aircraft;

import java.util.ArrayList;

@Service("showAllAircraftsService")
public class ShowAllAircraftsService {
    private static Logger log = Logger.getLogger(ShowAllAircraftsService.class.getName());

    @Autowired
    private AircraftsDao aircraftsDao;

    public ArrayList<Aircraft> showAll(){
        ArrayList<Aircraft> aircrafts = new ArrayList<>();
        aircrafts = aircraftsDao.readAllAircrafts();
        return aircrafts;
    }
}
