package ua.lviv.iot.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.HibernateUtil;
import ua.lviv.iot.model.Airport;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirportDAO implements DAO<Airport> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Airport> findAll() throws SQLException {
        List<Airport> airports = new ArrayList<>();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            airports = session.createQuery("from Airport ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return airports;
    }

    @Override
    public Airport findById(Integer id) throws SQLException {
        Airport airport = null;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            airport = session.get(Airport.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return airport;
    }

    @Override
    public void create(Airport airport) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(airport);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Airport airport) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(airport);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Airport airport = session.get(Airport.class, id);
            if (airport != null) {
                session.delete(airport);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
