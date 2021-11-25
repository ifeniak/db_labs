package ua.lviv.iot.service.implementation;

import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.DAO.implementation.Plane_flight_historyDAO;
import ua.lviv.iot.model.Plane_flight_history;
import ua.lviv.iot.service.Service;

import java.sql.SQLException;
import java.util.List;

public class Plane_flight_historyService implements Service<Plane_flight_history> {
    private final DAO<Plane_flight_history> dao = new Plane_flight_historyDAO();

    @Override
    public List<Plane_flight_history> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Plane_flight_history findById(Integer firstId, Integer secondId) throws SQLException {
        return dao.findById(firstId, secondId);
    }

    @Override
    public void create(Plane_flight_history plane_flight_history) throws SQLException {
        dao.create(plane_flight_history);
    }

    @Override
    public void delete(Integer firstId, Integer secondId) throws SQLException{
        dao.delete(firstId, secondId);
    }
}
