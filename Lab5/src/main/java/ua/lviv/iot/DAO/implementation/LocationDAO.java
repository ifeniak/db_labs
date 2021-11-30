package ua.lviv.iot.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.HibernateUtil;
import ua.lviv.iot.model.Location;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationDAO implements DAO<Location> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Location> findAll() throws SQLException {
        List<Location> locations = new ArrayList<>();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            locations = session.createQuery("from Location ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return locations;
    }

    @Override
    public Location findById(Integer id) throws SQLException {
        Location location = null;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            location = session.get(Location.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return location;
    }

    @Override
    public void create(Location location) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(location);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Location location) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(location);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Location location = session.get(Location.class, id);
            if (location != null) {
                session.delete(location);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

