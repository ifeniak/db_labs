package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.model.City;
import ua.lviv.iot.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAO implements DAO<City> {

    private static final String GET_ALL = "SELECT * FROM planes.city;";
    private static final String GET_BY_ID = "SELECT * FROM planes.city WHERE name = ?;";
    private static final String CREATE = "INSERT INTO planes.city " +
            "(name, population, status, country_name)" + "VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE planes.city " +
            "SET population = ?, status = ?, country_name = ? WHERE name = ?;";
    private static final String DELETE = "DELETE FROM planes.city WHERE name = ?;";

    @Override
    public List<City> findAll() throws SQLException {
        List<City> cities = new ArrayList<>();

        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                City city = new City(rs.getString("name"),
                        rs.getInt("population"),
                        rs.getString("status"),
                        rs.getString("country_name"));
                cities.add(city);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cities;
    }

    @Override
    public City findById(String name) throws SQLException {
        City city = null;

        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            st.setString(1, name);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                city = new City(rs.getString("name"),
                        rs.getInt("population"),
                        rs.getString("status"),
                        rs.getString("country_name"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return city;
    }

    @Override
    public void create(City city) throws SQLException {
        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            st.setString(1, city.getName());
            st.setInt(2, city.getPopulation());
            st.setString(3, city.getStatus());
            st.setString(4, city.getCountry_name());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(City city) throws SQLException {
        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            st.setInt(1, city.getPopulation());
            st.setString(2, city.getStatus());
            st.setString(3, city.getCountry_name());
            st.setString(4, city.getName());
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
