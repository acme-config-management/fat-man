import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.sql.*;
import java.util.Enumeration;
import java.util.List;

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
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();

                Enumeration<InetAddress> inets = networkInterface.getInetAddresses();

                while (inets.hasMoreElements()) {
                    InetAddress inet = inets.nextElement();

                    if (inet.getHostAddress().contains("10.0.10")) {
                        origin = inet.getHostAddress();
                    }
                }
            }


            //origin = InetAddress.getLocalHost().toString();
        } catch(Exception e) {
            e.printStackTrace();
            origin = "Could not get ip address";
        }
    }
}
