package practices.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import practices.registration.model.User;
import practices.registration.repository.UserRepository;
import practices.registration.service.UserService;

import java.util.Optional;

@RequestMapping
@RestController
@CrossOrigin(origins = "*")
public class UserManagementController {

    @Autowired
    private UserRepository userRepository;
    private UserService userService;


    @PostMapping(value = "/management/users")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        this.userService.addUser(user);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @DeleteMapping(value = "/management/users/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(value = "/management/users/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
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
