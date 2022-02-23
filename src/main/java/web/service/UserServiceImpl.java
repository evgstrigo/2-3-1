package web.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import web.DAO.FakeUserDAOImpl;
import web.DAO.UserDAOImpl;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private FakeUserDAOImpl  fakeUserDAO = new FakeUserDAOImpl();

    @Override
    public void createUserTable() {

    }

    @Override
    public void addUser(User user) {
        fakeUserDAO.addUser(user);
    }

    @Override
    public List<User> getUserList() {
        return fakeUserDAO.getUserList();
    }

    @Override
    public User getUserById(int id) {
        return fakeUserDAO.getUserById(id);
    }
}
