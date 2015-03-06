package controllers.api;

import models.Store;
import play.mvc.Controller;
import play.mvc.*;

import views.html.*;

import java.util.List;

/**
 * Created by Shane on 3/5/2015.
 */
public class GroceryController extends Controller {

    public static Result myList(String groceries) {
        int i, low;
        String[] groceryArray = groceries.split(",");

        List<Store> stores = Store.find.findList();

        for(i=0; i< stores.size(); i++){
            i++;//stores.get(i).product.get();
        }

        // TODO
        return ok();
    }
}
