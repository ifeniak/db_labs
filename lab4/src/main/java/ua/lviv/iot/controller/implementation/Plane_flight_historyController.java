package ua.lviv.iot.controller.implementation;

import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.Plane_flight_history;
import ua.lviv.iot.service.Service;
import ua.lviv.iot.service.implementation.Plane_flight_historyService;

import java.sql.SQLException;
import java.util.List;

public class Plane_flight_historyController implements Controller<Plane_flight_history> {
    private final Service<Plane_flight_history> service = new Plane_flight_historyService();

    @Override
    public List<Plane_flight_history> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Plane_flight_history findById(Integer firstId, Integer secondId) throws SQLException {
        return service.findById(firstId, secondId);
    }

    @Override
    public void create(Plane_flight_history plane_flight_history) throws SQLException {
        service.create(plane_flight_history);
    }

    @Override
    public void delete(Integer firstId, Integer secondId) throws SQLException {
        service.delete(firstId, secondId);
    }
}
