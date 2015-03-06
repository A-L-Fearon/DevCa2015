package models;

import play.db.ebean.Model;

import javax.persistence.Entity;

/**
 * Created by fearon on 3/5/15.
 */
@Entity
public class Stores extends Model {
    public String name;
    public String parish;
    public String coordinates;


    public static Finder<String,Stores> find = new Finder<>(String.class, Stores.class);

}
