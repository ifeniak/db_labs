package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.model.Country;
import ua.lviv.iot.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO implements DAO<Country> {

    private static final String GET_ALL = "SELECT * FROM planes.country;";
    private static final String GET_BY_ID = "SELECT * FROM planes.country WHERE name = ?;";
    private static final String CREATE = "INSERT INTO planes.country" + "(`name`, `gdp`, `size`, `population`)"
            + "VALUES (?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE planes.country " +
            "SET `gdp` = ?, `size` = ?, `population` = ? WHERE `name` = ?;";
    private static final String DELETE = "DELETE FROM planes.country WHERE `name` = ?;";


    @Override
    public List<Country> findAll() throws SQLException {
        List<Country> countries = new ArrayList<Country>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Country country = new Country(rs.getString("name"),
                        rs.getInt("gdp"),
                        rs.getDouble("size"),
                        rs.getInt("population"));
                countries.add(country);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return countries;
    }

    @Override
    public Country findById(String name) throws SQLException {
        Country country = null;

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                country = new Country(rs.getString("name"),
                        rs.getInt("gdp"),
                        rs.getDouble("size"),
                        rs.getInt("population"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return country;
    }

    @Override
    public void create(Country country) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, country.getName());
            statement.setInt(2, country.getGdp());
            statement.setDouble(3, country.getSize());
            statement.setInt(4, country.getPopulation());
            statement.executeUpdate();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Country country) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, country.getGdp());
            statement.setDouble(2, country.getSize());
            statement.setInt(3, country.getPopulation());
            statement.setString(4, country.getName());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(String name) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
