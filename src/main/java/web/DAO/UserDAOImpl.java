package web.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import web.config.HibernateConfig;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl  {


    public static List<User> usersList = new ArrayList<>();

    private SessionFactory sessionFactory;


    public void createUserTable() {

//        User user = new User("Eugenio", "Strigo", 32);
//        Session session = HibernateConfig.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        session.save(user);
//        session.getTransaction().commit();
    }




}
