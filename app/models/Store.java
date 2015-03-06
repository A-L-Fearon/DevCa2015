package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fearon on 3/5/15.
 */
@Entity
public class Store extends Model {
    public String name;

    @Id
    public Integer id;
    public String parish;
    public String coordinates;

    @OneToMany
    public Product product;
    @OneToMany
//    public List<Product> product = new ArrayList<Product>();

    public static Finder<String, Store> find = new Finder<>(String.class, Store.class);
}
