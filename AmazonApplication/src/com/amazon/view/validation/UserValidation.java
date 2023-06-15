package com.amazon.view.validation;

/**
 * <p>
 * Check the user validation
 * </p>
 *
 * @author Sanjai S
 * @version 1.0
 */
public class UserValidation {

    /**
     * <p>
     * Check the email is valid or not
     * </p>
     *
     * @return boolean value
     */
    public boolean checkEmail(final String email) {
        return email.matches("[A-Za-z0-9]+@[a-z]+\\.[a-z]{2,4}");
    }

    /**
     * <p>
     * Check the name is valid or not
     * </p>
     *
     * @return boolean value
     */
    public boolean checkName(final String name) {
        return name.matches("[a-zA-Z]+\\.?");
    }

    /**
     * <p>
     * Check the mobile number is valid or not
     * </p>
     *
     * @return boolean value
     */
    public boolean checkMobileNumber(final String phoneNumber) {
        return phoneNumber.matches("(0/91)?[7-9][0-9]{9}");
    }

    /**
     * <p>
     * Check the password validation
     * </p>
     *
     * @return boolean value
     */
    public boolean checkPassword(final String password) {
        return password.matches("^.*(?=.{8,})(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$");
    }
}