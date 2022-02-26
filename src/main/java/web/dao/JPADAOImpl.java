package web.dao;

import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

@Component
public class JPADAOImpl implements UserDAO {

    @Autowired
    private EntityManagerFactory entityManagerFactory;


    @Override
    public void updateUser(User user) {
        EntityTransaction transaction = null;
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(user);
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        EntityTransaction transaction = null;
        List<User> resultList = null;
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            resultList = entityManager.createQuery("select u from User u ").getResultList();
            transaction.commit();
            return resultList;
        } catch (RuntimeException e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public User getUserById(int id) {
        EntityTransaction transaction = null;
        User user = null;
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            user = entityManager.getReference(User.class, id);
            transaction.commit();
            return user;
        } catch (RuntimeException e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void deleteUser(int id) {
        EntityTransaction transaction = null;
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            User user = getUserById(id);
            entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }
}
