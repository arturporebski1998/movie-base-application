package practices.registration.service;
import practices.registration.model.User;

public interface UserService {

    void getUsers();
    void getUser(Long id);
    void addUser(User user);
    void updateUser(User user, Long id);
    void deleteUser(Long id);
}
