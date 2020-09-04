package practices.registration.controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping("login")
@RestController
public class LoginController {

    @PostMapping
    public String login() {
        return "authenticated succesfully";

    }
}
