package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.model.Model;
import ua.lviv.iot.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelDAO implements DAO<Model> {
    private static final String GET_ALL = "SELECT * FROM planes.model;";
    private static final String GET_BY_ID = "SELECT * FROM planes.model WHERE id = ?;";
    private static final String CREATE = "INSERT INTO planes.model" + "(`name`, `height`, `length`, `width`, `destination`, `color`)"
            + "VALUES (?, ?, ?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE planes.model " +
            "SET `name` = ?, `height` = ?, `length` = ?, `width` = ?, `destination` = ?, `color` = ? WHERE id = ?;";
    private static final String DELETE = "DELETE FROM planes.model WHERE `id` = ?;";

    @Override
    public List<Model> findAll() throws SQLException {
        List<Model> models = new ArrayList<Model>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Model model = new Model(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("height"),
                        rs.getDouble("length"),
                        rs.getDouble("width"),
                        rs.getString("destination"),
                        rs.getString("color"));
                models.add(model);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return models;
    }

    @Override
    public Model findById(Integer id) throws SQLException {
        Model model = null;

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                model = new Model(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("height"),
                        rs.getDouble("length"),
                        rs.getDouble("width"),
                        rs.getString("destination"),
                        rs.getString("color"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

    @Override
    public void create(Model model) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, model.getName());
            statement.setDouble(2, model.getHeight());
            statement.setDouble(3, model.getLength());
            statement.setDouble(4, model.getWidth());
            statement.setString(5, model.getDestination());
            statement.setString(6, model.getColor());
            statement.executeUpdate(); // where id set????
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void update(Model model) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, model.getName());
            statement.setDouble(2, model.getHeight());
            statement.setDouble(3, model.getLength());
            statement.setDouble(4, model.getWidth());
            statement.setString(5, model.getDestination());
            statement.setString(6, model.getColor());
            statement.setInt(7, model.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
