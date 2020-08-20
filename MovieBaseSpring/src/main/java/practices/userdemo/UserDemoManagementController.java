package practices.userdemo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
//just to test spring security
@RestController
@RequestMapping("management/users")
public class UserDemoManagementController {
    private static final List<UserDemo> USERSDEMO = Arrays.asList(
            new UserDemo(1, "James Bond"),
            new UserDemo(2, "Maria Jones"),
            new UserDemo(3, "Anna Smith")
    );

    //    hasRole('ROLE_') hasAnyRole('ROLE_') hasAuthority('permission') hasAnyAuthority('permission')

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<UserDemo> getAllUsers() {
        System.out.println("getAllUsers");
        return USERSDEMO;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('user:write')")
    public void registerNewUser(@RequestBody UserDemo userDemo) {
        System.out.println("registerNewUser");
        System.out.println(userDemo);
    }

    @DeleteMapping(path = "{userDemoId}")
    @PreAuthorize("hasAuthority('user:write')")
    public void deleteUser(@PathVariable("userDemoId") Integer userDemoId) {
        System.out.println("deleteUser");
        System.out.println(userDemoId);
    }

    @PutMapping(path = "{userDemoId}")
    @PreAuthorize("hasAuthority('user:write')")
    public void updateUser(@PathVariable("userDemoId") Integer userDemoId, @RequestBody UserDemo userDemo) {
        System.out.println("updateUser");
        System.out.println(String.format("%s %s", userDemoId, userDemo));
    }

}
