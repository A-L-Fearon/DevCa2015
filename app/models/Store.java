package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by fearon on 3/5/15.
 */
@Entity
public class Store extends Model {

    @Id
    public Long id;
    public String name;
    public String address;
    public String address2;
    public String parish;
    public Double latitude;
    public Double longitude;
    public String type;
    public String town;
    public String telenum;
    //@OneToMany
    //public Product product;
    @OneToMany(mappedBy = "store")
    public List<Product> product;

    public static Finder<Long, Store> find = new Finder<>(Long.class, Store.class);

    public static Store create (Store store, String name, String parish, Double latitude, Double longitude) {
        store.name = name;
        store.parish = parish;
        store.latitude = latitude;
        store.longitude = longitude;
        return store;
    }
}
