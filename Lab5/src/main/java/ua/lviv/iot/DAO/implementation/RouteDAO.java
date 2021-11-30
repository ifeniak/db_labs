package ua.lviv.iot.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.HibernateUtil;
import ua.lviv.iot.model.Route;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteDAO implements DAO<Route> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Route> findAll() throws SQLException {
        List<Route> Routes = new ArrayList<>();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Routes = session.createQuery("from Route ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Routes;
    }

    @Override
    public Route findById(Integer id) throws SQLException {
        Route Route = null;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Route = session.get(Route.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Route;
    }

    @Override
    public void create(Route Route) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(Route);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Route Route) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(Route);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Route Route = session.get(Route.class, id);
            if (Route != null) {
                session.delete(Route);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

