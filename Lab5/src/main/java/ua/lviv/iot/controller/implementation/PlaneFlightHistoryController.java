package ua.lviv.iot.controller.implementation;

import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.PlaneFlightHistory;
import ua.lviv.iot.service.Service;
import ua.lviv.iot.service.implementation.PlaneFlightHistoryService;

import java.sql.SQLException;
import java.util.List;

public class PlaneFlightHistoryController implements Controller<PlaneFlightHistory> {
    private final Service<PlaneFlightHistory> service = new PlaneFlightHistoryService();

    @Override
    public List<PlaneFlightHistory> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public PlaneFlightHistory findById(Integer firstId, Integer secondId) throws SQLException {
        return service.findById(firstId, secondId);
    }

    @Override
    public void create(PlaneFlightHistory plane_flight_history) throws SQLException {
        service.create(plane_flight_history);
    }

    @Override
    public void delete(Integer firstId, Integer secondId) throws SQLException {
        service.delete(firstId, secondId);
    }
}