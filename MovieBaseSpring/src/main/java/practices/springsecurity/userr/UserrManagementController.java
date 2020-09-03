//package practices.springsecurity.userr;
//
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Arrays;
//import java.util.List;
//
//@RestController
//@RequestMapping("management/api/v1/users")
//public class UserrManagementController {
//
//    private static final List<Userr> USERS = Arrays.asList(
//            new Userr(1, "James Bond"),
//            new Userr(2, "Maria Jones"),
//            new Userr(3, "Anna Smith")
//    );
//
//    @GetMapping
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
//    public List<Userr> getAllUsers() {
//        System.out.println("getAllUsers done");
//        return USERS;
//    }
//
//    @PostMapping
//    @PreAuthorize("hasAuthority('user:write')")
//    public void registerNewUser(@RequestBody Userr user) {
//        System.out.println("registerNewUser done");
//        System.out.println(user);
//    }
//
//    @DeleteMapping(path = "{userId}")
//    @PreAuthorize("hasAuthority('user:write')")
//    public void deleteUser(@PathVariable("userId") Integer userId) {
//        System.out.println("deleteUser done");
//        System.out.println(userId);
//    }
//
//    @PutMapping(path = "{userId}")
//    @PreAuthorize("hasAuthority('user:write')")
//    public void updateUser(@PathVariable("userId") Integer userId, @RequestBody Userr user) {
//        System.out.println("updateUser done");
//        System.out.println(String.format("%s %s", userId, user));
//    }
//}
