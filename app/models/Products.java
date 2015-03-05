package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by fearon on 3/5/15.
 */
@Entity
public class Products extends Model {
    public String name;
    public Long productID;
    public Integer price;
    @ManyToOne
    public Stores store;
    public static Finder<String,Products> find = new Finder<>(String.class, Products.class);
}
