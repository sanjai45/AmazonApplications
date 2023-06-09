package com.amazon.service;

import com.amazon.model.Product;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * Add product and implement operation
 * </p>
 *
 * @author Sanjai S
 * @version 1.0
 */
public class ProductServiceImpl implements ProductService {

    private static final Set<Product> PRODUCTS = new HashSet<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean createProduct(final Product amazon) {
        return PRODUCTS.add(amazon);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean updateProduct(final Product amazon) {
        for (final Product amazon1 : PRODUCTS) {

            if (amazon1.getId() == amazon.getId()) {
                amazon1.setName(amazon.getName());
                amazon1.setPrice(amazon.getPrice());
                amazon1.setCategory(amazon.getCategory());

                return true;
            }
        }

        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean deleteProduct(int productId) {
        for (final Product amazon : PRODUCTS) {

            if (amazon.getId() == productId) {
                return PRODUCTS.remove(amazon);
            }
        }

        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Product readProduct(int productId) {
        for (final Product amazon : PRODUCTS) {

            if (amazon.getId() == productId) {
                return amazon;
            }
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Product> getAllProducts() {
        return PRODUCTS;
    }
}
