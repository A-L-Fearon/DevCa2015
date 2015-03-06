package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Created by fearon on 3/5/15.
 */
@Entity
public class Store extends Model {

    @Id
    public Long id;
    public String name;
    public String parish;
    public Double latitude;
    public Double longitude;

    @OneToMany
    public Product product;
    @OneToMany
//    public List<Product> product = new ArrayList<Product>();

    public static Finder<String, Store> find = new Finder<>(String.class, Store.class);

    public static Store create (Store store, String name, String parish, Double latitude, Double longitude) {
        store.name = name;
        store.parish = parish;
        store.latitude = latitude;
        store.longitude = longitude;
        return store;
    }
}
