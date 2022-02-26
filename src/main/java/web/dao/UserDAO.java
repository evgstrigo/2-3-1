package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import java.util.List;


public interface UserDAO {

    public List<User> getAllUsers();

    public void updateUser(User user);

    public User getUserById(int id);

    public void deleteUser(int id);

}
