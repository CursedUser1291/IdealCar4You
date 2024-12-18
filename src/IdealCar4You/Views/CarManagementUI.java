package IdealCar4You.Views;

import IdealCar4You.Controllers.CustomerController;

import javax.swing.*;

public class CarManagementUI extends JFrame {
    public static void main(String[] args) {
        CustomerController customerController = new CustomerController();
        new CarManagementUI();
    }
}
