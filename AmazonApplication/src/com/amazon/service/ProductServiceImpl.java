package com.amazon.service;

import com.amazon.model.Product;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * Add and implementation for product details
 * </p>
 *
 * @author Sanjai S
 * @version 1.0
 */
public class ProductServiceImpl implements ProductService {

    private static final Set<Product> PRODUCTS = new HashSet<>();

    private static int id = 1;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean createProduct(final Product product) {
        product.setId(Integer.toString(id++));

        return PRODUCTS.add(product);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean updateProduct(final Product product) {
        final Product existingProduct = readProduct(product.getId());

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
     */
    @Override
    public boolean deleteProduct(final String productId) {
        final Product product = readProduct(productId);

        return product != null && PRODUCTS.remove(product);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Product readProduct(final String productId) {
        for (final Product amazon : PRODUCTS) {

            if (amazon.getId().equals(productId)) {
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
