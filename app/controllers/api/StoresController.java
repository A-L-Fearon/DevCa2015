package controllers.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.api.libs.json.JsPath;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;

import play.mvc.Result;
import views.html.*;


/**
 * Created by Shane on 3/5/2015.
 */
public class StoresController extends Controller {

    @BodyParser.Of(BodyParser.Json.class)
    public static Result index() {
        ObjectNode result = Json.newObject();

        result.put("status", "OK");
        result.put("message", "Yoooooo");
        result.put("error", "");
        return ok(result);
    }

    public static Result getStore(Long id) {

        return null;
    }

}
