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
     * @param user - new user email
     * @return boolean value
     */
    boolean createUser(final User user);

    /**
     * <p>
     * Update the user details
     * </p>
     *
     * @param user - user details
     * @return boolean value
     */
    boolean updateUser(final User user);

    /**
     * <p>
     * Delete the user email details
     * </p>
     *
     * @param email - user email
     * @return boolean value
     */
    boolean deleteEmail(final String email);

    /**
     * <p>
     * Read the user details
     * </p>
     *
     * @param email - user email
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
     * @param email - user email
     * @param password - user password
     * @return boolean value
     */
    boolean signIn(final String email, final String password);


}