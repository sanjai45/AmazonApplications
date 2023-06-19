package com.amazon.view;

import com.amazon.controller.UserController;
import com.amazon.model.User;
import com.amazon.view.validation.UserValidation;
import com.amazon.exception.EmailAlreadyExistsException;
import com.amazon.exception.IdNotFoundException;

import java.util.Scanner;

/**
 * <p>
 * Represents the user view sign up and sign in details 
 * </p>
 *
 * @author Sanjai S
 * @version 1.0
 */
public class UserView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final UserView USER_VIEW = new UserView();
    private static final UserController USER_CONTROLLER = new UserController();
    private static final UserValidation USER_VALIDATION = new UserValidation();
    private static final ProductView PRODUCT_VIEW = new ProductView();
    private static final String CONDITION = "yes";

    public static void main(String[] args) {
        System.out.println("Welcome to Amazon");
        USER_VIEW.userType();
    }

    /**
     * <p>
     * Choose the admin user or user
     * </p>
     */
    private void userType() {
        System.out.println("Please Enter 1. Admin user and 2. User");
        final int choice = SCANNER.nextInt();

        switch (choice) {
            case 1: {
                this.adminUser();
                break;
            }
            case 2: {
                this.userDetails();
                break;
            }
            default: {
                System.out.println("Please enter the number between [1 - 3]");
            }
        }
    }

    /**
     * <p>
     * Choose signIn or signup or product details for admin user
     * </p>
     */
    private void adminUser() {
        System.out.println("Please Enter 1. signUp, 2. signIn, 3. userDetailsChange, 4. product details, 5. home screen and 5. exit");
        final int choice = SCANNER.nextInt();
        final User user = new User();

        switch (choice) {
            case 1: {
                this.signUp(user);
                break;
            }
            case 2: {
                this.signIn();
                break;
            }
            case 3: {
                this.userDetailChange();
                break;
            }
            case 4: {
                PRODUCT_VIEW.productDetails();
                break;
            }
            case 5: {
                this.homeScreen(user.getId());
                break;
            }
            case 6: {
                System.exit(0);
            }
            default: {
                System.out.println("Please enter the number between [1 - 6]");
            }
        }
        USER_VIEW.adminUser();
    }

    /**
     * <p>
     * Choose signIn or signup handle for user
     * </p>
     */
    private void userDetails() {
        System.out.println("Please Enter 1. signUp, 2. signIn and 3. userDetailChange 4. exit");
        final int choice = SCANNER.nextInt();
        final User user = new User();

        switch (choice) {
            case 1: {
                this.signUp(user);
                break;
            }
            case 2: {
                this.signIn();
                this.homeScreen(user.getId());
                break;
            }
            case 3: {
                this.userDetailChange();
                break;
            }
            case 4: {
                System.exit(0);
            }
            default: {
                System.out.println("Please enter the number between [1 - 4]");
            }
        }
        USER_VIEW.userDetails();
    }

    /**
     * <p>
     * Choose category, profile or settings for user
     * </p>
     *
     * @param userId represents for user id
     */
    private void homeScreen(final Long userId) {
        System.out.println("Please Enter 1. Category, 2. profile and 3. settings 4. exit");
        final int choice = SCANNER.nextInt();

        switch (choice) {
            case 1: {
                PRODUCT_VIEW.showAllCategories();
                break;
            }
            case 2: {
                this.profile(userId);
                break;
            }
            case 3: {
                this.settings();
                break;
            }
            case 4: {
                System.exit(0);
            }
            default: {
                System.out.println("Please enter the number between [1 - 4]");
            }
        }
        USER_VIEW.homeScreen(userId);
    }

    /**
     * <p>
     * Represents the profile for user details
     * </p>
     *
     * @param userId represents the user id
     */
    private void profile(final Long userId) {
        final User user = USER_CONTROLLER.get(userId);

        System.out.println(user);
    }

    /**
     * <p>
     * Represents the setting for user details change
     * </p>
     */
    private void settings() {
        this.userDetailChange();
    }

    /**
     * <p>
     * To perform the update, delete and get operation
     * </p>
     */
    private void userDetailChange() {
        System.out.println("Enter your choice");
        System.out.println("Choose 1 to update user details, 2 to delete user details, 3 to get user details and 4 to exit");
        final int input = SCANNER.nextInt();

        switch (input) {
            case 1: {
                this.updateUser();
                break;
            }
            case 2: {
                this.deleteUser();
                break;
            }
            case 3: {
                this.getUser();
                break;
            }
            case 4: {
                System.exit(0);
            }
            default: {
                System.out.println("Please enter the number between [1 - 4]");
            }
        }
        USER_VIEW.userDetailChange();
    }

    /**
     * <p>
     * Represents the signIn action
     * </p>
     */
    private void signIn() {
        try {
            System.out.println("SignIn");
            final String email = USER_VIEW.getEmail();
            final String password = USER_VIEW.getPassword();

            if (USER_CONTROLLER.signIn(email, password)) {
                System.out.println("SignIn successfully");
            } else {
                System.out.println("user email or password not found");
                USER_VIEW.signIn();
            }
        } catch (NullPointerException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * <p>
     * Gets the name, email, password and phone
     * </p>
     */
    private void getUser() {
        try {
            System.out.println("Please Enter the user id");
            final Long id = SCANNER.nextLong();
            final User user = USER_CONTROLLER.get(id);

            System.out.println("Your details");
            System.out.println(user);
        } catch (IdNotFoundException idNotFoundException) {
            System.out.println(idNotFoundException.getMessage());
            getUser();
        }
    }

    /**
     * <p>
     * Deletes the user
     * </p>
     */
    private void deleteUser() {
        System.out.println("Delete");
        System.out.println("Enter the user id");
        final Long id = SCANNER.nextLong();

        System.out.println((USER_CONTROLLER.deleteUser(id)) ? "User deleted successfully" : "User not deleted");
    }

    /**
     * <p>
     * Updates the user
     * </p>
     */
    private void updateUser() {
        System.out.println("update");
        final User user = new User();

        System.out.println("Enter the user id");
        user.setId(SCANNER.nextLong());
        final String email = getEmail();

        user.setEmail(email);
        final User existingUser = USER_CONTROLLER.getUser(email);

        System.out.println("Do you want to update the name, Please enter yes");
        final String updateName = SCANNER.next();

        if (CONDITION.equalsIgnoreCase(updateName)) {
            user.setName(getName());
        } else {
            user.setName(existingUser.getEmail());
        }

        System.out.println("Do you want to update the password, Please enter yes");
        final String updatePassword = SCANNER.next();

        if (CONDITION.equalsIgnoreCase(updatePassword)) {
            user.setPassword(getPassword());
        } else {
            user.setPassword(existingUser.getPassword());
        }
        System.out.println("Do you want to update the mobile, Please enter yes");
        final String updateMobileNumber = SCANNER.next();

        if (CONDITION.equalsIgnoreCase(updateMobileNumber)) {
            user.setMobileNumber(getMobileNumber());
        } else {
            user.setMobileNumber(existingUser.getMobileNumber());
        }

        if (USER_CONTROLLER.updateUser(user)) {
            System.out.println("Updated successfully " + user);
        } else {
            System.out.println("Email not found, please enter correct email id");
            updateUser();
        }
    }

    /**
     * <p>
     * Represents the signUp action
     * </p>
     */
    private void signUp(final User user) {
        try{
            System.out.println("SignUp");

            user.setEmail(getEmail());
            user.setName(getName());
            user.setPassword(getPassword());
            user.setMobileNumber(getMobileNumber());
            if (USER_CONTROLLER.createUser(user)) {
                System.out.println("Signup successfully");
            }
        } catch (EmailAlreadyExistsException existsException) {
            System.out.println(existsException.getMessage());
        }
    }

    /**
     * <p>
     * Gets the user email
     * </p>
     *
     * @return {@link String} email
     */
    private String getEmail() {
        System.out.println("Enter the User Email");
        final String email = SCANNER.next();

        if (USER_VALIDATION.checkEmail(email)) {
            return email;
        } else {
            System.out.println("Please Enter the valid Email");
            return getEmail();
        }
    }

    /**
     * <p>
     * Gets the user name
     * </p>
     *
     * @return {@link String} name
     */
    private String getName() {
        System.out.println("Enter your name");
        final String name = SCANNER.next();

        if (USER_VALIDATION.checkName(name)) {
            return name;
        } else {
            System.out.println("Please Enter the valid name");
            return getName();
        }
    }

    /**
     * <p>
     * Gets the user mobile number
     * </p>
     *
     * @return {@link String} mobile number
     */
    private String getMobileNumber() {
        System.out.println("Enter your phone number");
        final String phoneNumber = SCANNER.next();

        if (USER_VALIDATION.checkMobileNumber(phoneNumber)) {
            return phoneNumber;
        } else {
            System.out.println("Please Enter the valid phone number");
            return getMobileNumber();
        }
    }

    /**
     * <p>
     * Gets the user password
     * </p>
     *
     * @return {@link String} password
     */
    private String getPassword() {
        System.out.println("Enter the password");
        final String password = SCANNER.next();

        if (USER_VALIDATION.checkPassword(password)) {
            return password;
        } else {
            System.out.println("Please Enter the valid Passwords");
            return getPassword();
        }
    }
}