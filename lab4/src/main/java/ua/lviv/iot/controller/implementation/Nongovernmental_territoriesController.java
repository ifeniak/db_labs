package ua.lviv.iot.controller.implementation;

import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.City;
import ua.lviv.iot.model.Nongovernmental_territories;
import ua.lviv.iot.service.Service;
import ua.lviv.iot.service.implementation.CityService;
import ua.lviv.iot.service.implementation.Nongovernmental_territoriesService;

import java.sql.SQLException;
import java.util.List;

public class Nongovernmental_territoriesController implements Controller<Nongovernmental_territories> {

    private final Service<Nongovernmental_territories> service = new Nongovernmental_territoriesService();

    @Override
    public List<Nongovernmental_territories> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Nongovernmental_territories findById(String name) throws SQLException {
        return service.findById(name);
    }

    @Override
    public void create(Nongovernmental_territories nongovernmental_territories) throws SQLException {
        service.create(nongovernmental_territories);
    }

    @Override
    public void update(Nongovernmental_territories nongovernmental_territories) throws SQLException {
        service.update(nongovernmental_territories);
    }

    @Override
    public void delete(String name) throws SQLException {
        service.delete(name);
    }
}
