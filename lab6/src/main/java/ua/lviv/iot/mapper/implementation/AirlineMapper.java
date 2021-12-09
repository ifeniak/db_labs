package ua.lviv.iot.mapper.implementation;

import org.springframework.stereotype.Component;
import ua.lviv.iot.domain.Airline;
import ua.lviv.iot.mapper.AbstractMapper;
import ua.lviv.iot.DTO.AirlineDTO;

@Component
public class AirlineMapper implements AbstractMapper<Airline, AirlineDTO> {
    @Override
    public AirlineDTO mapObjectToDTO(Airline airline) {
        if (airline == null) {
            return null;
        }
        AirlineDTO.AirlineDTOBuilder airlineDTOBuilder = AirlineDTO.builder();
        airlineDTOBuilder.id(airline.getId());
        airlineDTOBuilder.name(airline.getName());
        airlineDTOBuilder.capitalization(airline.getCapitalization());
        airlineDTOBuilder.countryByCountryName(airline.getCountryByCountryName().getName());
        return airlineDTOBuilder.build();
    }
}

