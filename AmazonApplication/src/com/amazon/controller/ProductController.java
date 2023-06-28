package com.amazon.controller;

import com.amazon.model.Product;
import com.amazon.service.ProductService;
import com.amazon.service.impl.ProductServiceImpl;

import java.util.Collection;


/**
 * <p>
 * Represents the intermediate between product service and product view
 * </p>
 *
 * @author Sanjai S
 * @version 1.0
 */
public class ProductController {

    private static final ProductService PRODUCT_SERVICE = new ProductServiceImpl();

    /**
     * <p>
     * Creates the amazon product
     * </p>
     *
     * @param product represents create amazon product
     * @return the product
     */
    public boolean createProduct(final Product product) {
        return PRODUCT_SERVICE.createProduct(product);
    }

    /**
     * <p>
     * Updates the product
     * </p>
     *
     * @param product represents the update amazon product
     * @return updated product
     */
    public boolean updateProduct(final Product product) {
        return PRODUCT_SERVICE.updateProduct(product);
    }

    /**
     * <p>
     * Deletes the product
     * </p>
     *
     * @param productId represents the amazon product ID
     * @return product id is deleted
     */
    public boolean deleteProduct(final Long productId) {
        return PRODUCT_SERVICE.deleteProduct(productId);
    }

    /**
     * <p>
     * Gets the product details
     * </p>
     *
     * @param productId represents the amazon product ID
     * @return Product
     */
    public Product getProduct(final Long productId) {
        return PRODUCT_SERVICE.getProduct(productId);
    }

    /**
     * <p>
     * Gets all the product details
     * </p>
     *
     * @return Product
     */
    public Collection<Product> getAllProducts() {
        return PRODUCT_SERVICE.getAllProducts();
    }
}