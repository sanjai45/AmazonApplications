package com.amazon.dao.impl;

import com.amazon.model.Product;
import com.amazon.service.ProductService;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>
 * Add and implementation for product details
 * </p>
 *
 * @author Sanjai S
 * @version 1.0
 */
public class ProductDAOImpl implements ProductService {

    /**
     * {@inheritDoc}
     * @param product represents the product
     * @return the product
     */
    @Override
    public boolean createProduct(final Product product) {
        try (final Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Products", "postgres", "Arun@2002");
             final PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO product VALUES (?,?,?,?)")) {

            preparedStatement.setLong(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getCategory());
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return false;
    }

    /**
     * {@inheritDoc}
     * @param product represents the product detail
     * @return the updated product
     */
    @Override
    public boolean updateProduct(final Product product) {
        try (final Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Products", "postgres", "Arun@2002");
             final PreparedStatement preparedStatement = connection.prepareStatement("UPDATE product SET name = ?, price = ?, category = ? WHERE id = ?")) {

            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getCategory());
            preparedStatement.setLong(4, product.getId());
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteProduct(final Long productId) {
        try (final Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Products", "postgres", "Arun@2002");
             final PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM product WHERE id = ?")) {

            preparedStatement.setLong(1, productId);
            final int rowDeleted = preparedStatement.executeUpdate();

            if (0 < rowDeleted) {
                return true;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return false;
    }

    @Override
    public Product getProduct(final Long productId) {
        try (final Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Products", "postgres", "Arun@2002");
             final PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product WHERE id = ?")) {

            preparedStatement.setLong(1, productId);
            final ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                final Product products = new Product();

                products.setId(resultSet.getLong("id"));
                products.setName(resultSet.getString("name"));
                products.setPrice((double) resultSet.getLong("price"));
                products.setCategory(Integer.parseInt(resultSet.getString("category")));

                return products;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<Product> getAllProducts() {
        final Collection<Product> products = new ArrayList<>();

        try (final Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Products", "postgres", "Arun@2002");
            final PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product");
            final ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                final Product product = new Product();

                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice((double) resultSet.getLong("price"));
                product.setCategory(Integer.parseInt(resultSet.getString("category")));
                products.add(product);

                return products;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }
}
