import java.sql.*;

/**
 * Class DAO
 *
 * @author Axel Nilsson (axnion)
 */
public class DAO {

    public void add() throws SQLException {
        try {
            get();
        } catch (SQLException e) {
            Connection connection = DriverManager.getConnection(FatMan.dbUrl, FatMan.dbUser, FatMan.dbPass);

            String query = "CREATE TABLE messages (message text)";
            Statement stmt = connection.createStatement();
            stmt.execute(query);

            query = "INSERT INTO messages (message) VALUES ('This is a message from Postgres')";
            stmt.execute(query);

            connection.close();
        }
    }

    public ResponseObject get() throws SQLException {
        ResponseObject obj = new ResponseObject();

        Connection connection = DriverManager.getConnection(FatMan.dbUrl, FatMan.dbUser, FatMan.dbPass);

        String query = "SELECT * FROM messages LIMIT 1";
        Statement stmt = connection.createStatement();
        stmt.execute(query);
        ResultSet results = stmt.getResultSet();

        results.next();

        obj.message = results.getString("message");
        obj.servicename = "fatman";

        connection.close();

        return obj;
    }

}
