package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Shane on 3/5/2015.
 */
@Entity
public class ProductSize extends Model {

    @Id
    public Long id;

    public String description;

    public static ProductSize create(ProductSize size, String desc){
        size.description = desc;

    }

}
