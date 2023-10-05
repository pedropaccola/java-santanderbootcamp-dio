package dio.web.api.repository;

import dio.web.api.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    public void save(User user) {
        if (user.getId() == null) {
            System.out.printf("SAVE - %s on the repository layer%n", user);
        } else {
            System.out.printf("UPDATE - %s on the repository layer%n", user);
        }
    }

    public void deleteById(Integer id) {
        System.out.printf("DELETE - id:'%d' on the repository layer%n", id);
    }

    public List<User> findAll() {
        System.out.println("LIST - Users on repository layer");
        List<User> users = new ArrayList<>();
        users.add(new User("Pedro", "password"));
        users.add(new User("Joel", "Santana"));
        return users;
    }

    public User findById(Integer id) {
        System.out.printf("FIND - id:'%d' on the repository layer%n", id);
        return new User("Pedro", "password");
    }

    public User findByUsername(String username) {
        System.out.printf("FIND - username:'%s' on the repository layer%n", username);
        return new User("Pedro", "password");
    }
}
