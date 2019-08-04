package sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sda.entity.Reservation;
import sda.modelDTO.ReservationDTO;
import sda.service.ReservationService;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    ReservationService reservationService;


    @PostMapping(value = "/addReservations", consumes = "application/x-www-form-urlencoded")
    public String addReservation(Model model,@ModelAttribute ReservationDTO reservation) throws ParseException {


        Reservation reservationEntity = reservationService.saveRes(reservation);
        reservation.setId(reservationEntity.id);
        model.addAttribute("workitem", reservation.getWorkitem());
        model.addAttribute("reservation_hour",reservation.getReservation_hour());
        model.addAttribute("location",reservation.getLocation());
        model.addAttribute("reservation_day",reservation.getReservation_day());

       return "succes";

    }

    @GetMapping()
    public String homePage(Model model){
        List<ReservationDTO> allReservations = reservationService.getAllReservation();
        model.addAttribute("reservations", allReservations);
        return "reservations";
    }

   /* @GetMapping("/{reservation_id}")
    public String reservationPage(Model model, @PathVariable ("reservation_id")Integer id){
        List<ReservationDTO> allReservation = reservationService.getAllReservation();
        model.addAttribute("reservations",allReservation);
        return "home";
    }



    @GetMapping(value = "/json",produces = "application/json")
    @ResponseBody
    public List<ReservationDTO> getAllReservations(){
        List<ReservationDTO> allReservations = reservationService.getAllReservation();
        System.out.println("Print print");
        return allReservations;
    }

    @RequestMapping(value = "/reservations", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("reservationsHome", "reservations", new Reservation());
    }

    @RequestMapping(value = "/addReservation", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("reservations")Reservation reservation,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("name", reservation.getName());
        model.addAttribute("email", reservation.getClient_email());
        model.addAttribute("contactNumber", reservation.getClient_mobile());
        model.addAttribute("location", reservation.getLocation());
        model.addAttribute("workitem", reservation.getWorkitem());
        return "reservationView";
    }**/



}







