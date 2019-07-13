package sda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @Column(name = "location_id")
    Integer location_id;
    @Column(name = "location_name")
    String location_name;


//Ceva undeva

}
