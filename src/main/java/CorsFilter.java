import java.util.HashMap;
import spark.Filter;
import spark.Request;
import spark.Response;
import spark.Spark;

/**
 * Class CorsFilter
 *
 * @author Axel Nilsson (axnion)
 */
public class CorsFilter {
    private static HashMap<String, String> corsHeaders = new HashMap<>();

    public static void apply() {
        corsHeaders.put("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
        corsHeaders.put("Access-Control-Allow-Origin", "*");
        corsHeaders.put("Access-Control-Allow-Headers", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");
        corsHeaders.put("Access-Control-Allow-Credentials", "true");

        Filter filter = new Filter() {
            @Override
            public void handle(Request request, Response response) {
                corsHeaders.forEach((key, value) -> {
                    response.header(key, value);
                });
            }
        };
        Spark.after(filter);
    }
}
