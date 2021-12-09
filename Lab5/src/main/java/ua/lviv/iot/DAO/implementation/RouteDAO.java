package ua.lviv.iot.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.HibernateUtil;
import ua.lviv.iot.model.Route;
import ua.lviv.iot.model.RoutePK;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteDAO implements DAO<Route> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Route> findAll() throws SQLException {
        List<Route> routes = new ArrayList<>();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            routes = session.createQuery("from Route ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return routes;
    }

    @Override
    public Route findById(Integer id, Integer flightId) throws SQLException {
        Route route = null;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            route = session.get(Route.class, new RoutePK(id, flightId));
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return route;
    }

    @Override
    public void create(Route route) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(route);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Route route) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(route);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id, Integer flightId) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Route route = session.get(Route.class, new RoutePK(id, flightId));
            if (route != null) {
                session.delete(route);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

