package sbitneva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sbitneva.entity.aircrafts.Aircraft;
import sbitneva.service.FindByFuelRangeService;

import java.util.ArrayList;

@Controller
public class FuelInRangeController {

    @Autowired
    FindByFuelRangeService findByFuelRangeService;

    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<Aircraft> getAircraftsByFuelRange(@RequestParam("minRange") int minRange,
                                             @RequestParam("maxRange") int maxRange
                                             ) {
        ArrayList<Aircraft> aircrafts = new ArrayList<>();
        aircrafts = findByFuelRangeService.findInRange(minRange, maxRange);

        return aircrafts;
    }
}
