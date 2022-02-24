package web.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import web.DAO.FakeUserDAOImpl;
import web.DAO.UserDAO;
import web.DAO.UserDAOImpl;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private UserDAO UserDAO = new UserDAOImpl();


    @Override
    public void addUser(User user) {
        UserDAO.addUser(user);
    }

    @Override
    public List<User> getUserList() {
        return UserDAO.getUserList();
    }

    @Override
    public User getUserById(int id) {
        return UserDAO.getUserById(id);
    }

    @Override
    public void deleteUser(int id) {
        UserDAO.deleteUser(id);
    }
}
