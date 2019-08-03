package sda.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @Column(name = "reservation_id",
            unique = true
    )
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator = "native"
    )
    @GenericGenerator(name = "native",
            strategy = "native"
    )
    public Integer id;

    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "reservation")
    @OneToOne
    @JoinColumn(name = "location_id")
    public Location location;

    @Column(name = "client_name")
    public String client_name;

    @Column(name = "client_email")
    public String client_email;

    /*    @Column(name="reservation_day")
        public DateFormat reservation_day;

        @Column(name = "reservation_hour")
        public Time reservation_hour;*/
    @Column(name = "res_date")
    @Temporal(TemporalType.TIMESTAMP)
    Date resDate;

    @Column(name = "client_mobile")
    public Integer client_mobile;


    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "reservation")
    @OneToOne
    @JoinColumn(name = "workitem_id")
    public Workitem workitem;

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", location=" + location +
                ", client_name='" + client_name + '\'' +
                ", client_email='" + client_email + '\'' +

                ", client_mobile=" + client_mobile +
                ", workitem=" + workitem +
                '}';
    }

    public Reservation() {

    }

    public Location getLocation() {
        return location;
    }

    public Reservation setLocation(Location location) {
        this.location = location;
        return this;
    }

    public String getName() {
        return client_name;
    }

    public Reservation setName(String client_name) {
        this.client_name = client_name;
        return this;
    }

    public String getClient_email() {
        return client_email;
    }

    public Reservation setClient_email(String client_email) {
        this.client_email = client_email;
        return this;
    }


    public Integer getClient_mobile() {
        return client_mobile;
    }

    public Reservation setClient_mobile(Integer client_mobile) {
        this.client_mobile = client_mobile;
        return this;
    }

    public Workitem getWorkitem() {
        return workitem;
    }

    public Reservation setWorkitem(Workitem workitem) {
        this.workitem = workitem;
        return this;
    }



    public Date getResDate() {
        return resDate;
    }

    public Reservation setResDate(Date resDate) {
        this.resDate = resDate;
        return this;
    }

/*
    @JoinColumn(name = "reservation_id", referencedColumnName = "id")
    public Workitem workitem_name;

 */
}
