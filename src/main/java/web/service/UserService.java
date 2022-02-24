package web.service;

import web.models.User;

import java.util.List;

public interface UserService {

    public void addUser(User user);

    public List<User> getAllUsers();

    public User getUserById(int id);

    public void deleteUser(int id);

}
