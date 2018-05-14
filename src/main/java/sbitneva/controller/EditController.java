package sbitneva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sbitneva.entity.aircrafts.Aircraft;
import sbitneva.service.CrudService;

@Controller
@RequestMapping("airline/edit")
public class EditController {

    @Autowired
    private CrudService crudService;

    @RequestMapping(method = RequestMethod.GET)
    public String editAircraft(@RequestParam("id") int id,
                               @RequestParam("name") String name,
                               @RequestParam("flightRange") int flightRange,
                               @RequestParam("fuelConsumption") int fuelConsumption) {
        Aircraft aircraft = crudService.read(id);
        if(aircraft != null) {
            if(name != null){
                aircraft.setName(name);
            }
            if(flightRange != 0) {
                aircraft.setFlightRange(flightRange);
            }
            if(fuelConsumption != 0) {
                aircraft.setFuelConsumption(fuelConsumption);
            }
        }

        crudService.edit(id, aircraft);

        return "showAll";
    }
}
