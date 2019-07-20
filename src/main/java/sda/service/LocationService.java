package sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.entity.Location;
import sda.modelDTO.LocationDTO;
import sda.repository.LocationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    public LocationDTO getLocationById(Integer id) {
        Optional<Location> byId = locationRepository.findById(id);

        if (byId.isPresent()) {
            return new LocationDTO(byId.get().name,byId.get().id);
        }
        return new LocationDTO("Nowhere",0);

    }

    public List<LocationDTO> getAllLocation(){
        List<LocationDTO> allLocation = new ArrayList<>();

        List<Location> all = locationRepository.findAll();

        for(Location l : all){
            allLocation.add(new LocationDTO(l.name,l.id));
        }

        return allLocation;
    }
}
