package sbitneva.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sbitneva.entity.aircrafts.Aircraft;
import sbitneva.service.ShowAllAircraftsService;

import java.util.ArrayList;

@Controller
@RequestMapping("/showAll")
public class AirlineController {

    private static Logger log = Logger.getLogger(AirlineController.class.getName());

    @Autowired
    public ShowAllAircraftsService showAllAircraftsService;


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Aircraft> getAllAircrafts() {

        return showAllAircraftsService.showAll();
    }

}
