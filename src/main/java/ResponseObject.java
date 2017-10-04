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
        String url = "jdbc:postgresql://" + FatMan.dbIp + ":" + FatMan.dbPort + "/" + FatMan.dbName;

        Connection connection = DriverManager.getConnection(
                url, FatMan.dbUser, FatMan.dbPass);

        String query = "SELECT * FROM messages LIMIT 1";
        Statement stmt = connection.createStatement();
        stmt.execute(query);
        ResultSet results = stmt.getResultSet();

        results.next();

        message = results.getString("message");
        servicename = "fatman";
    }
}
