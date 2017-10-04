/**
 * Class FatMan
 *
 * @author Axel Nilsson (axnion)
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.*;

public class FatMan {
    public static void main(String[] args) {
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
}

