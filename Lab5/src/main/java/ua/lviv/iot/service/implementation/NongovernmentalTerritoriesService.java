package ua.lviv.iot.service.implementation;

import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.DAO.implementation.NongovernmentalTerritoriesDAO;
import ua.lviv.iot.model.NongovernmentalTerritories;
import ua.lviv.iot.service.Service;

import java.sql.SQLException;
import java.util.List;

public class NongovernmentalTerritoriesService implements Service<NongovernmentalTerritories> {

    private final DAO<NongovernmentalTerritories> dao = new NongovernmentalTerritoriesDAO();

    @Override
    public List<NongovernmentalTerritories> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public NongovernmentalTerritories findById(String name) throws SQLException{
        return dao.findById(name);
    }

    @Override
    public void create(NongovernmentalTerritories nongovernmental_territories) throws SQLException {
        dao.create(nongovernmental_territories);
    }

    @Override
    public void update(NongovernmentalTerritories nongovernmental_territories) throws SQLException {
        dao.update(nongovernmental_territories);
    }

    @Override
    public void delete(String name) throws SQLException {
        dao.delete(name);
    }
}