package ua.lviv.iot.mapper.implementation;

import org.springframework.stereotype.Component;
import ua.lviv.iot.DTO.CountryDTO;
import ua.lviv.iot.domain.Country;
import ua.lviv.iot.mapper.AbstractMapper;

@Component
public class CountryMapper implements AbstractMapper<Country, CountryDTO> {
    @Override
    public CountryDTO mapObjectToDTO(Country country) {
        if (country == null) {
            return null;
        }
        CountryDTO.CountryDTOBuilder countryDTOBuilder = CountryDTO.builder();
        countryDTOBuilder.name(country.getName());
        countryDTOBuilder.gdp(country.getGdp());
        countryDTOBuilder.size(country.getSize());
        countryDTOBuilder.population(country.getPopulation());
        return countryDTOBuilder.build();
    }
}
