package com.amazon.view;

import com.amazon.controller.UserController;
import com.amazon.model.User;
import com.amazon.view.validation.UserValidation;
import com.amazon.exception.EmailAlreadyExistsException;

import java.util.Collection;
import java.util.Scanner;

/**
 * <p>
 * A user view sign in and sign up handle
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
        USER_VIEW.users();
    }

    /**
     * <p>
     * Choose the Admin user or user
     * </>
     *
     * @return {@link String} users
     */
    private String users() {
        System.out.println("Please Enter 1. Admin user and 2. User 3. exit");
        final int choice = SCANNER.nextInt();

        switch (choice) {
            case 1: {
                USER_VIEW.adminUser();
                break;
            }
            case 2: {
                USER_VIEW.user();
                break;
            }
            case 3: {
                System.exit(0);
            }
            default: {
                System.out.println("Please enter the number between [1 - 3]");
            }
        }
        return users();
    }

    /**
     * <p>
     * Admin user sign up and sign in and create product
     * </p>
     */
    private void adminUser() {
        USER_VIEW.userDetails();
        PRODUCT_VIEW.productDetails();
    }

    /**
     * <p>
     * User sign up or sign in
     * </p>
     */
    private void user() {
        USER_VIEW.userDetails();
    }

    /**
     * <p>
     * Choose signIn or signup handle
     * </p>
     *
     * return {@link String} userDetails
     */
    private String userDetails() {
        System.out.println("Please Enter 1. signUp and 2. signIn 3. exit");
        final int choice = SCANNER.nextInt();

        switch (choice) {
            case 1: {
                USER_VIEW.signUp();
                break;
            }
            case 2: {
                USER_VIEW.signIn();
                USER_VIEW.userCrud();
                break;
            }
            case 3: {
                System.exit(0);
            }
            default: {
                System.out.println("Please enter the number between [1 - 3]");
            }
        }
        return userDetails();
    }

    /**
     * <p>
     * To perform the update, delete and get operation
     * </p>
     *
     * return {@link String} userCrud
     */
    private String userCrud() {
        System.out.println("Enter your choice");
        System.out.println("Choose 1 to update, 2 to delete, 3 to read, 4 to get all users, 5 to exit");
        final int input = SCANNER.nextInt();

        switch (input) {
            case 1: {
                USER_VIEW.updateUser();
                break;
            }
            case 2: {
                USER_VIEW.deleteEmail();
                break;
            }
            case 3: {
                USER_VIEW.readUser();
                break;
            }
            case 4: {
                USER_VIEW.readAllUsers();
                break;
            }
            case 5: {
                System.exit(0);
            }
        }
        return userCrud();
    }

    /**
     * <p>
     * SignIn the user details
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
     * Read the name, email, password and phone
     * </p>
     */
    private void readUser() {
        System.out.println("Please Enter the user id");
        final int id = SCANNER.nextInt();
        final User user = USER_CONTROLLER.get(id);

        if (user.getEmail() == null) {
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
     * Read all the user
     * </p>
     */
    private void readAllUsers(){
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
     * Deletes the user details
     * </p>
     */
    private void deleteEmail() {
        System.out.println("Delete");
        final int id = SCANNER.nextInt();

        if (USER_CONTROLLER.deleteEmail(id)) {
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
        user.setId(SCANNER.nextInt());
        final String email = USER_VIEW.getEmail();

        user.setEmail(email);
        final User existingUser = USER_CONTROLLER.getUser(email);

        System.out.println("Do you want to update the name, Please enter yes");
        final String updateName = SCANNER.next();

        if ("yes".equalsIgnoreCase(updateName)) {
            user.setName(USER_VIEW.getName());
        } else {
            user.setEmail(existingUser.getEmail());
        }
        System.out.println("Do you want to update the password, Please enter yes");
        final String updatePassword = SCANNER.next();

        if ("yes".equalsIgnoreCase(updatePassword)) {
            user.setPassword(USER_VIEW.getPassword());
        } else {
            user.setPassword(existingUser.getPassword());
        }
        System.out.println("Do you want to update the mobile, Please enter yes");
        final String updateMobileNumber = SCANNER.next();

        if ("yes".equalsIgnoreCase(updateMobileNumber)) {
            user.setMobileNumber(USER_VIEW.getMobileNumber());
        } else {
            user.setMobileNumber(existingUser.getMobileNumber());
        }

        if (USER_CONTROLLER.updateUser(user)) {
            System.out.println("Updated successfully" + user);
        } else {
            System.out.println("Email not found, please enter correct email id");
            USER_VIEW.updateUser();
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

            user.setEmail(USER_VIEW.getEmail());
            user.setName(USER_VIEW.getName());
            user.setPassword(USER_VIEW.getPassword());
            user.setMobileNumber(USER_VIEW.getMobileNumber());
            USER_CONTROLLER.createUser(user);
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