package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.model.Plane;
import ua.lviv.iot.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaneDAO implements DAO<Plane> {
    private static final String GET_ALL = "SELECT * FROM planes.plane;";
    private static final String GET_BY_ID = "SELECT * FROM planes.plane WHERE id = ?;";
    private static final String CREATE = "INSERT INTO planes.plane " + "(`name`, `model_id`, `airline_id`, " +
            "`kilometrage`, `aircraft_registration`)" + "VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE planes.plane "
            + "SET `name` = ?,  `model_id` = ?, `airline_id`= ?, `kilometrage`= ?, `aircraft_registration`= ?" +
            "WHERE `id` = ?;";
    private static final String DELETE = "DELETE FROM planes.plane WHERE `id` = ?;";

    @Override
    public List<Plane> findAll() throws SQLException {
        List<Plane> planes = new ArrayList<Plane>();

        try(PreparedStatement st = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Plane plane = new Plane(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("model_id"),
                        rs.getInt("airline_id"),
                        rs.getInt("kilometrage"),
                        rs.getString("aircraft_registration"));
                planes.add(plane);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return planes;
    }

    @Override
    public Plane findById(Integer id) throws SQLException {
        Plane plane = null;

        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                plane = new Plane(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("model_id"),
                        rs.getInt("airline_id"),
                        rs.getInt("kilometrage"),
                        rs.getString("aircraft_registration"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return plane;
    }

    @Override
    public void create(Plane plane) throws SQLException {
        try(PreparedStatement st = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            st.setString(1, plane.getName());
            st.setInt(2,plane.getModel_id());
            st.setInt(3, plane.getAirline_id());
            st.setInt(4, plane.getKilometrage());
            st.setString(5, plane.getAircraft_registration());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Plane plane) throws SQLException {
        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            st.setString(1, plane.getName());
            st.setInt(2,plane.getModel_id());
            st.setInt(3, plane.getAirline_id());
            st.setInt(4, plane.getKilometrage());
            st.setString(5, plane.getAircraft_registration());
            st.setInt(6, plane.getId());
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
