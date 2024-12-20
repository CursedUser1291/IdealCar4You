package IdealCar4You.Views;

import IdealCar4You.Controllers.CustomerController;
import IdealCar4You.Controllers.UserController;

import javax.swing.*;

public class CarManagementUI extends JFrame {
    public static void main(String[] args) {
        CustomerController customerController = new CustomerController();
        UserController userController = new UserController();
        new CarManagementUI();
    }
}
