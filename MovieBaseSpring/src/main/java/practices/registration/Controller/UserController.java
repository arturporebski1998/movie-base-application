package practices.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practices.registration.model.User;
import practices.registration.repository.UserRepository;
import practices.registration.service.UserService;

import java.util.Optional;


@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    private UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }
    //tak samo jak w movies
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<User> getUsers() {
        this.userService.getUsers();
        return new ResponseEntity(this.userRepository.findAll(), HttpStatus.OK);
    }

    //tak samo jak w movies
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable(value = "id") Long userId) {
        this.userService.getUser(userId);
        return new ResponseEntity(this.userRepository.findById(userId), HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestBody User user) {
        this.userService.addUser(user);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, @RequestBody User user) {
        Optional<User> optUser = userRepository.findById(userId);
        if (optUser.isPresent()) {
            userService.updateUser(user,userId);
            return new ResponseEntity<>(this.userRepository.save(user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
