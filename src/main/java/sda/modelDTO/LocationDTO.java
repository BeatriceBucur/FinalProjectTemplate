package sda.modelDTO;

public class LocationDTO {

    private String name;
    private Integer id;

    public LocationDTO (String name, Integer id){
        this.name = name;
        this.id= id;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }
}
