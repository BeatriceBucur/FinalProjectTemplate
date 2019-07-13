package sda.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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
    Integer reservation_id;

    @Column(name = "client_name")
    String client_name;

    @Column(name = "client_email")
    String client_email;

    @Column(name = "client_mobile")
    Integer client_mobile;

    @Column(name = "location_id")
    Integer location_id;

    @Column(name = "workitem_id")
    Integer workitem_id;

/*
    @JoinColumn(name = "reservation_id", referencedColumnName = "id")
    public Workitem workitem_name;

 */
}
