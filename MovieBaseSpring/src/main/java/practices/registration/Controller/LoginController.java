package practices.registration.controller;

import org.springframework.web.bind.annotation.*;

// /login
@RequestMapping("login")
@RestController
public class LoginController {

    @PostMapping
    public String login() {
//        Hmmmm???
        return "authenticated succesfully";

    }
}
