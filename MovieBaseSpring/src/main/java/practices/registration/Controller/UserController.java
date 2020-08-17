package practices.registration.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practices.registration.Model.User;
import practices.registration.Repository.UserRepository;

import java.util.LinkedList;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //get users
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<LinkedList<User>> getAllUsers() {
        return new ResponseEntity(this.userRepository.findAll(), HttpStatus.OK);
    }

    //get user by id
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getOneUser(@PathVariable(value = "id") Long userId) {
        return new ResponseEntity(this.userRepository.findById(userId), HttpStatus.OK);
    }

    //post users
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity(this.userRepository.save(user), HttpStatus.OK);
    }

    //delete user
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long userId) {
        userRepository.deleteById(userId);
        return new ResponseEntity(HttpStatus.OK);
    }

    //update user
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, @RequestBody User userDetails) {
        Optional<User> optUser = userRepository.findById(userId);
        if (optUser.isPresent()) {
            return new ResponseEntity<>(this.userRepository.save(userDetails), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
