package web.dao;

import org.springframework.stereotype.Component;
import web.models.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class FakeUserDAOImpl implements UserDAO {

    public List<User> usersList;

    {
        usersList = new ArrayList<>();
        usersList.add(new User("Eugenio", "Strigo", 32));
        usersList.add(new User("Oleg", "Ragalevich", 31));
        usersList.add(new User("Ivan", "Budko", 42));
    }


    @Override
    public void addUser(User user) {
        usersList.add(user);
    }

    @Override
    public List<User> getAllUsers() {
        return usersList;
    }

    @Override
    public User getUserById(int id) {
        return usersList.get(id);
    }

    @Override
    public void deleteUser(int id) {

        usersList.remove(getUserById(id));
    }
}
