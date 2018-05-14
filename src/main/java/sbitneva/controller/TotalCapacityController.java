package sbitneva.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sbitneva.service.CalcCapacitiesService;

@Controller
public class TotalCapacityController {

    @Autowired
    private CalcCapacitiesService calcCapacitiesService;

    @RequestMapping("airline/totalCapacity")
    @ResponseBody
    public String getTotalCapacity() {

        Integer capacity = calcCapacitiesService.calc();

        return capacity.toString();
    }


}
