package ua.lviv.iot.controller.implementation;

import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.Airline;
import ua.lviv.iot.service.Service;
import ua.lviv.iot.service.implementation.AirlineService;

import java.sql.SQLException;
import java.util.List;

public class AirlineController implements Controller<Airline> {
    private final Service<Airline> service = new AirlineService();

    @Override
    public List<Airline> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Airline findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Airline airline) throws SQLException {
        service.create(airline);
    }

    @Override
    public void update(Airline airline) throws SQLException {
        service.update(airline);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
