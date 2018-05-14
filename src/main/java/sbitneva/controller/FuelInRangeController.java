package sbitneva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sbitneva.entity.aircrafts.Aircraft;
import sbitneva.service.FindByFuelRangeService;

import java.util.ArrayList;

@Controller
@RequestMapping("airline/fuelRange")
public class FuelInRangeController {

    @Autowired
    private FindByFuelRangeService findByFuelRangeService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Aircraft> getAircraftsByFuelRange(@RequestParam("minRange") int minRange,
                                                        @RequestParam("maxRange") int maxRange
                                             ) {
        ArrayList<Aircraft> aircrafts = new ArrayList<>();
        aircrafts = findByFuelRangeService.findInRange(minRange, maxRange);

        return aircrafts;
    }
}
