package com.vti.frontend;

import com.vti.backend.controller.ProjectController;
import com.vti.backend.controller.UserController;
import com.vti.utils.ScannerUtils;

public class Program {
    private static UserController usercontroller;
    private static ProjectController projectController;
    private static ScannerUtils scannerUtils;

    public static void main(String[] args) throws Exception {
        usercontroller = new UserController();
        projectController = new ProjectController();
        scannerUtils = new ScannerUtils();

        while (true) {
            System.out.println("Please select the function you want to use:");
            System.out.println("(1) Get a list of all team members of a project:");
            System.out.println("(2) Log in");
            System.out.println("(3) Create an User (Only for admins)");
            System.out.println("(4) Exit");
            int selection = scannerUtils.inputInt("Please try again!", 1, 4);
            switch (selection) {
                case 1:
                    projectController.getProject();
                    break;
                case 2:
                    usercontroller.login();
                    break;
                case 3:
                    usercontroller.createUser();
                    break;
                default:
                    System.out.println("Exiting the program...");
                    scannerUtils.disconnect();
                    usercontroller.closeConnection();
                    projectController.closeConnection();
                    System.gc();
                    return;
            }
            System.out.println("");
        }
    }
}
