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

    /**
     * <p>
     * Update the product
     * </p>
     *
     * @param amazon - product detail
     * @return boolean value
     */
    boolean updateProduct(final Product amazon);

    /**
     * <p>
     * Delete the product
     * </p>
     *
     * @param productId - product detail
     * @return boolean value
     */
    boolean deleteProduct(final int productId);

    /**
     * <p>
     * Read the product
     * </p>
     *
     * @param productId - product detail
     * @return boolean value
     */
    Product readProduct(final int productId);

    /**
     * <p>
     * Get all the product
     * </p>
     *
     * @return product
     */
    Set<Product> getAllProducts();
}