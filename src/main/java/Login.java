import java.sql.SQLException;

public class Login {

    public Login() {}

    public boolean signIn(String login, String password) {
        Database database = Database.getInstance();
        try {
            return database.checkOnValidAuthorization(login, password);
        }

        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
