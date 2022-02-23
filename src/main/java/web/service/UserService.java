package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    public void createUserTable();

    public void addUser(User user);

    public List<User> getUserList();

    public User getUserById(int id);
}
