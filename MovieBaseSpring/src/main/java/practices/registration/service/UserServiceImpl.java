package practices.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practices.registration.model.User;
import practices.registration.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public void getUsers() {
        this.userRepository.findAll();
    }

    @Override
    public void getUser(Long id) {
        this.userRepository.findById(id);
    }

    @Override
    public void addUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public void updateUser(User user, Long id) {
        user.setId(id);
        this.userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }
}
