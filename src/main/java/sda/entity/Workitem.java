package sda.entity;

        import org.hibernate.annotations.GenericGenerator;
        import javax.persistence.*;

@Entity
@Table(name = "workitem")
public class Workitem {

    @Id
    @Column(name = "workitem_id",
            unique = true
    )
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator = "native"
    )
    @GenericGenerator(name = "native",
            strategy = "native"
    )

    Integer workitem_id;
    String workitem_name;

    /*
    mapez unu la unu un workitem de o rezervare pentru ca,
    in ipoteza noastra simplificata de lucru, avem fie serviciul
    de haircut, fie cel de shave, fie al 3-lea serviciu care este
    suma celor 2 si se numeste Haircut-and-Shave. asa ca in realitate,
    pentru o rezervare nu pot avea decat un singur tip de serviciu
    */

    @OneToOne
    @JoinColumn(name = "workitem_id")
    Reservation reservation;

}
