/**
 * Created by mpean on 19/01/17.
 */

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;

import java.lang.reflect.Type;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class Main {
    private final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        get("/hello", (req, res) -> {
            logger.info("service hello");
            return "Hello World";
        });
        // matches "GET /hello/foo" and "GET /hello/bar"
        // request.params(":name") is 'foo' or 'bar'
        get("/hello/:name", (request, response) -> {
            return "Hello: " + request.params(":name");
        });
        // matches "POST /hello name=max"
        post("/hello", (request, response) -> {
            String body = request.body();
            Map data = parseBody(request);
            String name = (String) data.get("name");

          return "hello "+name;
        });
    }

    /**
     * Converts requete's body into Map<String, String>
     * @param request
     * @return request body's attributes map
     */
    private static Map<String, String> parseBody(Request request) {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>(){}.getType();

        return gson.fromJson(request.body(), type);
    }

    /**
     * Converts an object to json String
     * @param
     * @return json string
     */
    private static String toJson(Object o) {
        Gson gson = new Gson();
        return gson.toJson(o);
    }

}
