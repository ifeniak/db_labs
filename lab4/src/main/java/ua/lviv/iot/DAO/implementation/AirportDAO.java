package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.model.Airport;
import ua.lviv.iot.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirportDAO implements DAO<Airport> {

    private static final String GET_ALL = "SELECT * FROM planes.airport;";
    private static final String GET_BY_ID = "SELECT * FROM planes.airport WHERE name = ?;";
    private static final String CREATE = "INSERT INTO planes.airport " +
            "(name, quality, planes_capacity, city_name)" + "VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE planes.airport " +
            "SET quality = ?, planes_capacity = ?, city_name = ? WHERE name = ?;";
    private static final String DELETE = "DELETE FROM planes.airport WHERE name = ?;";

    @Override
    public List<Airport> findAll() throws SQLException {
        List<Airport> airports = new ArrayList<>();

        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Airport airport = new Airport(rs.getString("name"),
                        rs.getString("quality"),
                        rs.getInt("planes_capacity"),
                        rs.getString("city_name"));
                airports.add(airport);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return airports;
    }

    @Override
    public Airport findById(String name) throws SQLException {
        Airport airport = null;

        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            st.setString(1, name);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                airport = new Airport(rs.getString("name"),
                        rs.getString("quality"),
                        rs.getInt("planes_capacity"),
                        rs.getString("city_name"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return airport;
    }

    @Override
    public void create(Airport airport) throws SQLException {
        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            st.setString(1, airport.getName());
            st.setString(2, airport.getQuality());
            st.setInt(3, airport.getPlanes_capacity());
            st.setString(4, airport.getCity_name());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Airport airport) throws SQLException {
        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            st.setString(1, airport.getQuality());
            st.setInt(2, airport.getPlanes_capacity());
            st.setString(3, airport.getCity_name());
            st.setString(4, airport.getName());
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
