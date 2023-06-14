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
    ELECTRONICS(1),
    VEHICLE(2),
    FASHION(3),
    APPLIANCES(4),
    SPORTS(5),
    TOYS(6);

    public int id;

    Category(int id) {
        this.id = id;
    }
}