package com.amazon.service;

import com.amazon.model.User;

import java.util.Set;

/**
 * <p>
 * Create the crud interface for user
 * </p>
 *
 * @author Sanjai S
 * @version 1.0
 */
public interface UserService {

    /**
     * <p>
     * Create the new user
     * </p>
     *
     * @param user - represents the new user
     * @return boolean value
     */
    boolean createUser(final User user);

    /**
     * <p>
     * Update the user details
     * </p>
     *
     * @param user - represents the user
     * @return boolean value
     */
    boolean updateUser(final User user);

    /**
     * <p>
     * Delete the user email details
     * </p>
     *
     * @param id - represents the user id
     * @return boolean value
     */
    boolean deleteUser(final String id);

    /**
     * <p>
     * Read the user details
     * </p>
     *
     * @param email - represents the user email
     * @return user
     */
    User getUser(final String email);

    /**
     * <p>
     * Get all the user details
     * </p>
     *
     * @return user
     */
    Set<User> getAllUsers();

    /**
     * <p>
     * Sign in the user details
     * </p>
     *
     * @param email - represents the user email
     * @param password - represents the user password
     * @return boolean value
     */
    boolean signIn(final String email, final String password);

    /**
     * <p>
     * Get the user id
     * </p>
     *
     * @param id - represents the user id
     * @return User
     */
    User get(final String id);
}