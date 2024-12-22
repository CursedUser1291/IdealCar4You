package IdealCar4You.Views;

import IdealCar4You.Controllers.CustomerController;
import IdealCar4You.Controllers.UserController;

import javax.swing.*;

public class CarManagementUI extends JFrame {
    private JTabbedPane tabs;
    private JPanel VehicleManager;
    private JPanel vehicleLstPnl;
    private JPanel vehicleTxtPnl;
    private JLabel brandLbl;
    private JLabel modelLbl;
    private JTextField brandTxt;
    private JLabel engineCapacityLbl;
    private JLabel fuelTypeLbl;
    private JLabel mileageLbl;
    private JLabel horsepowerLbl;
    private JLabel registrationDateLbl;
    private JLabel Color;
    private JLabel curbWeightLbl;
    private JTextField engineCapacityTxt;
    private JTextField fuelTypeTxt;
    private JTextField mileageTxt;
    private JTextField horsepowerTxt;
    private JTextField regDateTxt;
    private JTextField colorTxt;
    private JTextField modelTxt;
    private JPanel vehicleHeaderPnl;
    private JTextField weightTxt;
    private JLabel vehicleHeaderLbl;
    private JList vehicleLst;
    private JList userLst;
    private JPanel userLstPnl;
    private JPanel Users;
    private JPanel userHeaderPnl;
    private JLabel userHeaderLbl;
    private JPanel UserDetailPnl;
    private JLabel lastnameLbl;
    private JLabel firstnameLbl;
    private JTextField lastnameTxt;
    private JLabel streetLbl;
    private JLabel postalcodeLbl;
    private JLabel cityLbl;
    private JLabel pubPhoneLbl;
    private JLabel emailLabel;
    private JLabel dobLabel;
    private JLabel privPhoneLbl;
    private JTextField streetTxt;
    private JTextField postalcodeTxt;
    private JTextField firstnameTxt;
    private JTextField cityTxt;
    private JTextField pubPhoneTxt;
    private JTextField emailTextField;
    private JTextField dobTextField;
    private JTextField privPhoneTxt;
    private JButton newButton;
    private JButton saveButton;
    private JButton deleteButton;

    public static void main(String[] args) {
        CustomerController customerController = new CustomerController();
        UserController userController = new UserController();
        new CarManagementUI();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
