package sda.entity;

        import com.sun.org.glassfish.gmbal.NameValue;
        import org.hibernate.annotations.GenericGenerator;
        import javax.persistence.*;
        import java.util.List;

@Entity
@Table(name = "workitem")
public class Workitem {

    @Id
    @Column(name = "workitem_id", unique = true)
    Integer workitem_id;


    @Column ( name  = "workitem_name" )
    public String name;

    @Column ( name  = "workitem_fee" )
    public Integer workitem_fee;

    @Column ( name  = "workitem_duration" )
    public Integer workitem_duration;



}
