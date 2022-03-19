package frontend;

public class Login {

    String users = "admin";
    String psws = "admin123";

    public int login(String user, String psw) {
        if (user.equals(users) && psws.equals(psw))
            return 1;
        else
            return 0;
    }
}
