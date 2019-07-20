package sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import sda.modelDTO.LocationDTO;
import sda.service.LocationService;

import java.util.List;

@Controller
public class LocationController {

    @Autowired
    LocationService locationService;

    @GetMapping("/barbershop/{location_id}")

    public String  locationPage(Model model, @PathVariable ("location_id") Integer location_id){
        List<LocationDTO> allLocation = locationService.getAllLocation();
        model.addAttribute("location",allLocation);
        return "home";
    }

    @GetMapping("/location")
    public String homePage(Model model) {
        List<LocationDTO> allLocation = locationService.getAllLocation();
        System.out.println("SS");
        model.addAttribute("location", allLocation);

        return "home2";

    }

    @GetMapping(name = "/location/json",produces = "application/json")
    @ResponseBody
    public List<LocationDTO> getAllLocation() {
        List<LocationDTO> allLocation = locationService.getAllLocation();
        System.out.println("Printing whatever");
        return allLocation;
    }




}
