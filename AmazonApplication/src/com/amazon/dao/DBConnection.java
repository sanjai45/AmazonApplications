package com.amazon.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

class DBConnection {

    public static void main(String[] args) {
        final String QUERY = "SELECT * FROM users";

        try (final Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Products", "postgres", "sanjai");
             final Statement statement = connection.createStatement();
             final ResultSet resultSet = statement.executeQuery(QUERY)) {
            
            while (resultSet.next()) {
                System.out.print(" user_id: " + resultSet.getInt("user_id"));
                System.out.print(", user_name: " + resultSet.getString("user_name"));
                System.out.print(", user_email: " + resultSet.getString("user_email"));
                System.out.print(", user_mobile number: " + resultSet.getString("user_mobile number"));
                System.out.println(", user_password: " + resultSet.getString("user_password") + ".");
            }
            connection.close();
            statement.close();
            resultSet.close();
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }

    }
}