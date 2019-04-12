import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
}
