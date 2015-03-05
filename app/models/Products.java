package models;

import play.db.ebean.Model;

import javax.persistence.Entity;

/**
 * Created by fearon on 3/5/15.
 */
@Entity
public class Products extends Model {
    public String name;
    public Long productID;
    public Integer price;

}
