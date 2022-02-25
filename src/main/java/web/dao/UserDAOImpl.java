package web.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import web.config.HibernateConfig;
import web.models.User;

import javax.transaction.Transactional;
import java.util.List;


@Component
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    public UserDAOImpl() {
        sessionFactory = HibernateConfig.getSessionFactory();
    }

    @Override
    public void updateUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<User> getAllUsers() {
        List<User> userList = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            userList = session.createQuery("from User").getResultList();
            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return userList;
    }


    @Override
    public User getUserById(int id) {
        User user = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            user = session.get(User.class, id);
            session.getTransaction().commit();
            return user;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public void deleteUser(int id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.remove(getUserById(id));
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

}
