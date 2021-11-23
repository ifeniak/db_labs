package ua.lviv.iot.controller.implementation;

import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.City;
import ua.lviv.iot.model.Country;
import ua.lviv.iot.service.Service;
import ua.lviv.iot.service.implementation.CityService;
import ua.lviv.iot.service.implementation.CountryService;

import java.sql.SQLException;
import java.util.List;

public class CityController implements Controller<City> {

    private final Service<City> service = new CityService();

    @Override
    public List<City> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public City findById(String name) throws SQLException {
        return service.findById(name);
    }

    @Override
    public void create(City city) throws SQLException {
        service.create(city);
    }

    @Override
    public void update(City city) throws SQLException {
        service.update(city);
    }

    @Override
    public void delete(String name) throws SQLException {
        service.delete(name);
    }

}
