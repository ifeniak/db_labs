package ua.lviv.iot.controller.implementation;

import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.Model;
import ua.lviv.iot.model.Plane;
import ua.lviv.iot.service.Service;
import ua.lviv.iot.service.implementation.ModelService;
import ua.lviv.iot.service.implementation.PlaneService;

import java.sql.SQLException;
import java.util.List;

public class PlaneController implements Controller<Plane> {
    private final Service<Plane> service = new PlaneService();

    @Override
    public List<Plane> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Plane findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Plane plane) throws SQLException {
        service.create(plane);
    }

    @Override
    public void update(Plane plane) throws SQLException {
        service.update(plane);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}