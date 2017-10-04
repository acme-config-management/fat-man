import java.sql.*;

/**
 * Class ResponseObject
 *
 * @author Axel Nilsson (axnion)
 */
public class ResponseObject {
    public String servicename;
    public String message;

    public ResponseObject() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/ubuntu", "my_user", "my_password");

        String query = "SELECT * FROM messages LIMIT 1";
        Statement stmt = connection.createStatement();
        stmt.execute(query);
        ResultSet results = stmt.getResultSet();

        results.next();

        message = results.getString("message");
        servicename = "fatman";
    }
}
