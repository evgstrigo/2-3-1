package web.service;

import web.models.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public void updateUser(User user);

    public User getUserById(int id);

    public void deleteUser(int id);
}
