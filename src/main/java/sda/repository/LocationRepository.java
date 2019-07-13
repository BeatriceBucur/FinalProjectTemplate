package sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
