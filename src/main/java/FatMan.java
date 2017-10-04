/**
 * Class FatMan
 *
 * @author Axel Nilsson (axnion)
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Map;

import static spark.Spark.*;

public class FatMan {
    public static String dbIp;
    public static String dbPort;
    public static String dbName;
    public static String dbUser;
    public static String dbPass;

    public static void main(String[] args) {
        getEnvironmentVariables();

        setPort(9876);

        get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                return "Testing";
            }
        });

        get(new Route("/hello") {
            @Override
            public Object handle(Request request, Response response) {
                response.type("application/json");

                ObjectMapper mapper = new ObjectMapper();
                try {
                    ResponseObject responseObj = new ResponseObject();
                    return mapper.writeValueAsString(responseObj);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        });
    }

    private static void getEnvironmentVariables() {
        System.out.println("Fetching database settings...");
        Map<String, String> env = System.getenv();

        for (Map.Entry<String, String> variable : env.entrySet()) {
            if (variable.getKey().equals("db_ip")) {
                System.out.println("DB IP: " + variable.getValue());
                dbIp = variable.getValue();
            } else if (variable.getKey().equals("db_port")) {
                System.out.println("DB PORT: " + variable.getValue());
                dbPort = variable.getValue();
            } else if (variable.getKey().equals("db_name")) {
                System.out.println("DB NAME: " + variable.getValue());
                dbName = variable.getValue();
            } else if (variable.getKey().equals("db_user")) {
                System.out.println("DB USER: " + variable.getValue());
                dbUser = variable.getValue();
            } else if (variable.getKey().equals("db_pass")) {
                System.out.println("DB PASS: " + variable.getValue());
                dbPass = variable.getValue();
            }
        }
    }
}

