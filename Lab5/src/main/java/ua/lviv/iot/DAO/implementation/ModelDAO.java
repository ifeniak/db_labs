package ua.lviv.iot.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.lviv.iot.DAO.DAO;
import ua.lviv.iot.HibernateUtil;
import ua.lviv.iot.model.Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelDAO implements DAO<Model> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Model> findAll() throws SQLException {
        List<Model> models = new ArrayList<>();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            models = session.createQuery("from Model ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return models;
    }

    @Override
    public Model findById(Integer id) throws SQLException {
        Model model = null;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            model = session.get(Model.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @Override
    public void create(Model model) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(model);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Model model) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(model);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Model model = session.get(Model.class, id);
            if (model != null) {
                session.delete(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
