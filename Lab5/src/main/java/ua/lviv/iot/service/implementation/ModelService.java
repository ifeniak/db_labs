package ua.lviv.iot.service.implementation;

import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.DAO.implementation.ModelDAO;
import ua.lviv.iot.model.Model;
import ua.lviv.iot.service.Service;

import java.sql.SQLException;
import java.util.List;

public class ModelService implements Service<Model> {
    private final DAO<Model> dao = new ModelDAO();

    @Override
    public List<Model> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Model findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Model model) throws SQLException {
        dao.create(model);
    }

    @Override
    public void update(Model model) throws SQLException {
        dao.update(model);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
