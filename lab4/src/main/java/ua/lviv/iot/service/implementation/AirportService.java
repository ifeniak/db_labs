package ua.lviv.iot.service.implementation;

import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.DAO.implementation.AirportDAO;
import ua.lviv.iot.model.Airport;
import ua.lviv.iot.service.Service;

import java.sql.SQLException;
import java.util.List;

public class AirportService implements Service<Airport> {

    private final DAO<Airport> dao = new AirportDAO();

    @Override
    public List<Airport> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Airport findById(String name) throws SQLException{
        return dao.findById(name);
    }

    @Override
    public void create(Airport airport) throws SQLException {
        dao.create(airport);
    }

    @Override
    public void update(Airport airport) throws SQLException {
        dao.update(airport);
    }

    @Override
    public void delete(String name) throws SQLException {
        dao.delete(name);
    }
}
