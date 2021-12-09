package ua.lviv.iot.service.implementation;

import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.DAO.implementation.AirlineDAO;
import ua.lviv.iot.model.Airline;
import ua.lviv.iot.service.Service;

import java.sql.SQLException;
import java.util.List;

public class AirlineService implements Service<Airline> {
    private final DAO<Airline> dao = new AirlineDAO();

    @Override
    public List<Airline> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Airline findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Airline airline) throws SQLException {
        dao.create(airline);
    }

    @Override
    public void update(Airline airline) throws SQLException {
        dao.update(airline);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}