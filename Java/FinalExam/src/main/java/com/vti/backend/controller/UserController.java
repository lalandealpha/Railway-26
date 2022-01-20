package com.vti.backend.controller;

import com.vti.backend.service.IUserService;
import com.vti.backend.service.UserService;
import com.vti.entity.User;
import com.vti.utils.RegexUtils;
import com.vti.utils.ScannerUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserController {
    IUserService userService;
    ScannerUtils scannerUtils;

    public UserController() throws SQLException, IOException, ClassNotFoundException {
        userService = new UserService();
        scannerUtils = new ScannerUtils();
    }

    public List<User> getUserList() throws SQLException {
        return userService.getUserList();
    }

    public void login() throws Exception {
        System.out.println("Enter your email:");
        while (true) {
            String email = scannerUtils.inputString();
            if (!RegexUtils.isEmail(email)) {
                System.err.println(("Invalid email domain (abc@xxx.yyy or abc@xxx.yyy.zzz)."));
            } else {
                System.out.println("Enter your password:");
                while (true) {
                    String password = scannerUtils.inputString();
                    if (!RegexUtils.isPassword(password)) {
                        System.err.println(("Invalid password. Password must have 6-12 characters and contain at least one upper case character."));
                    } else {
                        userService.login(email, password);
                        return;
                    }
                }
            }
        }
    }

    public void createUser() throws Exception {
        System.out.println("This function is only for Admins");
        while (true) {
            System.out.println("Enter your email:");
            String adminEmail = scannerUtils.inputString();
            if (!RegexUtils.isEmail(adminEmail)) {
                System.err.println(("Invalid email domain (abc@xxx.yyy or abc@xxx.yyy.zzz)."));
            } else {
                User admin = userService.getAdmin(adminEmail);
                if (admin == null) {
                    System.err.println(("The email you entered is not connected to any Admin account!"));
                } else {
                    while (true) {
                        System.out.println("Enter your password:");
                        String adminPassword = scannerUtils.inputString();
                        if (!RegexUtils.isPassword(adminPassword)) {
                            System.err.println(("Invalid password. Password must have 6-12 characters and contain at least one upper case character."));
                        } else {
                            if (!admin.getPassword().equals(adminPassword)) {
                                System.err.println(("Password incorrect!"));
                            } else {
                                System.out.println("Logged in!");
                                validateUserInfo();
                                return;
                            }
                        }
                    }

                }
            }
        }
    }

    private void validateUserInfo() throws Exception {
        while (true) {
            System.out.println("Enter the full name of the User: ");
            String fullName = scannerUtils.inputString();
            // validate full name input
            if (!RegexUtils.isFullname(fullName)) {
                System.err.println(("Full name can not contain special symbols."));
            } else {
                while (true) {
                    System.out.println("Enter the email of the User:");
                    String email = scannerUtils.inputString();
                    if (!RegexUtils.isEmail(email)) {
                        System.err.println(("Invalid email domain (abc@xxx.yyy or abc@xxx.yyy.zzz)."));
                    } else {
                        userService.createUser(email, fullName);
                        return;
                    }
                }
            }
        }
    }

    public void closeConnection() throws SQLException {
        userService.closeConnection();
    }
}
