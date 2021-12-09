package ua.lviv.iot.service.implementation;

import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.DAO.implementation.PlaneFlightHistoryDAO;
import ua.lviv.iot.model.PlaneFlightHistory;
import ua.lviv.iot.service.Service;

import java.sql.SQLException;
import java.util.List;

public class PlaneFlightHistoryService implements Service<PlaneFlightHistory> {
    private final DAO<PlaneFlightHistory> dao = new PlaneFlightHistoryDAO();

    @Override
    public List<PlaneFlightHistory> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public PlaneFlightHistory findById(Integer firstId, Integer secondId) throws SQLException {
        return dao.findById(firstId, secondId);
    }

    @Override
    public void create(PlaneFlightHistory plane_flight_history) throws SQLException {
        dao.create(plane_flight_history);
    }

    @Override
    public void delete(Integer firstId, Integer secondId) throws SQLException{
        dao.delete(firstId, secondId);
    }
}