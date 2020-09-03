//package practices.springsecurity.userr;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Arrays;
//import java.util.List;
//
//@RestController
//@RequestMapping("api/v1/users")
//public class UserrController {
//
//    private static final List<Userr> USERS = Arrays.asList(
//      new Userr(1, "James Bond"),
//      new Userr(2, "Maria Jones"),
//      new Userr(3, "Anna Smith")
//    );
//
//    @GetMapping(path = "{userId}")
//    public Userr getUser(@PathVariable("userId") Integer userId) {
//        return USERS.stream()
//                .filter(user -> userId.equals(user.getUserId()))
//                .findFirst()
//                .orElseThrow(() -> new IllegalStateException(
//                        "User " + userId + " does not exists"
//                ));
//    }
//}
