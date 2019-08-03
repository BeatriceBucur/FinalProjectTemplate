package sda.modelDTO;

import sda.entity.Location;
import sda.entity.Workitem;

import java.sql.Time;
import java.text.DateFormat;


public class ReservationDTO {

    private Integer id;
    private String client_name;
    private String client_email;
    private Integer client_mobile;
    private String reservation_day;
    private String reservation_hour;
    private String location;
    private String workitem;

    public ReservationDTO(){

    }

    public static class ReservationDTOBuilder {
        private ReservationDTO reservationDTO = new ReservationDTO();

        public ReservationDTO build() {
            return reservationDTO;
        }



        public ReservationDTOBuilder setId(Integer id) {
            reservationDTO.id = id;
            return this;
        }

        public ReservationDTOBuilder setClientName(String nume_client ) {
            reservationDTO.client_name = nume_client;
            return this;
        }

        public ReservationDTOBuilder setReservationDay(String reservationDay){
            reservationDTO.reservation_day = reservationDay;
            return this;
        }

        public ReservationDTOBuilder setReservationHour(String reservationHour){
            reservationDTO.reservation_hour = reservationHour;
            return this;
        }

        public ReservationDTOBuilder setClientEmail(String client_email) {
            reservationDTO.client_email = client_email;
            return this;
        }

        public ReservationDTOBuilder setClientMobile(Integer client_mobile) {
            reservationDTO.client_mobile = client_mobile;
            return this;
        }

        public ReservationDTOBuilder setLocation(Location location) {
            reservationDTO.location = location.name;
            return this;
        }

        public ReservationDTOBuilder setWorkitem(Workitem workitem){
            reservationDTO.workitem = workitem.name;
            return this;
        }


    }



    public Integer getId() {
        return id;
    }

    public ReservationDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getClient_name() {
        return client_name;
    }

    public ReservationDTO setClient_name(String client_name) {
        this.client_name = client_name;
        return this;
    }

    public String getClient_email() {
        return client_email;
    }

    public ReservationDTO setClient_email(String client_email) {
        this.client_email = client_email;
        return this;
    }

    public Integer getClient_mobile() {
        return client_mobile;
    }

    public ReservationDTO setClient_mobile(Integer client_mobile) {
        this.client_mobile = client_mobile;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public ReservationDTO setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getWorkitem() {
        return workitem;
    }

    public ReservationDTO setWorkitem(String workitem) {
        this.workitem = workitem;
        return this;
    }

    public String getReservation_day() {
        return reservation_day;
    }

    public ReservationDTO setReservation_day(String reservation_day) {
        this.reservation_day = reservation_day;
        return this;
    }

    public String getReservation_hour() {
        return reservation_hour;
    }

    public ReservationDTO setReservation_hour(String reservation_hour) {
        this.reservation_hour = reservation_hour;
        return this;
    }
}

