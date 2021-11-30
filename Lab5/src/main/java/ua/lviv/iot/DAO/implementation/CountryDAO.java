package ua.lviv.iot.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.HibernateUtil;
import ua.lviv.iot.model.Country;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO implements DAO<Country> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Country> findAll() throws SQLException {
        List<Country> countries = new ArrayList<>();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            countries = session.createQuery("from Country ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public Country findById(Integer id) throws SQLException {
        Country country = null;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            country = session.get(Country.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
    }

    @Override
    public void create(Country country) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(country);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Country country) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(country);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Country country = session.get(Country.class, id);
            if (country != null) {
                session.delete(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
