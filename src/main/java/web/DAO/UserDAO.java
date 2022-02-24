package web.DAO;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public interface UserDAO {

    public void addUser(User user);

    public List<User> getUserList();

    public User getUserById(int id);

    public void deleteUser(int id);

}
