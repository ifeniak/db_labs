package ua.lviv.iot.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Airline;
import ua.lviv.iot.domain.Airline;
import ua.lviv.iot.repository.AirlineRepository;
import ua.lviv.iot.repository.AirlineRepository;
import ua.lviv.iot.service.AbstractService;

@AllArgsConstructor
@Service
public class AirlineService extends AbstractService<Airline, Integer> {
    public AirlineRepository airlineRepository;

    @Override
    protected JpaRepository<Airline, Integer> getRepository() {
        return airlineRepository;
    }

    @Override
    public Airline update(Integer id, Airline airline) {
        if (getRepository().findById(id).isPresent()) {
            airline.setId(id);
            return getRepository().save(airline);
        }
        return null;
    }
}