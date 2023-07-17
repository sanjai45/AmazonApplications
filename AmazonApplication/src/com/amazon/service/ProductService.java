package com.amazon.service;

import com.amazon.model.Product;

import java.util.Collection;

/**
 * <p>
 * Represents the product service interface
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
     * @param product represents the product
     * @return the product
     */
    boolean createProduct(final Product product);

    /**
     * <p>
     * Update the product
     * </p>
     *
     * @param product represents the product detail
     * @return the updated product
     */
    boolean updateProduct(final Product product);

    /**
     * <p>
     * Delete the product
     * </p>
     *
     * @param productId represents the product id
     * @return the product is deleted or not
     */
    boolean deleteProduct(final Long productId);

    /**
     * <p>
     * Gets the product
     * </p>
     *
     * @param productId represents the product id
     * @return the product id is valid or not
     */
    Product getProduct(final long productId);

    /**
     * <p>
     * Gets all the product
     * </p>
     *
     * @return product
     */
    Collection<Product> getAllProducts();
}