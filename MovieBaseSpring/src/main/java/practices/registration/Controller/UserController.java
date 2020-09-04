package practices.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import practices.registration.model.User;
import practices.registration.repository.UserRepository;
import practices.registration.service.UserService;


// /api/users
@RequestMapping("users")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    private UserService userService;

    public UserController(UserRepository userRepository,
                          UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }



    @GetMapping
//    Security
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<User> getUsers() {
        this.userService.getUsers();
//        po co?
        System.out.println("getUsers done");
        //        service
        return new ResponseEntity(this.userRepository.findAll(), HttpStatus.OK);
    }


    @GetMapping(path = "{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<User> getUser(@PathVariable(value = "id") Long userId) {
        this.userService.getUser(userId);
        //        po co?
        System.out.println("getUser done");
//        service
        return new ResponseEntity(this.userRepository.findById(userId), HttpStatus.OK);
    }

}
