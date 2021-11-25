package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.model.Plane_flight_history;
import ua.lviv.iot.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Plane_flight_historyDAO implements DAO<Plane_flight_history> {
    private static final String GET_ALL = "SELECT * FROM planes.plane_flight_history;";
    private static final String GET_BY_ID = "SELECT * FROM planes.plane_flight_history " +
            "WHERE (plane_id = ? and flight_id = ?);";
    private static final String CREATE = "INSERT INTO planes.plane_flight_history " + "(plane_id, flight_id) " +
            "VALUES(?, ?);";
    private static final String DELETE = "DELETE FROM planes.plane_flight_history WHERE (plane_id = ? and flight_id = ?);"
            ;

    @Override
    public List<Plane_flight_history> findAll() throws SQLException {
        List<Plane_flight_history> plane_flight_histories = new ArrayList<>();

        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Plane_flight_history plane_flight_history = new Plane_flight_history(
                        rs.getInt("plane_id"),
                        rs.getInt("flight_id")
                );
                plane_flight_histories.add(plane_flight_history);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return plane_flight_histories;
    }

    @Override
    public Plane_flight_history findById(Integer firstId, Integer secondId) throws SQLException {
        Plane_flight_history plane_flight_history = null;

        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            st.setInt(1, firstId);
            st.setInt(2, secondId);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                plane_flight_history = new Plane_flight_history(
                        rs.getInt("plane_id"),
                        rs.getInt("flight_id")
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return plane_flight_history;
    }

    @Override
    public void create(Plane_flight_history plane_flight_history) throws SQLException {
        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            st.setInt(1, plane_flight_history.getPlane_id());
            st.setInt(2, plane_flight_history.getFlight_id());
            st.executeUpdate();
        }
    }

    @Override
    public void delete(Integer firstId, Integer secondId) throws SQLException {
        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            st.setInt(1, firstId);
            st.setInt(2, secondId);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
