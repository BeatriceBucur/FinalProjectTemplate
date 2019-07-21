package sda.modelDTO;

import sda.entity.Workitem;

public class WorkitemDTO {

    //fields
   private String name;
   private Integer id;

    //constructor
    public WorkitemDTO (String name, Integer id){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    //method
}
