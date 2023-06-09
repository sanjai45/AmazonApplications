package com.amazon.controller;
import com.amazon.model.User;
import com.amazon.service.UserService;
import com.amazon.service.UserServiceImpl;

import java.util.Set;

/**
 * <p>
 * Intermediate between the user service and user view
 * </p>
 *
 * @author Sanjai S
 * @version 1.0
 */
public class UserController {

    private static final UserService USER_SERVICE = new UserServiceImpl();

    /**
     * <p>
     * Create the new user
     * </p>
     *
     * @param user - new user email
     * @return boolean value
     */
    public boolean createUser(final User user) {
        return USER_SERVICE.createUser(user);
    }

    /**
     * <p>
     * Update the user details
     * </p>
     *
     * @param user - user details
     * @return boolean value
     */
    public boolean updateUser(final User user) {
        return USER_SERVICE.updateUser(user);
    }

    /**
     * <p>
     * Delete the user email details
     * </p>
     *
     * @param email - user email
     * @return boolean value
     */
    public boolean deleteEmail(final String email) {
        return USER_SERVICE.deleteEmail(email);
    }

    /**
     * <p>
     * Read the user details
     * </p>
     *
     * @param email - user email
     * @return user
     */
    public User getUser(String email) {
        return USER_SERVICE.getUser(email);
    }

    /**
     * <p>
     * Get all the user details
     * </p>
     *
     * @return user
     */
    public Set<User> getAllUsers() {
        return USER_SERVICE.getAllUsers();
    }

    /**
     * <p>
     * Sign in the user details
     * </p>
     *
     * @param email - user email
     * @param password - user password
     * @return boolean value
     */
    public boolean signIn(String email, String password) {
        return USER_SERVICE.signIn(email, password);
    }
}