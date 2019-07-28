package sda.repository;

import org.omg.PortableInterceptor.LOCATION_FORWARD;
import org.springframework.data.jpa.repository.JpaRepository;
import sda.entity.Location;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    Location findByName(String name);

}
