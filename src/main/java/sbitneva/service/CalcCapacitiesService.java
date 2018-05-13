package sbitneva.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbitneva.dao.sqlite.AircraftsDao;

@Service("calcCapacitiesService")
public class CalcCapacitiesService {

    private static Logger log = Logger.getLogger(CalcCapacitiesService.class.getName());

    @Autowired
    private AircraftsDao aircraftsDao;

    public void calc(){

    }

}
