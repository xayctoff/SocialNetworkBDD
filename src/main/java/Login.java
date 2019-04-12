import java.sql.SQLException;

public class Login {

    public Login() {}

    public boolean signIn(String login, String password) throws SQLException {
        Database database = Database.getInstance();
        return database.checkOnValidAuthorization(login, password);
    }

    public boolean signUp(String login, String password) {
        
    }
}
