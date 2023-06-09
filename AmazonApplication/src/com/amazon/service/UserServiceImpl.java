package com.amazon.service;

import com.amazon.model.User;

import java.util.Set;
import java.util.HashSet;

/**
 * <p>
 * Create and implement the crud operation
 * </p>
 *
 * @author Sanjai S
 * @version 1.0
 */
public class UserServiceImpl implements UserService {

    private static final Set<User> USERS = new HashSet<>();
    private static int userId = 0;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean createUser(final User user) {
        for (final User existingUser : USERS) {

            if (existingUser.getEmail().equals(user.getEmail())) {
                return false;
            }
        }
        user.setId(++userId);
        USERS.add(user);
        return true;
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
    public User get(int id) {
        final User user = new User();

        for (final User existingUser : USERS) {

            if (existingUser.getId() == id) {
                user.setEmail(existingUser.getEmail());
                user.setName(existingUser.getName());
                user.setMobileNumber(existingUser.getMobileNumber());
                user.setPassword(existingUser.getPassword());
            }
        }
        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean updateUser(final User user) {
        for (final User existingUser : USERS) {

            if (existingUser.getId() == user.getId()) {
                existingUser.setMobileNumber(user.getMobileNumber());
                existingUser.setName(user.getName());
                existingUser.setPassword(user.getPassword());

                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean deleteEmail(final int id) {
        for (final User user : USERS) {

            if (user.getId() == id) {
                USERS.remove(user);

                return true;
            }
        }
        return false;
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
            }
        }
        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<User> getAllUsers() {
        return USERS;
    }
}