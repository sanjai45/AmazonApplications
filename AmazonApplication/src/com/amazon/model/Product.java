package com.amazon.model;

/**
 * <p>
 * Represents the product details
 * </p>
 *
 * @author Sanjai S
 * @version 1.0
 */
public class Product {

    private Long id;
    private String name;
    private Double price;
    private int category;

    public Product() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public int getCategory() {
        return this.category;
    }

    public void setCategory(final int category) {
        this.category = category;
    }
}