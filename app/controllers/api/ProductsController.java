package controllers.api;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.*;

import views.html.*;

/**
 * Created by Shane on 3/5/2015.
 */
public class ProductsController extends Controller {

    @BodyParser.Of(BodyParser.Json.class)
    public static Result index() {

        ObjectNode result = Json.newObject();

        result.put("status", "OK");
        result.put("message", "Yooo");
        result.put("error", "");

        return null;
    }
}
