package controllers.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Product;
import models.Store;
import play.Logger;
import play.data.DynamicForm;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.*;
import play.data.Form;

import views.html.*;
import java.util.*;

/**
 * Created by Shane on 3/5/2015.
 */
public class GroceryController extends Controller {

    //@BodyParser.Of(BodyParser.Json.class)
    public static Result myList() {
        Map<String, String[]> body = request().body().asFormUrlEncoded();
        JsonNode array = request().body().asJson();

        if(array.isArray()){
            for (JsonNode record : array) {
                Logger.debug(record.toString());
                Iterator<String> fields = record.fieldNames();
                while(fields.hasNext()){
                    String field = fields.next();
                    Logger.debug(field);
                    Logger.debug(record.get(field).asText());
                }
            }
        }

        /**
         * Bubble Sort
         */

        List<Product> products = Product.find.findList();
        int max = products.size();

        for (int x = 0; x < max; x++)
        {
            for (int y = x; y < max; y++)
            {
                if (products.get(x).price > products.get(y).price)
                {
                    Product temp = products.get(x);
                    products.set(x, products.get(y));
                    products.set(y, temp);
                }
            }
        }

        

        ObjectNode result = Json.newObject();
        result.put("data", products.toString());

        return ok(result);

        /*
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
        result.put("what",groceries);
        result.put("test",id);
        return ok(result);
    */}

    public static String FormData2String(Map<String, String[]> data){
        String retStr = "", key;

        if(data.isEmpty()){
            return retStr;
        }

        Iterator<String> keys = data.keySet().iterator();
        while(keys.hasNext()){
            key = keys.next();
            retStr = retStr + "\n" + key + " :=> " + Array2CSV(data.get(key));
        }

        return retStr;
    }

    public static String Array2CSV(String[] array){
        String retStr = "";
        if(array == null){
            return retStr;
        }
        if(array.length == 1){
            return array[0];
        }

        for(int c= 0; c < array.length; c++){
            // last value in array
            if((array.length -1) == c){
                retStr = retStr + array[c] + "";
            }else{
                retStr = retStr + array[c] + ", ";
            }
        }

        return retStr;
    }

}
