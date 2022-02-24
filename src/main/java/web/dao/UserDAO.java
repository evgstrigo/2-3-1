package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import java.util.List;

@Repository
public interface UserDAO {

    public void addUser(User user);

    public List<User> getAllUsers();

    public User getUserById(int id);

    public void deleteUser(int id);

}
