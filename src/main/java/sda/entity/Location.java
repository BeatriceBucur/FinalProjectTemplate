package sda.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "location")
public class Location {
    @Id
    @Column(name = "location_id",
            unique = true,
            nullable = false)

    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator ="native")

    @GenericGenerator(
            name = "native" ,
            strategy = "native")

    public Integer id;

    @Column (name = "location_name")
    public String name;

    @Column (name = "location_adress")
    public String adress;

    @OneToOne
    public Reservation reservation;

    public Location (Integer id, String name, String adress){
        this.id = id;
        this.name = name;
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Location{" +
                "location_id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }

    public Location(){

    }


}
