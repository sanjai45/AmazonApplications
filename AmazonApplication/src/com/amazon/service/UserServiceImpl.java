package com.amazon.service;

import com.amazon.model.User;

import java.util.Set;
import java.util.HashSet;

/**
 * <p>
 * Add and implementation for user details
 * </p>
 *
 * @author Sanjai S
 * @version 1.0
 */
public class UserServiceImpl implements UserService {

    private static final Set<User> USERS = new HashSet<>();
    private static int id = 1;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean createUser(final User user) {
        final User existingUser = getUser(user.getEmail());

        if (existingUser != null) {
            return false;
        } else {
            user.setId((long) id++);
            USERS.add(user);

            return true;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean signIn(final String email, final String password) {
        final User user = getUser(email);

       return user != null && user.getPassword().equals(password);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User get(final Long id) {
        final User user = new User();

        for (final User existingUser : USERS) {

            if (existingUser.getId().equals(id)) {
                user.setEmail(existingUser.getEmail());
                user.setName(existingUser.getName());
                user.setMobileNumber(existingUser.getMobileNumber());
                user.setPassword(existingUser.getPassword());

                return user;
            }
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean updateUser(final User user) {
        final User existingUser = get(user.getId());

        if (existingUser == null) {
            return false;
        } else {
            existingUser.setMobileNumber(user.getMobileNumber());
            existingUser.setName(user.getName());
            existingUser.setPassword(user.getPassword());

            return true;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean deleteUser(final Long id) {
        final User user = get(id);

        return user != null && USERS.remove(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUser(final String email) {
        final User user = new User();

        for (final User existingUser : USERS) {

            if (existingUser.getEmail().equals(email)) {
                user.setName(existingUser.getName());
                user.setMobileNumber(existingUser.getMobileNumber());
                user.setPassword(existingUser.getPassword());

                return user;
            }
        }
        return null;
    }
}