package ua.lviv.iot.controller.implementation;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.DTO.AirlineDTO;
import ua.lviv.iot.DTO.ModelDTO;
import ua.lviv.iot.controller.AbstractControllerImpl;
import ua.lviv.iot.domain.Airline;
import ua.lviv.iot.domain.Model;
import ua.lviv.iot.mapper.AbstractMapper;
import ua.lviv.iot.mapper.implementation.AirlineMapper;
import ua.lviv.iot.mapper.implementation.ModelMapper;
import ua.lviv.iot.service.AbstractService;
import ua.lviv.iot.service.implementation.AirlineService;
import ua.lviv.iot.service.implementation.ModelService;

@RequestMapping(value = "/airlines")
@RestController
@AllArgsConstructor
public class AirlineControllerImpl extends AbstractControllerImpl<Airline, AirlineDTO, Integer> {
    private final AirlineService airlineService;
    private final AirlineMapper airlineMapper;

    @Override
    public AbstractService<Airline, Integer> getService() {
        return airlineService;
    }

    @Override
    public AbstractMapper<Airline, AirlineDTO> getMapper() {
        return airlineMapper;
    }
}
