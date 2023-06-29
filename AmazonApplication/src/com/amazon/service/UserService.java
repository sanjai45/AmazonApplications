package com.amazon.service;

import com.amazon.model.User;

/**
 * <p>
 * Represents the user service interface
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
     * @param user represents the new user
     * @return user
     */
    boolean createUser(final User user);

    /**
     * <p>
     * Update the user details
     * </p>
     *
     * @param user represents the user details
     * @return updated user
     */
    boolean updateUser(final User user);

    /**
     * <p>
     * Deletes the user email details
     * </p>
     *
     * @param id represents the user id
     * @return the deleted user
     */
    boolean deleteUser(final Long id);

    /**
     * <p>
     * Gets the user details
     * </p>
     *
     * @param id represents the user id
     * @return user
     */
    User getUser(final Long id);

    /**
     * <p>
     * Represents the sign in action
     * </p>
     *
     * @param email    represents the user email
     * @param password represents the user password
     * @return the email and password
     */
    boolean signIn(final String email, final String password);

    /**
     * <p>
     * Gets the user id
     * </p>
     *
     * @param id represents the user id
     * @return User
     */
    User get(final Long id);
}