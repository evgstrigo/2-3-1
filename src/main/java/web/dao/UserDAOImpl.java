package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import web.config.HibernateConfig;
import web.models.User;

import java.util.List;

@Component
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
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<User> userList = session.createQuery("from User").getResultList();
        userList.add(new User("Eugenio", "Strigo", 32));
        userList.add(new User("Ivan", "Popov", 22));
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
