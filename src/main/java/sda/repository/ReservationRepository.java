package sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
