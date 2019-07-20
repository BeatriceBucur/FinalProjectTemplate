package sda.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.engine.spi.CascadingAction;

import javax.persistence.*;
import java.util.List;

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

    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "reservation")
    @OneToOne
    @JoinColumn(name="location_id")
    Location location;

    @Column(name = "client_name")
    String client_name;

    @Column(name = "client_email")
    String client_email;

    @Column(name = "client_mobile")
    Integer client_mobile;


    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "reservation")
    @OneToOne
    @JoinColumn(name="workitem_id")
    Workitem workitem;

    @Override
    public String toString() {
        return "Reservation{" +
                "reservation_id=" + reservation_id +
                ", location=" + location +
                ", client_name='" + client_name + '\'' +
                ", client_email='" + client_email + '\'' +
                ", client_mobile=" + client_mobile +
                '}';
    }

    public Reservation(){

    }

    /*
    @JoinColumn(name = "reservation_id", referencedColumnName = "id")
    public Workitem workitem_name;

 */
}
