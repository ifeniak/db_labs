package ua.lviv.iot.controller.implementation;

import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.Location;
import ua.lviv.iot.service.Service;
import ua.lviv.iot.service.implementation.LocationService;

import java.sql.SQLException;
import java.util.List;

public class LocationController implements Controller<Location> {
    private final Service<Location> service = new LocationService();

    @Override
    public List<Location> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Location findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Location location) throws SQLException {
        service.create(location);
    }

    @Override
    public void update(Location location) throws SQLException {
        service.update(location);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}