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

    @JoinColumn(name = "reservation_id", referencedColumnName = "id")
    private Workitem workitem;
}
