package com.amazon.dao.impl;

import com.amazon.model.Product;
import com.amazon.service.ProductService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

public class ProductDAOImpl implements ProductService {

    @Override
    public boolean createProduct(final Product product) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Products", "postgres", "sanjai");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USERS VALUES (?,?,?,?)");
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
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Products", "postgres", "sanjai");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USERS VALUES (?,?,?,?)");
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
    public boolean deleteProduct(final Long productId) {
        final Product product = new Product();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Products", "postgres", "sanjai");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USERS VALUES (?,?,?,?)");
            preparedStatement.setLong(1, product.getId());
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
    public Product getProduct(final Long productId) {
        final Product product = new Product();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Products", "postgres", "sanjai");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USERS VALUES (?,?,?,?)");
            preparedStatement.setLong(1, product.getId());
            preparedStatement.executeUpdate();

            return product;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException(classNotFoundException);
        }
        return null;
    }

    @Override
    public Collection<Product> getAllProducts() {
        return null;
    }
}
