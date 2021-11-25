package ua.lviv.iot.service.implementation;

import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.DAO.implementation.FlightDAO;
import ua.lviv.iot.model.Flight;
import ua.lviv.iot.service.Service;

import java.sql.SQLException;
import java.util.List;

public class FlightService implements Service<Flight> {
    private final DAO<Flight> dao = new FlightDAO();

    @Override
    public List<Flight> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Flight findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Flight flight) throws SQLException {
        dao.create(flight);
    }

    @Override
    public void update(Flight flight) throws SQLException {
        dao.update(flight);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
