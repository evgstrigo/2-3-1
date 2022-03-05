package web.service;

import org.springframework.stereotype.Service;
import web.dao.JPADAOImpl;
import web.dao.UserDAO;
import web.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private UserDAO userDAO;


    public UserServiceImpl(JPADAOImpl userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
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
