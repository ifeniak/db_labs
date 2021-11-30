package ua.lviv.iot.service.implementation;

import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.DAO.implementation.LocationDAO;
import ua.lviv.iot.model.Location;
import ua.lviv.iot.service.Service;

import java.sql.SQLException;
import java.util.List;

public class LocationService implements Service<Location> {
    private final DAO<Location> dao = new LocationDAO();

    @Override
    public List<Location> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Location findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Location location) throws SQLException {
        dao.create(location);
    }

    @Override
    public void update(Location location) throws SQLException {
        dao.update(location);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}