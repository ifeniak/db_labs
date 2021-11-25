package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.model.Airline;
import ua.lviv.iot.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirlineDAO implements DAO<Airline> {
    private static final String GET_ALL = "SELECT * FROM planes.airline;";
    private static final String GET_BY_ID = "SELECT * FROM planes.airline WHERE id = ?;";
    private static final String CREATE = "INSERT INTO planes.airline " +
            "(`name`, `capitalization`, `country_name`) " + "VALUES (?, ?, ?);";
    private static final String UPDATE = "UPDATE planes.airline " + "SET `name` = ?, `capitalization` = ?," +
            " `country_name` = ? WHERE `id` = ?;";
    private static final String DELETE = "DELETE FROM planes.airline WHERE `id` = ?;";

    @Override
    public List<Airline> findAll() throws SQLException {
        List<Airline> airlines = new ArrayList<>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Airline airline = new Airline(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("capitalization"),
                        rs.getString("country_name"));
                airlines.add(airline);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return airlines;
    }

    @Override
    public Airline findById(Integer id) throws SQLException {
        Airline airline = null;

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                airline = new Airline(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("capitalization"),
                        rs.getString("country_name"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return airline;
    }

    @Override
    public void create(Airline airline) throws SQLException {
        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            st.setString(1, airline.getName());
            st.setDouble(2, airline.getCapitalization());
            st.setString(3, airline.getCountry_name());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Airline airline) throws SQLException {
        try(PreparedStatement st = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            st.setString(1, airline.getName());
            st.setDouble(2, airline.getCapitalization());
            st.setString(3, airline.getCountry_name());
            st.setInt(4, airline.getId());
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
