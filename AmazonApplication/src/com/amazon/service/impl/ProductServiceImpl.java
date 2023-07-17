package com.amazon.service.impl;

import com.amazon.model.Product;
import com.amazon.service.ProductService;

import java.util.Collection;
import java.util.HashSet;

/**
 * <p>
 * Add and implementation for product details
 * </p>
 *
 * @author Sanjai S
 * @version 1.0
 */
public class ProductServiceImpl implements ProductService {

    private static final Collection<Product> PRODUCTS = new HashSet<>();

    private static int id = 1;

    /**
     * {@inheritDoc}
     * @param product represents the product
     * @return the product
     */
    @Override
    public boolean createProduct(final Product product) {
        product.setId(id++);

        return PRODUCTS.add(product);
    }

    /**
     * {@inheritDoc}
     * @param product represents the product detail
     * @return the updated product
     */
    @Override
    public boolean updateProduct(final Product product) {
        final Product existingProduct = getProduct(product.getId());

        if (null == existingProduct) {
            return false;
        } else {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setCategory(product.getCategory());

            return true;
        }
    }

    /**
     * {@inheritDoc}
     * @param productId represents the product id
     * @return the product is deleted or not
     */
    @Override
    public boolean deleteProduct(final Long productId) {
        final Product product = getProduct(productId);

        return product != null && PRODUCTS.remove(product);
    }

    /**
     * {@inheritDoc}
     * @param productId represents the product id
     * @return the product id is valid or not
     */
    @Override
    public Product getProduct(final long productId) {
        for (final Product product : PRODUCTS) {

            /*if (product.getId().equals(productId)) {
                return product;
            }*/
        }

        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @return product
     */
    @Override
    public Collection<Product> getAllProducts() {
        return PRODUCTS;
    }
}
