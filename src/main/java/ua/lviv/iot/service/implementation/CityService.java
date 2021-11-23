package ua.lviv.iot.service.implementation;

import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.DAO.implementation.CityDAO;
import ua.lviv.iot.model.City;
import ua.lviv.iot.service.Service;

import java.sql.SQLException;
import java.util.List;

public class CityService implements Service<City> {

    private final DAO<City> dao = new CityDAO();

    @Override
    public List<City> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public City findById(String name) throws SQLException{
        return dao.findById(name);
    }

    @Override
    public void create(City city) throws SQLException {
        dao.create(city);
    }

    @Override
    public void update(City city) throws SQLException {
        dao.update(city);
    }

    @Override
    public void delete(String name) throws SQLException {
        dao.delete(name);
    }
}
