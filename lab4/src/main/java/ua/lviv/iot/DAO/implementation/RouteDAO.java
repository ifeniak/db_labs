package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.model.Route;
import ua.lviv.iot.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteDAO implements DAO<Route> {

    private static final String GET_ALL = "SELECT * FROM planes.route;";
    private static final String GET_BY_ID = "SELECT * FROM planes.route WHERE id = ?;";
    private static final String CREATE = "INSERT INTO planes.route" +
            "(name, length, duration, danger_level, is_direct, flight_id) " +
            "VALUES (?, ?, ?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE planes.route " + "SET name = ?, length = ?, duration = ?, " +
            "danger_level = ?, is_direct = ?, flight_id = ? WHERE id = ?;";
    private static final String DELETE = "DELETE FROM planes.route WHERE id = ?;";

    @Override
    public List<Route> findAll() throws SQLException {
        List<Route> routes = new ArrayList<>();

        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Route route = new Route(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("length"),
                        rs.getDouble("duration"),
                        rs.getInt("danger_level"),
                        rs.getBoolean("is_direct"),
                        rs.getInt("flight_id"));
                routes.add(route);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return routes;
    }

    @Override
    public Route findById(Integer id) throws SQLException {
        Route route = null;

        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                route = new Route(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("length"),
                        rs.getDouble("duration"),
                        rs.getInt("danger_level"),
                        rs.getBoolean("is_direct"),
                        rs.getInt("flight_id"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return route;
    }

    @Override
    public void create(Route route) throws SQLException {
        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            st.setString(1, route.getName());
            st.setInt(2, route.getLength());
            st.setDouble(3, route.getDuration());
            st.setInt(4, route.getDanger_level());
            st.setBoolean(5, route.getIs_direct());
            st.setInt(6, route.getFlight_id());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Route route) throws SQLException {
        try (PreparedStatement st = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            st.setString(1, route.getName());
            st.setInt(2, route.getLength());
            st.setDouble(3, route.getDuration());
            st.setInt(4, route.getDanger_level());
            st.setBoolean(5, route.getIs_direct());
            st.setInt(6, route.getFlight_id());
            st.setInt(7, route.getId());
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
