package com.amazon.dao.impl;

import com.amazon.model.Product;
import com.amazon.service.ProductService;

import java.sql.*;
import java.util.Collection;
import java.util.HashSet;

public class ProductDAOImpl implements ProductService {

    @Override
    public boolean createProduct(final Product product) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/products", "postgres", "sanjai");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO product VALUES (?,?,?,?)");

            preparedStatement.setLong(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getCategory());
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException(classNotFoundException);
        }
        return false;
    }

    @Override
    public boolean updateProduct(final Product product) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/products", "postgres", "sanjai");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE product SET name = ?, price = ?, category = ? WHERE id = ?");

            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getCategory());
            preparedStatement.setLong(4, product.getId());
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException(classNotFoundException);
        }
        return false;
    }

    @Override
    public boolean deleteProduct(final Long productId) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/products", "postgres", "sanjai");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM product WHERE id = ?");

            preparedStatement.setLong(1, productId);
            int rowDeleted = preparedStatement.executeUpdate();

            if (0 < rowDeleted) {
                return true;
            }
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException(classNotFoundException);
        }

        return false;
    }

    @Override
    public Product getProduct(final long productId) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/products", "postgres", "sanjai");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product WHERE id = ?");

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
        } catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException(classNotFoundException);
        }
        return null;
    }

    @Override
    public Collection<Product> getAllProducts() {
        final Collection<Product> products = new HashSet<>();
        try {
            Class.forName("org.postgresql.Driver");
            final Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/products", "postgres", "sanjai");
            final PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product");
            final ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                final Product product = new Product();

                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice((double) resultSet.getLong("price"));
                product.setCategory(Integer.parseInt(resultSet.getString("category")));
                products.add(product);

                return products;
            }
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException(classNotFoundException);
        }
        return null;
    }
}
