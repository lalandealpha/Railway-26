package frontend;

import backend.controller.UserController;
import utils.ScannerUtils;

public class Program {
    private static UserController controller;
    private static ScannerUtils scannerUtils;

    public static void main(String[] args) throws Exception {
        controller = new UserController();
        scannerUtils = new ScannerUtils();

        while (true) {
            System.out.println("Please select the function you want to use:");
            System.out.println("(1) Get a list of all Users");
            System.out.println("(2) Get an User's information");
            System.out.println("(3) Delete an User");
            System.out.println("(4) Log in");
            System.out.println("(5) Create an User (Only for admins)");
            System.out.println("(6) Exit");
            int select = scannerUtils.inputInt("Please try again!", 1, 6);
            switch (select) {
                case 1:
                    controller.printUserList();
                    break;
                case 2:
                    controller.getUser();
                    break;
                case 3:
                    controller.deleteUser();
                    break;
                case 4:
                    controller.login();
                    break;
                case 5:
                    controller.createUser();
                    break;
                default:
                    System.out.println("Exiting the program...");
                    scannerUtils.disconnect();
                    controller.closeConnection();
                    System.gc();
                    return;
            }
            System.out.println("");
        }
    }
}
