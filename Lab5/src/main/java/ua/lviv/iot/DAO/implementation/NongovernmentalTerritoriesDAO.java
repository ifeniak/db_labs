package ua.lviv.iot.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.HibernateUtil;
import ua.lviv.iot.model.NongovernmentalTerritories;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NongovernmentalTerritoriesDAO implements DAO<NongovernmentalTerritories> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<NongovernmentalTerritories> findAll() throws SQLException {
        List<NongovernmentalTerritories> nongovernmentalTerritoriess = new ArrayList<>();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            nongovernmentalTerritoriess = session.createQuery("from NongovernmentalTerritories ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nongovernmentalTerritoriess;
    }

    @Override
    public NongovernmentalTerritories findById(String name) throws SQLException {
        NongovernmentalTerritories nongovernmentalTerritories = null;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            nongovernmentalTerritories = session.get(NongovernmentalTerritories.class, name);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nongovernmentalTerritories;
    }

    @Override
    public void create(NongovernmentalTerritories nongovernmentalTerritories) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(nongovernmentalTerritories);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(NongovernmentalTerritories nongovernmentalTerritories) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(nongovernmentalTerritories);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String name) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            NongovernmentalTerritories nongovernmentalTerritories = session.get(NongovernmentalTerritories.class, name);
            if (nongovernmentalTerritories != null) {
                session.delete(nongovernmentalTerritories);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

