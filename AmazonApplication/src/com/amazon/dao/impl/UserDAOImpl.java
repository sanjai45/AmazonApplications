package com.amazon.dao.impl;

import com.amazon.dao.UserDAO;
import com.amazon.model.User;
import com.amazon.service.UserService;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    private static UserDAOImpl USERSERVICEDAOIMPL = null;

    private UserDAOImpl() {}

    public static UserDAOImpl getInstance() {
        if (null == USERSERVICEDAOIMPL) {
            USERSERVICEDAOIMPL = new UserDAOImpl();
        }
        return USERSERVICEDAOIMPL;
    }

    public boolean createUser(final User user) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/users", "postgres", "sanjai");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USERS VALUES (?,?,?,?,?)");
            preparedStatement.setLong(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getMobileNumber());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }


}

