import java.sql.Connection;
import java.sql.DriverManager;

public class Databaseconnection {
    public Connection dadtabaseLink;

    public Connection getConnection() {

        String databaseName = "Sign1";
        String user = "sqluser";
        String password = "password";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;

        try {
            dadtabaseLink = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();

        }

        return dadtabaseLink;

    }
}