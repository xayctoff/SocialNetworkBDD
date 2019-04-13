import java.sql.SQLException;

public class User {

    public User() {}

    private String login;
    private String password;

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public boolean addFriend(String server, String receiver) {
        if (!Database.getInstance().checkOnFriendship(server, receiver)) {
            try
            {
                Database.getInstance().insert("INSERT INTO friends VALUES ((SELECT user_id FROM users WHERE login = "
                        + "'" + server + "'), (SELECT user_id FROM users WHERE login = '" + receiver + "'), 1)");
            }

            catch (SQLException exception) {
                exception.printStackTrace();
            }

            return true;
        }

        else {
            return false;
        }
    }
}
