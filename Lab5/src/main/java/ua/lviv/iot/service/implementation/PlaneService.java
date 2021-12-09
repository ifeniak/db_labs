package ua.lviv.iot.service.implementation;

import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.DAO.implementation.PlaneDAO;
import ua.lviv.iot.model.Plane;
import ua.lviv.iot.service.Service;

import java.sql.SQLException;
import java.util.List;

public class PlaneService implements Service<Plane> {
    private final DAO<Plane> dao = new PlaneDAO();

    @Override
    public List<Plane> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Plane findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Plane plane) throws SQLException {
        dao.create(plane);
    }

    @Override
    public void update(Plane plane) throws SQLException {
        dao.update(plane);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}