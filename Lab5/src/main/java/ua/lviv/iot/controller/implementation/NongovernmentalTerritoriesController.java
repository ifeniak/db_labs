package ua.lviv.iot.controller.implementation;

import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.NongovernmentalTerritories;
import ua.lviv.iot.service.Service;
import ua.lviv.iot.service.implementation.NongovernmentalTerritoriesService;

import java.sql.SQLException;
import java.util.List;

public class NongovernmentalTerritoriesController implements Controller<NongovernmentalTerritories> {

    private final Service<NongovernmentalTerritories> service = new NongovernmentalTerritoriesService();

    @Override
    public List<NongovernmentalTerritories> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public NongovernmentalTerritories findById(String name) throws SQLException {
        return service.findById(name);
    }

    @Override
    public void create(NongovernmentalTerritories nongovernmental_territories) throws SQLException {
        service.create(nongovernmental_territories);
    }

    @Override
    public void update(NongovernmentalTerritories nongovernmental_territories) throws SQLException {
        service.update(nongovernmental_territories);
    }

    @Override
    public void delete(String name) throws SQLException {
        service.delete(name);
    }
}