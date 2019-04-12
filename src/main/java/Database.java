import java.sql.*;

public class Database {

    private static Database instance;
    private Statement statement;
    private Connection connection;

    private Database() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/network";
        String username = "postgres";
        String password = "111";

        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        }

        catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public static Database getInstance() {

        if (instance == null) {

            try {
                instance = new Database();
            }

            catch (SQLException exception) {
                exception.printStackTrace();
            }
        }

        return instance;
    }

    public boolean checkOnValidAuthorization(String login, String password) throws SQLException {
        try {
            statement = instance.connection.createStatement();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "SELECT COUNT(login) FROM users WHERE login = '" + login + "' AND password = '" + password + "'";

        if (!checkOnExistUser(login)) {
            return false;
        }

        else {
            ResultSet result = statement.executeQuery(query);
            result.next();

            return result.getInt("count") != 0;
        }
    }
}
