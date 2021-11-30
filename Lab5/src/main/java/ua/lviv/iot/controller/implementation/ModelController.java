package ua.lviv.iot.controller.implementation;

import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.Model;
import ua.lviv.iot.service.Service;
import ua.lviv.iot.service.implementation.ModelService;

import java.sql.SQLException;
import java.util.List;

public class ModelController implements Controller<Model> {
    private final Service<Model> service = new ModelService();

    @Override
    public List<Model> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Model findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Model model) throws SQLException {
        service.create(model);
    }

    @Override
    public void update(Model model) throws SQLException {
        service.update(model);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
