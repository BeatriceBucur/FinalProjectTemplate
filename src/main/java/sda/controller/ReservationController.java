package sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sda.modelDTO.ReservationDTO;
import sda.service.ReservationService;

import java.util.List;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping("/{reservation_id}")
    public String reservationPage(Model model, @PathVariable ("reservation_id")Integer id){
        List<ReservationDTO> allReservation = reservationService.getAllReservation();
        model.addAttribute("reservations",allReservation);
        return "home";
    }

    @GetMapping("/reservationsHome")
    public String homePage(Model model){
        List<ReservationDTO> allReservations = reservationService.getAllReservation();
        model.addAttribute("reservations", allReservations);
        return "reservations";

    }

    @GetMapping(value = "/json",produces = "application/json")
    @ResponseBody
    public List<ReservationDTO> getAllReservations(){
        List<ReservationDTO> allReservations = reservationService.getAllReservation();
        System.out.println("Print print");
        return allReservations;
    }






}
