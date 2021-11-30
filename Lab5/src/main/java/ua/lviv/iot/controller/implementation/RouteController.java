package ua.lviv.iot.controller.implementation;

import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.Route;
import ua.lviv.iot.service.Service;
import ua.lviv.iot.service.implementation.RouteService;

import java.sql.SQLException;
import java.util.List;

public class RouteController implements Controller<Route> {
    private final Service<Route> service = new RouteService();

    @Override
    public List<Route> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Route findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Route route) throws SQLException {
        service.create(route);
    }

    @Override
    public void update(Route route) throws SQLException {
        service.update(route);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}