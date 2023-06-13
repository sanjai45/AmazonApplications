package com.amazon.model;

/**
 * <p>
 * Create the enum category
 * </p>
 *
 * @author Sanjai S
 * @version 1.0
 */
public enum Category {
    ELECTRIC(1),
    VEHICLE(2);

    public int id;

    Category(int id) {
        this.id = id;
    }
}