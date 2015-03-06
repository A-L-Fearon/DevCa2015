package controllers.api;

import play.mvc.Controller;
import play.mvc.*;

import views.html.*;

/**
 * Created by Shane on 3/5/2015.
 */
public class GroceryController extends Controller {

    public static Result myList(String groceries) {
        String[] groceryArray = groceries.split(",");

        // TODO
        return ok();
    }
}
