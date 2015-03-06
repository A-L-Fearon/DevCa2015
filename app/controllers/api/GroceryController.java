package controllers.api;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Product;
import models.Store;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.*;

import views.html.*;

import java.util.List;

/**
 * Created by Shane on 3/5/2015.
 */
public class GroceryController extends Controller {

    @BodyParser.Of(BodyParser.Json.class)
    public static Result myList(String groceries) {
        int i, x, lowid = 0, prods, len;
        float  lowest = 0;
        float[] storenum = new float[50];
        String[] groceryArray = groceries.split(",");

        List<Store> stores = Store.find.findList();
        List<Product> products = Product.find.findList();
        prods = products.size();
        len = stores.size();
        for(i=0; i< groceryArray.length; i++){
            for(x=0;x < prods; x++){
                if(products.get(x).name == groceryArray[i]){
                    storenum[products.get(x).store.id.intValue()] += products.get(x).price;
                }
            }
        }

        for(i=0;i<len;i++){
            if(lowest == 0)
                lowid = i;
                lowest = storenum[i];
            if(storenum[i] < lowest){
                lowid = i;
                lowest = storenum[i];
            }
        }
        // TODO

        ObjectNode result = Json.newObject();

        result.put("lowest_price", lowest);
        result.put("storename", storenum[lowid]);
        result.put("latitude", products.get(lowid).store.latitude);
        result.put("longitude", products.get(lowid).store.longitude);
        return ok();
    }
}
