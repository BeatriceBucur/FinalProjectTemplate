package sda.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "workitem")
public class Workitem {


    @Id
    @Column(name = "workitem_id", unique = true)


    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "native")
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )

   public Integer id;


    @Column ( name  = "workitem_name" )
    public String name;

    @Column ( name  = "workitem_fee" )
    public Integer workitem_fee;

    @Column ( name  = "workitem_duration" )
    public Integer workitem_duration;


    @Override
    public String toString() {
        return "Workitem{" +
                "workitem_id=" + id +
                ", name='" + name + '\'' +
                ", workitem_fee=" + workitem_fee +
                ", workitem_duration=" + workitem_duration +
                '}';
    }

    public Workitem(){

    }
}
