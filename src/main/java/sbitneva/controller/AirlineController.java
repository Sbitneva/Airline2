package sbitneva.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sbitneva.entity.aircrafts.Aircraft;
import sbitneva.service.ShowAllAircraftsService;
import sbitneva.service.SortByFlightRange;

import java.util.ArrayList;

@Controller
@RequestMapping("/airline")
public class AirlineController {

    private static Logger log = Logger.getLogger(AirlineController.class.getName());

    @Autowired
    private ShowAllAircraftsService showAllAircraftsService;

    @Autowired
    private SortByFlightRange sortByFlightRange;


    @RequestMapping("/showAll")
    @ResponseBody
    public ArrayList<Aircraft> getAllAircrafts() {

        return showAllAircraftsService.showAll();
    }

    @RequestMapping("/sort/flightRange")
    @ResponseBody
    public ArrayList<Aircraft> sortAllAircrafts() {

        return sortByFlightRange.sort();
    }


}
