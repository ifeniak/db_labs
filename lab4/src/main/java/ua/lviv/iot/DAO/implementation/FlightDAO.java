package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.model.Airline;
import ua.lviv.iot.model.Flight;
import ua.lviv.iot.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO implements DAO<Flight> {
    private static final String GET_ALL = "SELECT * FROM planes.flight;";
    private static final String GET_BY_ID = "SELECT * FROM planes.flight WHERE id = ?;";
    private static final String CREATE = "INSERT INTO planes.flight " +
            "(`name`, `airport_departure`, `airport_arrival`) " + "VALUES (?, ?, ?);";
    private static final String UPDATE = "UPDATE planes.flight " + "SET `name` = ?, `airport_departure` = ?," +
            " `airport_arrival` = ? WHERE `id` = ?;";
    private static final String DELETE = "DELETE FROM planes.flight WHERE `id` = ?;";

    @Override
    public List<Flight> findAll() throws SQLException {
        List<Flight> flights = new ArrayList<>();

        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Flight flight = new Flight(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("airport_departure"),
                        rs.getString("airport_arrival"));
                flights.add(flight);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return flights;
    }

    @Override
    public Flight findById(Integer id) throws SQLException {
        Flight flight = null;

        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                flight = new Flight(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("airport_departure"),
                        rs.getString("airport_arrival"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return flight;
    }

    @Override
    public void create(Flight flight) throws SQLException {
        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            st.setString(1, flight.getName());
            st.setString(2, flight.getAirport_departure());
            st.setString(3, flight.getAirport_arrival());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Flight flight) throws SQLException {
        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            st.setString(1, flight.getName());
            st.setString(2, flight.getAirport_departure());
            st.setString(3, flight.getAirport_arrival());
            st.setInt(4, flight.getId());
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
