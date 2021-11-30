package ua.lviv.iot.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.HibernateUtil;
import ua.lviv.iot.model.City;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAO implements DAO<City> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<City> findAll() throws SQLException {
        List<City> cities = new ArrayList<>();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            cities = session.createQuery("from City ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public City findById(String name) throws SQLException {
        City city = null;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            city = session.get(City.class, name);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public void create(City city) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(city);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(City city) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(city);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String name) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            City city = session.get(City.class, name);
            if (city != null) {
                session.delete(city);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
