package ua.lviv.iot.controller.implementation;

import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.Airport;
import ua.lviv.iot.model.City;
import ua.lviv.iot.model.Country;
import ua.lviv.iot.service.Service;
import ua.lviv.iot.service.implementation.AirportService;
import ua.lviv.iot.service.implementation.CityService;
import ua.lviv.iot.service.implementation.CountryService;

import java.sql.SQLException;
import java.util.List;

public class AirportController implements Controller<Airport> {

    private final Service<Airport> service = new AirportService();

    @Override
    public List<Airport> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Airport findById(String name) throws SQLException {
        return service.findById(name);
    }

    @Override
    public void create(Airport airport) throws SQLException {
        service.create(airport);
    }

    @Override
    public void update(Airport airport) throws SQLException {
        service.update(airport);
    }

    @Override
    public void delete(String name) throws SQLException {
        service.delete(name);
    }
}
