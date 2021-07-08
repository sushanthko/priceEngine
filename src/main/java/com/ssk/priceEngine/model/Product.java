package com.ssk.priceEngine.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity class for product table.
 */
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private long unitsPerCarton;

    private double cartonPrice;

    public Product() {
    }

    public Product(String name, long unitsPerCarton, double cartonPrice) {
        this.name = name;
        this.unitsPerCarton = unitsPerCarton;
        this.cartonPrice = cartonPrice;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getUnitsPerCarton() {
        return unitsPerCarton;
    }

    public double getCartonPrice() {
        return cartonPrice;
    }

}
