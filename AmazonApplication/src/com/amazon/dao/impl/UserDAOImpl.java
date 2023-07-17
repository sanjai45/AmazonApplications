package com.amazon.dao.impl;

import com.amazon.model.User;
import com.amazon.service.UserService;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class UserDAOImpl implements UserService {

    public UserDAOImpl() {}

    @Override
    public boolean createUser(final User user) {
        try {
            Class.forName("org.postgresql.Driver");
            final Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/products", "postgres", "sanjai");
            final PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USERS VALUES (?,?,?,?,?)");

            preparedStatement.setLong(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getMobileNumber());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean signIn(final String email, final String password) {
        final User user = new User();

        try {
            Class.forName("org.postgresql.Driver");
            final Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/products", "postgres", "sanjai");
            final PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USERS VALUES (?,?,?)");

            preparedStatement.setLong(1, user.getId());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException(classNotFoundException);
        }
        return false;
    }

    @Override
    public boolean updateUser(final User user) {
        try {
            final Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/products", "postgres", "sanjai");
            final PreparedStatement preparedStatement = connection.prepareStatement("UPDATE USERS SET name = ?, password = ?, mobile_number = ? WHERE id = ?");

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getMobileNumber());
            preparedStatement.setLong(4, user.getId());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUser(final Long id) {
        try {
            final Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/products", "postgres", "sanjai");
            final PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM USERS WHERE id = ?");

            preparedStatement.setLong(1, id);
            final int rowDeleted = preparedStatement.executeUpdate();

            if (0 < rowDeleted) {
                return true;
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public User getUser(final Long id) {
        try {
            final Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/products", "postgres", "sanjai");
            final PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USERS WHERE id = ?");

            preparedStatement.setLong(1, id);
            final ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                final User user = new User();

                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setMobileNumber(resultSet.getString("mobile_number"));
                user.setPassword(resultSet.getString("password"));

                return user;
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Long get(final Long id) {
        final User user = new User();
        try {
            final Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/products", "postgres", "sanjai");
            final PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM USERS WHERE email = ? OR mobile_number = ?");

            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getMobileNumber());
            final ResultSet resultSet = preparedStatement.executeQuery();

            connection.close();

            if (resultSet.next()) {
                return resultSet.getLong("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}