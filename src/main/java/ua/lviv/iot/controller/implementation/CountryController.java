package ua.lviv.iot.controller.implementation;

import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.Country;
import ua.lviv.iot.service.Service;
import ua.lviv.iot.service.implementation.CountryService;

import java.sql.SQLException;
import java.util.List;

public class CountryController implements Controller<Country> {

    private final Service<Country> service = new CountryService();

    @Override
    public List<Country> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Country findById(String name) throws SQLException {
        return service.findById(name);
    }

    @Override
    public void create(Country country) throws SQLException {
        service.create(country);
    }

    @Override
    public void update(Country country) throws SQLException {
        service.update(country);
    }

    @Override
    public void delete(String name) throws SQLException {
        service.delete(name);
    }

}
