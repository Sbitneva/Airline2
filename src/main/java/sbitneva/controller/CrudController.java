package sbitneva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sbitneva.service.CrudService;

@Controller
@RequestMapping("airline/delete")
public class CrudController {

    @Autowired
    CrudService crudService;

    @RequestMapping(method = RequestMethod.GET)
    //@ResponseBody
    public String deleteAircraft(@RequestParam("id") int id) {
        crudService.delete(id);
        return "showAll";
    }
}
