package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.model.Location;
import ua.lviv.iot.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LocationDAO implements DAO<Location> {

    private static final String GET_ALL = "SELECT * FROM planes.location;";
    private static final String GET_BY_ID = "SELECT * FROM planes.location WHERE id = ?;";
    private static final String CREATE = "INSERT INTO planes.location" +
            "(speed, latitude, longitude, governmental_territories, nongovernmental_territories, plane_id) " +
            "VALUES (?, ?, ?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE planes.location " + "SET speed = ?, latitude = ?, longitude = ?, " +
            "governmental_territories = ?, nongovernmental_territories = ?, plane_id = ? WHERE id = ?;";
    private static final String DELETE = "DELETE FROM planes.location WHERE id = ?;";

    @Override
    public List<Location> findAll() throws SQLException {
        List<Location> locations = new ArrayList<>();

        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Location location = new Location(
                        rs.getInt("id"),
                        rs.getDouble("speed"),
                        rs.getDouble("latitude"),
                        rs.getDouble("longitude"),
                        rs.getString("governmental_territories"),
                        rs.getString("nongovernmental_territories"),
                        rs.getInt("plane_id"));
                locations.add(location);
            }
        }
        return locations;
    }

    @Override
    public Location findById(Integer id) throws SQLException {
        Location location = null;

        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                location = new Location(
                        rs.getInt("id"),
                        rs.getDouble("speed"),
                        rs.getDouble("latitude"),
                        rs.getDouble("longitude"),
                        rs.getString("governmental_territories"),
                        rs.getString("nongovernmental_territories"),
                        rs.getInt("plane_id")
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return location;
    }

    @Override
    public void create(Location location) throws SQLException {
        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            st.setDouble(1, location.getSpeed());
            st.setDouble(2, location.getLatitude());
            st.setDouble(3, location.getLongitude());
            st.setString(4, location.getGovernmental_territories());
            st.setString(5, location.getNongovernmental_territories());
            st.setInt(6, location.getPlane_id());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Location location) throws SQLException {
        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            st.setDouble(1, location.getSpeed());
            st.setDouble(2, location.getLatitude());
            st.setDouble(3, location.getLongitude());
            st.setString(4, location.getGovernmental_territories());
            st.setString(5, location.getNongovernmental_territories());
            st.setInt(6, location.getPlane_id());
            st.setInt(7, location.getId());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
