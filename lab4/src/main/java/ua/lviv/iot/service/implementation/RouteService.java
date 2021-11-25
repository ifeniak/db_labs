package ua.lviv.iot.service.implementation;

import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.DAO.implementation.RouteDAO;
import ua.lviv.iot.model.Route;
import ua.lviv.iot.service.Service;

import java.sql.SQLException;
import java.util.List;

public class RouteService implements Service<Route> {
    private final DAO<Route> dao = new RouteDAO();

    @Override
    public List<Route> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Route findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Route route) throws SQLException {
        dao.create(route);
    }

    @Override
    public void update(Route route) throws SQLException {
        dao.update(route);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
