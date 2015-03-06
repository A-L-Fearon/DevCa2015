package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by fearon on 3/5/15.
 */
@Entity
public class Product extends Model {
    @Id
    public Long id;
    public String name;
    public Integer price;

    @ManyToOne
    public Store store;



    public static Finder<String, Product> find = new Finder<>(String.class, Product.class);
}
