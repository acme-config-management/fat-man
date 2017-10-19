import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.*;

/**
 * Class ResponseObject
 *
 * @author Axel Nilsson (axnion)
 */
public class ResponseObject {
    public String servicename;
    public String message;
    public String origin;

    public ResponseObject() {
        try {
            origin = InetAddress.getLocalHost().getHostAddress();
        } catch(UnknownHostException e) {
            e.printStackTrace();
            origin = "Could not get ip address";
        }
    }
}
