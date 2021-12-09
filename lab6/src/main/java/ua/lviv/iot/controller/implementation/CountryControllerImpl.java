package ua.lviv.iot.controller.implementation;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.DTO.CountryDTO;
import ua.lviv.iot.DTO.CountryDTO;
import ua.lviv.iot.controller.AbstractControllerImpl;
import ua.lviv.iot.domain.Country;
import ua.lviv.iot.domain.Country;
import ua.lviv.iot.mapper.AbstractMapper;
import ua.lviv.iot.mapper.implementation.CountryMapper;
import ua.lviv.iot.service.AbstractService;
import ua.lviv.iot.service.implementation.CountryService;

@RequestMapping(value = "/countries")
@RestController
@AllArgsConstructor
public class CountryControllerImpl extends AbstractControllerImpl<Country, CountryDTO, String> {
    private final CountryService countryService;
    private final CountryMapper countryMapper;

    @Override
    public AbstractService<Country, String> getService() {
        return countryService;
    }

    @Override
    public AbstractMapper<Country, CountryDTO> getMapper() {
        return countryMapper;
    }
}
