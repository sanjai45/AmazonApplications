package com.amazon.view.validation;

import com.amazon.model.Category;

public class ProductValidation {

    public boolean checkCategory(final int id) {
        return id == Category.ELECTRIC.id || id == Category.VEHICLE.id;
    }
}