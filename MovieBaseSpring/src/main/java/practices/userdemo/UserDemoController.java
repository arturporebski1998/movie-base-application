package practices.userdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

public class UserDemoController {
    private static final List<UserDemo> USERSDEMO = Arrays.asList(
            new UserDemo(1, "James Bond"),
            new UserDemo(2, "Maria Jones"),
            new UserDemo(3, "Anna Smith")
    );

    @GetMapping(path = "{userDemoId}")
    public UserDemo getStudent(@PathVariable("studentId") Integer userDemoId) {
        return USERSDEMO.stream()
                .filter(student -> userDemoId.equals(student.getUserId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(
                        "Student " + userDemoId + " does not exists"
                ));
    }
}
