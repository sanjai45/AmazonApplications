package com.amazon.view;

import com.amazon.controller.UserController;
import com.amazon.model.User;
import com.amazon.view.validation.UserValidation;
import com.amazon.exception.EmailAlreadyExistsException;

import java.util.Collection;
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
        System.out.println("Please Enter 1. Admin user and 2. User 3. exit");
        final int choice = SCANNER.nextInt();

        switch (choice) {
            case 1: {
                adminUser();
                break;
            }
            case 2: {
                userDetails();
                break;
            }
            case 3: {
                System.exit(0);
            }
            default: {
                System.out.println("Please enter the number between [1 - 3]");
            }
        }
        userType();
    }

    /**
     * <p>
     * Choose signIn or signup or product details for admin user
     * </p>
     */
    private void adminUser() {
        System.out.println("Please Enter 1. signUp, 2. signIn and 3. product details 4. exit");
        final int choice = SCANNER.nextInt();

        switch (choice) {
            case 1: {
                signUp();
                break;
            }
            case 2: {
                signIn();
                break;
            }
            case 3: {
                PRODUCT_VIEW.productDetails();
            }
            case 4: {
                System.exit(0);
            }
            default: {
                System.out.println("Please enter the number between [1 - 4]");
            }
        }
        adminUser();
    }

    /**
     * <p>
     * Choose signIn or signup handle for user
     * </p>
     */
    private void userDetails() {
        System.out.println("Please Enter 1. signUp and 2. signIn 3. exit");
        final int choice = SCANNER.nextInt();

        switch (choice) {
            case 1: {
                signUp();
                break;
            }
            case 2: {
                signIn();
                userDetailChange();
                break;
            }
            case 3: {
                System.exit(0);
            }
            default: {
                System.out.println("Please enter the number between [1 - 3]");
            }
        }
        userDetails();
    }

    /**
     * <p>
     * To perform the update, delete and get operation
     * </p>
     */
    private void userDetailChange() {
        System.out.println("Enter your choice");
        System.out.println("Choose 1 to update, 2 to delete, 3 to read, 4 to get all users, 5 to exit");
        final int input = SCANNER.nextInt();

        switch (input) {
            case 1: {
                updateUser();
                break;
            }
            case 2: {
                deleteUser();
                break;
            }
            case 3: {
                getUser();
                break;
            }
            case 4: {
                getAllUsers();
                break;
            }
            case 5: {
                System.exit(0);
            }
        }
        userDetailChange();
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
            System.out.println(exception);
        }
    }

    /**
     * <p>
     * Gets the name, email, password and phone
     * </p>
     */
    private void getUser() {
        System.out.println("Please Enter the user id");
        final String id = SCANNER.next();
        final User user = USER_CONTROLLER.get(id);

        if (null == user.getEmail()) {
            System.out.println("user not found");
        } else {
            System.out.println("Your details");
            System.out.println(user.getName());
            System.out.println(user.getEmail());
            System.out.println(user.getPassword());
            System.out.println(user.getMobileNumber());
        }
    }

    /**
     * <p>
     * Get all the user
     * </p>
     */
    private void getAllUsers() {
        final Collection<User> users = USER_CONTROLLER.getAllUsers();

        if (!users.isEmpty()) {
            System.out.println("User details");

            for (final User user : users) {
                System.out.println(user.getName());
                System.out.println(user.getEmail());
                System.out.println(user.getPassword());
                System.out.println(user.getMobileNumber());
            }
        } else {
            System.out.println("users not found");
        }
    }

    /**
     * <p>
     * Delete the user email
     * </p>
     */
    private void deleteUser() {
        System.out.println("Delete");
        final String id = SCANNER.next();

        if (USER_CONTROLLER.deleteUser(id)) {
            System.out.println("User deleted successfully");
        } else {
            System.out.println("User not deleted");
        }
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
        user.setId(SCANNER.next());
        final String email = getEmail();

        user.setEmail(email);
        final User existingUser = USER_CONTROLLER.getUser(email);

        System.out.println("Do you want to update the name, Please enter yes");
        final String updateName = SCANNER.next();

        if ("yes".equalsIgnoreCase(updateName)) {
            user.setName(getName());
        } else {
            user.setName(existingUser.getEmail());
        }
        System.out.println("Do you want to update the password, Please enter yes");
        final String updatePassword = SCANNER.next();

        if ("yes".equalsIgnoreCase(updatePassword)) {
            user.setPassword(getPassword());
        } else {
            user.setPassword(existingUser.getPassword());
        }
        System.out.println("Do you want to update the mobile, Please enter yes");
        final String updateMobileNumber = SCANNER.next();

        if ("yes".equalsIgnoreCase(updateMobileNumber)) {
            user.setMobileNumber(getMobileNumber());
        } else {
            user.setMobileNumber(existingUser.getMobileNumber());
        }

        if (USER_CONTROLLER.updateUser(user)) {
            System.out.println("Updated successfully" + user);
        } else {
            System.out.println("Email not found, please enter correct email id");
            updateUser();
        }
    }

    /**
     * <p>
     * Signup the user
     * </p>
     */
    private void signUp() {
        try{
            System.out.println("SignUp");
            final User user = new User();

            user.setEmail(getEmail());
            user.setName(getName());
            user.setPassword(getPassword());
            user.setMobileNumber(getMobileNumber());
            if (!USER_CONTROLLER.createUser(user)) {
                System.out.println("Signup successfully");
            }
        } catch (EmailAlreadyExistsException existsException) {
            System.out.println(existsException.getMessage());
        }
    }

    /**
     * <p>
     * Get the user email
     * </p>
     *
     * @return {@link String} email
     */
    private String getEmail() {
        System.out.println("Enter the User Email");
        final String emailId = SCANNER.next();

        if (USER_VALIDATION.checkEmail(emailId)) {
            return emailId;
        } else {
            System.out.println("Please Enter the valid Email");
            return getEmail();
        }
    }

    /**
     * <p>
     * Get the user name
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
     * Get the user mobile number
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
     * Get the user password
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