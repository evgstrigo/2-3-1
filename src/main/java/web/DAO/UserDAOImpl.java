package web.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import web.config.HibernateConfig;
import web.model.User;

import java.util.ArrayList;
import java.util.List;


@Transactional
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    public UserDAOImpl() {
        sessionFactory = HibernateConfig.getSessionFactory();
    }


    @Override
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
    }

    @Override
    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        userList = session.createQuery("from User").getResultList();
        session.getTransaction().commit();
        return userList;
    }

    @Override
    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.getTransaction().commit();
        return user;
    }

    @Override
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(getUserById(id));
        session.getTransaction().commit();
    }


}
