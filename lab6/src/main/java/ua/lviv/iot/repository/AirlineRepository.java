package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Airline;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Integer> {
}
