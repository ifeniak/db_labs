package ua.lviv.iot.service.implementation;

import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.DAO.implementation.CityDAO;
import ua.lviv.iot.DAO.implementation.Nongovernmental_territoriesDAO;
import ua.lviv.iot.model.City;
import ua.lviv.iot.model.Nongovernmental_territories;
import ua.lviv.iot.service.Service;

import java.sql.SQLException;
import java.util.List;

public class Nongovernmental_territoriesService implements Service<Nongovernmental_territories> {

    private final DAO<Nongovernmental_territories> dao = new Nongovernmental_territoriesDAO();

    @Override
    public List<Nongovernmental_territories> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Nongovernmental_territories findById(String name) throws SQLException{
        return dao.findById(name);
    }

    @Override
    public void create(Nongovernmental_territories nongovernmental_territories) throws SQLException {
        dao.create(nongovernmental_territories);
    }

    @Override
    public void update(Nongovernmental_territories nongovernmental_territories) throws SQLException {
        dao.update(nongovernmental_territories);
    }

    @Override
    public void delete(String name) throws SQLException {
        dao.delete(name);
    }
}
