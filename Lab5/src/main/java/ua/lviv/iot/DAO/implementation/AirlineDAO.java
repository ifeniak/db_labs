package ua.lviv.iot.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.HibernateUtil;
import ua.lviv.iot.model.Airline;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirlineDAO implements DAO<Airline> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Airline> findAll() throws SQLException {
        List<Airline> airlines = new ArrayList<Airline>();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            airlines = session.createQuery("from Airline ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return airlines;
    }

    @Override
    public Airline findById(Integer id) throws SQLException {
        Airline airline = null;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            airline = session.get(Airline.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return airline;
    }

    @Override
    public void create(Airline airline) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(airline);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Airline airline) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(airline);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Airline airline = session.get(Airline.class, id);
            if (airline != null) {
                session.delete(airline);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
