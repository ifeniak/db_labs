package ua.lviv.iot.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.HibernateUtil;
import ua.lviv.iot.model.PlaneFlightHistory;
import ua.lviv.iot.model.PlaneFlightHistoryPK;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaneFlightHistoryDAO implements DAO<PlaneFlightHistory> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<PlaneFlightHistory> findAll() throws SQLException {
        List<PlaneFlightHistory> planeFlightHistories = new ArrayList<>();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            planeFlightHistories = session.createQuery("from PlaneFlightHistory ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planeFlightHistories;
    }

    @Override
    public PlaneFlightHistory findById(Integer firstId, Integer secondId) throws SQLException {
        PlaneFlightHistory planeFlightHistory = null;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            planeFlightHistory = session.get(PlaneFlightHistory.class, new PlaneFlightHistoryPK(firstId, secondId));
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planeFlightHistory;
    }

    @Override
    public void create(PlaneFlightHistory planeFlightHistory) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(planeFlightHistory);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(PlaneFlightHistory planeFlightHistory) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(planeFlightHistory);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer firstId, Integer secondId) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            PlaneFlightHistory planeFlightHistory = session.get(PlaneFlightHistory.class,
                    new PlaneFlightHistoryPK(firstId, secondId));
            if (planeFlightHistory != null) {
                session.delete(planeFlightHistory);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
