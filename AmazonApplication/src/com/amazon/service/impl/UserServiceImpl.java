package com.amazon.service.impl;

import com.amazon.exception.IdNotFoundException;
import com.amazon.exception.EmailAlreadyExistsException;
import com.amazon.model.User;
import com.amazon.service.UserService;

import java.util.Collection;
import java.util.HashSet;

/**
 * <p>
 * To implement the user service interface
 * </p>
 *
 * @author Sanjai S
 * @version 1.0
 */
public class UserServiceImpl implements UserService {

    private static final Collection<User> USERS = new HashSet<>();
    private static int id = 1;

    /**
     * {@inheritDoc}
     * @param user represents the new user
     * @return user
     */
    @Override
    public boolean createUser(final User user) {
        final User existingUser = getUser((user.getId()));

        if (existingUser != null) {
            throw new EmailAlreadyExistsException("Email Already exists");
        } else {
            user.setId((long) id++);
            USERS.add(user);

            return true;
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param email    represents the user email
     * @param password represents the user password
     * @return the email and password
     */
    @Override
    public boolean signIn(final String email, final String password) {
        final User user = getUser((long) id);

        return user != null && user.getPassword().equals(password);
    }

    /**
     * {@inheritDoc}
     *
     * @param id represents the user id
     * @return User
     */
    @Override
    public User get(final Long id) {
        for (final User user : USERS) {

            if (user.getId().equals(id)) {
                return user;
            }
        }

        throw new IdNotFoundException("User id not found");
    }

    /**
     * {@inheritDoc}
     * @param user represents the user details
     * @return the updated user
     */
    @Override
    public boolean updateUser(final User user) {
        final User existingUser = get(user.getId());

        if (existingUser == null) {
            throw new IdNotFoundException("User Email id  not found");
        } else {
            existingUser.setMobileNumber(user.getMobileNumber());
            existingUser.setName(user.getName());
            existingUser.setPassword(user.getPassword());

            return true;
        }
    }

    /**
     * {@inheritDoc}
     * @param id represents the user email
     * @return the deleted user
     */
    @Override
    public boolean deleteUser(final Long id) {
        final User user = get(id);

        return user != null && USERS.remove(user);
    }

    /**
     * {@inheritDoc}
     *
     * @param id represents the user email
     * @return user
     */
    @Override
    public User getUser(final Long id) {
        for (final User user : USERS) {

            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
}