package sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.entity.Location;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {



}
