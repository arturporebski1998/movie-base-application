package practices.registration.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("login")
@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    @GetMapping
    public String login() {
        return "authenticated succesfully";
    }
}
