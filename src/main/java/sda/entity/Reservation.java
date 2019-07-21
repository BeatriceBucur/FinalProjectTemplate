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
   public Integer id;

    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "reservation")
    @OneToOne
    @JoinColumn(name="location_id")
    public Location location;

    @Column(name = "client_name")
    public String client_name;

    @Column(name = "client_email")
    public String client_email;

    @Column(name = "client_mobile")
    public Integer client_mobile;


    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "reservation")
    @OneToOne
    @JoinColumn(name="workitem_id")
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

    public Reservation(){

    }

    /*
    @JoinColumn(name = "reservation_id", referencedColumnName = "id")
    public Workitem workitem_name;

 */
}
