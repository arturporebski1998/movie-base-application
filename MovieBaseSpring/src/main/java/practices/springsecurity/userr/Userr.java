package practices.springsecurity.userr;

public class Userr {

    private final Integer userId;
    private final String userName;

    public Userr(Integer userId,
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
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
