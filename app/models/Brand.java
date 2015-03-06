package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Shane on 3/5/2015.
 */

@Entity
public class Brand extends Model {
    @Id
    public Long id;

    public String name;

    public static Brand create(Brand brand, String name) {
        brand.name = name;
        brand.save();
        return brand;
    }
}
