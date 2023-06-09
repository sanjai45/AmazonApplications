package com.amazon.service;

import com.amazon.model.Product;

import java.util.Set;

/**
 * <p>
 * Create the crud interface for service
 * </p>
 *
 * @author Sanjai S
 * @version 1.0
 */
public interface ProductService {

    /**
     * <p>
     * Create the product
     * </p>
     *
     * @param amazon - amazon user
     * @return boolean value
     */
    boolean createProduct(final Product amazon);

    boolean updateProduct(final Product amazon);

    boolean deleteProduct(final int productId);

    Product readProduct(final int productId);

    Set<Product> getAllProducts();
}