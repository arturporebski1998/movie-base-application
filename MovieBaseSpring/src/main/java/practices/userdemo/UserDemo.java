package practices.userdemo;

public class UserDemo {

    private final Integer userId;
    private final String userName;

    public UserDemo(Integer userId,
                   String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "UserDemo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}