package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.JPADAOImpl;
import web.dao.UserDAOImpl;
import web.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
//    Для Hibernate
//
//    private UserDAOImpl userDAO;
//
//    @Autowired
//    public UserServiceImpl(UserDAOImpl userDAO) {
//        this.userDAO = userDAO;
//    }

    private JPADAOImpl userDAO;

    @Autowired
    public UserServiceImpl(JPADAOImpl userDAO) {
        this.userDAO = userDAO;
    }



    // Для Fake
//    @Qualifier("fakeUserDAOImpl")
//    @Autowired
//    private FakeUserDAOImpl userDAO;


    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

}
