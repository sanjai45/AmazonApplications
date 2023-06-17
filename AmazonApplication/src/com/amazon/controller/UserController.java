package com.amazon.controller;

import com.amazon.model.User;
import com.amazon.service.UserService;
import com.amazon.service.UserServiceImpl;

/**
 * <p>
 * Represents the intermediate between user service and user view
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
     * @param user represents the new user
     * @return user
     */
    public boolean createUser(final User user) {
        return USER_SERVICE.createUser(user);
    }

    /**
     * <p>
     * Update the user details
     * </p>
     *
     * @param user represents the user details
     * @return the updated user
     */
    public boolean updateUser(final User user) {
        return USER_SERVICE.updateUser(user);
    }

    /**
     * <p>
     * Delete the user email details
     * </p>
     *
     * @param id represents the user email
     * @return the deleted user
     */
    public boolean deleteUser(final Long id) {
        return USER_SERVICE.deleteUser(id);
    }

    /**
     * <p>
     * Read the user details
     * </p>
     *
     * @param email represents the user email
     * @return user
     */
    public User getUser(final String email) {
        return USER_SERVICE.getUser(email);
    }

    /**
     * <p>
     * Sign in the user details
     * </p>
     *
     * @param email represents the user email
     * @param password represents the user password
     * @return the email and password
     */
    public boolean signIn(final String email, final String password) {
        return USER_SERVICE.signIn(email, password);
    }

    /**
     * <p>
     * Get the user id
     * </p>
     *
     * @param id represents the user id
     * @return User
     */
    public User get(final Long id) {
        return USER_SERVICE.get(id);
    }
}