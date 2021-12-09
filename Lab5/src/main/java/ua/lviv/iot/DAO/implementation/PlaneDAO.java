package ua.lviv.iot.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.HibernateUtil;
import ua.lviv.iot.model.Plane;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaneDAO implements DAO<Plane> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Plane> findAll() throws SQLException {
        List<Plane> planes = new ArrayList<>();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            planes = session.createQuery("from Plane ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planes;
    }

    @Override
    public Plane findById(Integer id) throws SQLException {
        Plane plane = null;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            plane = session.get(Plane.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return plane;
    }

    @Override
    public void create(Plane plane) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(plane);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Plane plane) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(plane);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Plane plane = session.get(Plane.class, id);
            if (plane != null) {
                session.delete(plane);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

