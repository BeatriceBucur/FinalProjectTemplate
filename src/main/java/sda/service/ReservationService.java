package sda.service;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.entity.Location;
import sda.entity.Reservation;
import sda.entity.Workitem;
import sda.modelDTO.ReservationDTO;
import sda.repository.LocationRepository;
import sda.repository.ReservationRepository;
import sda.repository.WorkitemRepository;


import javax.persistence.TemporalType;
import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

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

        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String data = dateFormat.format(byId.get().getResDate()).substring(0,10);
        String hour = dateFormat.format((byId.get().getResDate())).substring(12);

        if(byId.isPresent()){
            Reservation reservation = byId.get();
            ReservationDTO.ReservationDTOBuilder rez = new ReservationDTO.ReservationDTOBuilder();
            ReservationDTO reservationDTO = rez.setId(id).setClientName(reservation.client_name).
                    setClientEmail(reservation.client_email).setReservationDay(data).setReservationHour(hour).setClientMobile(reservation.client_mobile).
                    setLocation(reservation.location).setWorkitem(reservation.workitem).build();
            return reservationDTO;

        }
        return new ReservationDTO();
    }

    public List<ReservationDTO> getAllReservation(){
        List<ReservationDTO> allReservations = new ArrayList<>();
        List<Reservation> all = reservationRepository.findAll();

        //TODO from date to string

        for (Reservation r : all){

            ReservationDTO.ReservationDTOBuilder rez = new ReservationDTO.ReservationDTOBuilder();
            ReservationDTO rezDTO = rez.setId(r.id).setClientName(r.client_name)
                    .setClientEmail(r.client_email).
                    setClientMobile(r.client_mobile).setLocation(r.location).setWorkitem(r.workitem).build();
            allReservations.add(rezDTO);
        }

        return allReservations;
    }

    public Reservation saveRes(ReservationDTO reservation) throws ParseException {
        Reservation res = new Reservation();
        // from string t date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm");
        Date dt1 = sdf.parse(reservation.getReservation_day() + " " + reservation.getReservation_hour());

        Workitem dtoWorkitem =
                workitemRepository.findWorkitemByName(reservation.getWorkitem());
        Location dtoLocation =
                locationRepository.findByName(reservation.getLocation());


        res.setName(reservation.getClient_name());
        res.setClient_email(reservation.getClient_email());
        res.setClient_mobile(reservation.getClient_mobile());
        res.setResDate(dt1);

        res.setLocation(dtoLocation);
        res.setWorkitem(dtoWorkitem);

        reservationRepository.save(res);

        return res;

    }



}
