package com.amazon.model;

/**
 * <p>
 * Create the pojo class
 * </p>
 *
 * @author Sanjai S
 * @version 1.0
 */
public class User {

    private String name;
    private String email;
    private String mobileNumber;
    private String password;

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setMobileNumber(final String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}