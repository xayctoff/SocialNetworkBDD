import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public boolean addFriend(String server, String receiver) throws SQLException {
        if (!Database.getInstance().checkOnFriendship(server, receiver)) {
            Database.getInstance().insert("INSERT INTO friends VALUES ((SELECT user_id FROM users WHERE login = "
                    + "'" + server + "'), (SELECT user_id FROM users WHERE login = '" + receiver + "'), 1)");
            return true;
        }

        else {
            return false;
        }
    }

    public void confirmFriendship(String server, String receiver) {
        try {
            Database.getInstance().update("UPDATE friends SET status = 2 WHERE first = (SELECT user_id FROM " +
                    "users WHERE login = '" + server + "') AND second = (SELECT user_id FROM users WHERE login = '" +
                    receiver + "') OR first = (SELECT user_id FROM users WHERE login = '" + receiver + "') " +
                    "AND second = (SELECT user_id FROM users WHERE login = '" + server + "')");
        }

        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void writeMessage(String server, String receiver, String message) throws SQLException {
        Database database = Database.getInstance();
        int serverId = database.getUserID(server);
        int receiverId = database.getUserID(receiver);

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Date date = new Date();

        database.insert("INSERT INTO messages VALUES (DEFAULT, " + serverId + ", " + receiverId + ", '" +
                message + "', " + "'" + dateFormat.format(date) + "')");
    }
}
