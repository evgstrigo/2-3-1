package web.DAO;

import web.model.User;

import java.util.ArrayList;
import java.util.List;

public class FakeUserDAOImpl implements UserDAO{

    public static List<User> usersList = new ArrayList<>();

    @Override
    public void createUserTable() {
    }

    @Override
    public void addUser(User user) {
        usersList.add(user);
    }

    @Override
    public List<User> getUserList() {
        return usersList;
    }

    @Override
    public User getUserById(int id) {
        return usersList.get(id);
    }
}
