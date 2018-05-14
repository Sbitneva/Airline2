package sbitneva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sbitneva.entity.aircrafts.Aircraft;
import sbitneva.service.FindByPassengerCapacityAndFlightRangeService;

import java.util.ArrayList;

@Controller
@RequestMapping("airline/find")
public class FindByPassengercapacityAndFlightRangeController {

    @Autowired
    private FindByPassengerCapacityAndFlightRangeService findByPassengerCapacityAndFlightRangeService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Aircraft> getAircraftsByFuelRange(@RequestParam("capacity") int capacity,
                                                       @RequestParam("flightRange") int flightRange) {
        ArrayList<Aircraft> aircrafts = new ArrayList<>();
        aircrafts = findByPassengerCapacityAndFlightRangeService.find(capacity, flightRange);

        return aircrafts;
    }
}
