package com.amazon.dao;

import com.amazon.model.User;

public interface UserDAO {
    boolean signUp(final User user);
}
