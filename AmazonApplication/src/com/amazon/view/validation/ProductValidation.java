package com.amazon.view.validation;

import com.amazon.model.Category;

/**
 * <p>
 * Validation for product
 * </p>
 *
 * @author Sanjai S
 * @version 1.0
 */
public class ProductValidation {

    public boolean checkCategory(final int id) {
        return id == Category.ELECTRIC.id || id == Category.VEHICLE.id;
    }
}