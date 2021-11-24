package ua.lviv.iot.controller.implementation;

import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.Airline;
import ua.lviv.iot.model.Flight;
import ua.lviv.iot.service.Service;
import ua.lviv.iot.service.implementation.AirlineService;
import ua.lviv.iot.service.implementation.FlightService;

import java.sql.SQLException;
import java.util.List;

public class FlightController implements Controller<Flight> {
    private final Service<Flight> service = new FlightService();

    @Override
    public List<Flight> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Flight findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Flight flight) throws SQLException {
        service.create(flight);
    }

    @Override
    public void update(Flight flight) throws SQLException {
        service.update(flight);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
