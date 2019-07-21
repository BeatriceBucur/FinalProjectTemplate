package sda.modelDTO;

import sda.entity.Location;
import sda.entity.Workitem;


public class ReservationDTO {

    private Integer id;
    private String client_name;
    private String client_email;
    private Integer client_mobile;
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

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "id=" + id +
                ", client_name='" + client_name + '\'' +
                ", client_email='" + client_email + '\'' +
                ", client_mobile=" + client_mobile +
                ", location='" + location + '\'' +
                ", workitem='" + workitem + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getClient_name() {
        return client_name;
    }

    public String getClient_email() {
        return client_email;
    }

    public Integer getClient_mobile() {
        return client_mobile;
    }

    public String  getLocation() {
        return location;
    }

    public String  getWorkitem() {
        return workitem;
    }
}

