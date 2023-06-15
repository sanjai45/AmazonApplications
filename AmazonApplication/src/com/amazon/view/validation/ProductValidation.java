package com.amazon.view.validation;

import com.amazon.model.Category;

/**
 * <p>
 * Check the validation for product
 * </p>
 *
 * @author Sanjai S
 * @version 1.0
 */
public class ProductValidation {

    /**
     * <p>
     * Check the category id is valid or not
     * </p>
     *
     * @return boolean value
     */
    public boolean checkCategory(final String  id) {
        return id == Category.ELECTRONICS.id || id == Category.VEHICLE.id || id == Category.FASHION.id || id == Category.APPLIANCES.id || id == Category.SPORTS.id || id == Category.TOYS.id;
    }
}