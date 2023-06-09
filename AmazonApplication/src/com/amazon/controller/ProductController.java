package com.amazon.controller;

import com.amazon.model.Product;
import com.amazon.service.ProductService;
import com.amazon.service.ProductServiceImpl;

import java.util.Set;
/**
 * <p>
 * Intermediate between the user service and user view
 * </p>
 *
 * @author Sanjai S
 * @version 1.0
 */
public class ProductController {

    private static final ProductService PRODUCT_SERVICE = new ProductServiceImpl();

    /**
     * <p>
     * Create the amazon user
     * </p>
     *
     * @param amazon - amazon product
     * @return boolean value
     */
    public boolean createProduct(final Product amazon) {
        return PRODUCT_SERVICE.createProduct(amazon);
    }

    /**
     * <p>
     * Update the product
     * </p>
     *
     * @param amazon - amazon product
     * @return boolean value
     */
    public boolean updateProduct(final Product amazon) {
        return PRODUCT_SERVICE.updateProduct(amazon);
    }

    /**
     * <p>
     * Delete the product
     * </p>
     *
     * @param productId - amazon productId
     * @return boolean value
     */
    public boolean deleteProduct(final int productId) {
        return PRODUCT_SERVICE.deleteProduct(productId);
    }

    /**
     * <p>
     * Reaad the product details
     * </p>
     *
     * @param productId - amazon productId
     * @return Product
     */
    public Product readProduct(final int productId) {
        return PRODUCT_SERVICE.readProduct(productId);
    }

    /**
     * <p>
     * Get all the product details
     * </p>
     *
     * @return Product
     */
    public Set<Product> getAllProducts() {
        return PRODUCT_SERVICE.getAllProducts();
    }
}