package ua.lviv.iot.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.HibernateUtil;
import ua.lviv.iot.model.Flight;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO implements DAO<Flight> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Flight> findAll() throws SQLException {
        List<Flight> flights = new ArrayList<>();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            flights = session.createQuery("from Flight ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flights;
    }

    @Override
    public Flight findById(Integer id) throws SQLException {
        Flight flight = null;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            flight = session.get(Flight.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flight;
    }

    @Override
    public void create(Flight flight) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(flight);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Flight flight) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(flight);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Flight flight = session.get(Flight.class, id);
            if (flight != null) {
                session.delete(flight);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

