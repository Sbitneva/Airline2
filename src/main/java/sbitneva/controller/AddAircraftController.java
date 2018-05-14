package sbitneva.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sbitneva.entity.aircrafts.Aircraft;
import sbitneva.entity.aircrafts.AircraftFactory;
import sbitneva.service.CrudService;

@Controller
@RequestMapping("/airline/add_aircraft")
public class AddAircraftController {

    @Autowired
    private CrudService crudService;

    @RequestMapping(method = RequestMethod.GET)
    public String addAircraft(   @RequestParam("name") String name,
                                 @RequestParam("type_id") int typeId,
                                 @RequestParam("flightRange") int flightRange,
                                 @RequestParam("fuelConsumption") int fuelConsumption) {
        Aircraft aircraft = AircraftFactory.getAircraft(typeId);
        aircraft.setName(name);
        aircraft.setTypeId(typeId);
        aircraft.setFlightRange(flightRange);
        aircraft.setFuelConsumption(fuelConsumption);
        crudService.add(aircraft);

        return "showAll";
    }
}
