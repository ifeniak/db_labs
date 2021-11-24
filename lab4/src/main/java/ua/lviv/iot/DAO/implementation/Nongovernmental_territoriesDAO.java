package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.model.City;
import ua.lviv.iot.model.Nongovernmental_territories;
import ua.lviv.iot.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Nongovernmental_territoriesDAO implements DAO<Nongovernmental_territories> {

    private static final String GET_ALL = "SELECT * FROM planes.nongovernmental_territories;";
    private static final String GET_BY_ID = "SELECT * FROM planes.nongovernmental_territories WHERE name = ?;";
    private static final String CREATE = "INSERT INTO planes.nongovernmental_territories " +
            "(name, type, danger_level)" + "VALUES (?, ?, ?);";
    private static final String UPDATE = "UPDATE planes.nongovernmental_territories " +
            "SET type = ?, danger_level = ? WHERE name = ?;";
    private static final String DELETE = "DELETE FROM planes.nongovernmental_territories WHERE name = ?;";

    @Override
    public List<Nongovernmental_territories> findAll() throws SQLException {
        List<Nongovernmental_territories> nongovernmental_territories = new ArrayList<>();

        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Nongovernmental_territories nongovernmental_territory = new Nongovernmental_territories(
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getString("danger_level"));
                nongovernmental_territories.add(nongovernmental_territory);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return nongovernmental_territories;
    }

    @Override
    public Nongovernmental_territories findById(String name) throws SQLException {
        Nongovernmental_territories nongovernmental_territory = null;

        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            st.setString(1, name);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                nongovernmental_territory = new Nongovernmental_territories(rs.getString("name"),
                        rs.getString("type"),
                        rs.getString("danger_level"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return nongovernmental_territory;
    }

    @Override
    public void create(Nongovernmental_territories nongovernmental_territory) throws SQLException {
        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            st.setString(1, nongovernmental_territory.getName());
            st.setString(2, nongovernmental_territory.getType());
            st.setString(3, nongovernmental_territory.getDanger_level());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Nongovernmental_territories nongovernmental_territory) throws SQLException {
        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            st.setString(1, nongovernmental_territory.getType());
            st.setString(2, nongovernmental_territory.getDanger_level());
            st.setString(3, nongovernmental_territory.getName());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(String name) throws SQLException {
        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            st.setString(1, name);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
