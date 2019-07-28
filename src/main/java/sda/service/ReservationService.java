package sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.entity.Location;
import sda.entity.Reservation;
import sda.entity.Workitem;
import sda.modelDTO.ReservationDTO;
import sda.repository.LocationRepository;
import sda.repository.ReservationRepository;
import sda.repository.WorkitemRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    ReservationService reservationService;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    WorkitemRepository workitemRepository;



    public ReservationDTO getReservationById(Integer id){
        Optional<Reservation> byId = reservationRepository.findById(id);



        if(byId.isPresent()){
            Reservation reservation = byId.get();
            ReservationDTO.ReservationDTOBuilder rez = new ReservationDTO.ReservationDTOBuilder();
            ReservationDTO reservationDTO = rez.setId(id).setClientName(reservation.client_name).
                    setClientEmail(reservation.client_email).setClientMobile(reservation.client_mobile).
                    setLocation(reservation.location).setWorkitem(reservation.workitem).build();
            return reservationDTO;

        }
        return new ReservationDTO();
    }

    public List<ReservationDTO> getAllReservation(){
        List<ReservationDTO> allReservations = new ArrayList<>();
        List<Reservation> all = reservationRepository.findAll();

        for (Reservation r : all){

            ReservationDTO.ReservationDTOBuilder rez = new ReservationDTO.ReservationDTOBuilder();
            ReservationDTO rezDTO = rez.setId(r.id).setClientName(r.client_name).setClientEmail(r.client_email).
                    setClientMobile(r.client_mobile).setLocation(r.location).setWorkitem(r.workitem).build();
            allReservations.add(rezDTO);
        }

        return allReservations;
    }

    public Reservation saveRes(ReservationDTO reservation) {
        Reservation res = new Reservation();

        Workitem dtoWorkitem =
                workitemRepository.findWorkitemByName(reservation.getWorkitem());
        Location dtoLocation =
                locationRepository.findByName(reservation.getLocation());


        res.setName(reservation.getClient_name());
        res.setClient_email(reservation.getClient_email());
        res.setClient_mobile(reservation.getClient_mobile());
        res.setLocation(dtoLocation);
        res.setWorkitem(dtoWorkitem);

        reservationRepository.save(res);

        return res;

    }
}
