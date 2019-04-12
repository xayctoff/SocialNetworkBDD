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

    public boolean checkOnExistUser(String login) throws SQLException {
        statement = instance.connection.createStatement();
        String query = "SELECT COUNT(login) FROM users WHERE login = '" + login + "'";
        ResultSet result = statement.executeQuery(query);
        result.next();
        int count = result.getInt("count");
        return count > 0;
    }

    public int insert(String query) throws SQLException {
        statement = instance.connection.createStatement();
        return statement.executeUpdate(query);
    }

    public int update(String query) throws SQLException {
        statement = instance.connection.createStatement();
        return statement.executeUpdate(query);
    }

    public int getUserID(String login) throws SQLException {
        statement = instance.connection.createStatement();
        String query = "SELECT user_id FROM users WHERE login = '" + login + "'";
        ResultSet result = statement.executeQuery(query);
        int id = 0;
        while (result.next()) {
            id = result.getInt(1);
        }

        return id;
    }
}
