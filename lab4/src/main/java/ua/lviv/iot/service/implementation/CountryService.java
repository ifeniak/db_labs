package ua.lviv.iot.service.implementation;

import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.DAO.implementation.CountryDAO;
import ua.lviv.iot.model.Country;
import ua.lviv.iot.service.Service;

import java.sql.SQLException;
import java.util.List;

public class CountryService implements Service<Country> {

    private final DAO<Country> dao = new CountryDAO();

    @Override
    public List<Country> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Country findById(String name) throws SQLException{
        return dao.findById(name);
    }

    @Override
    public void create(Country country) throws SQLException {
        dao.create(country);
    }

    @Override
    public void update(Country country) throws SQLException {
        dao.update(country);
    }

    @Override
    public void delete(String name) throws SQLException {
        dao.delete(name);
    }
}
