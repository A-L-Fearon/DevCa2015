package controllers.api;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Product;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.*;

import views.html.*;

import java.util.List;

/**
 * Created by Shane on 3/5/2015.
 */
public class ProductsController extends Controller {

    @BodyParser.Of(BodyParser.Json.class)
    public static Result index() {

        List<Product> products = Product.find.findList();

        ObjectNode result = Json.newObject();

        result.put("message", products.toString());

        return ok(result);
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result show(String name) {

//        List<Product> products = Product.find.where().eq("name", name).findUnique();

        ObjectNode result = Json.newObject();

//        result.put("message", products.toString());

        return ok(result);
    }
}
