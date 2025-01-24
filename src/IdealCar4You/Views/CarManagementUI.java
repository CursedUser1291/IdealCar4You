package IdealCar4You.Views;

import IdealCar4You.Controllers.CustomerController;
import IdealCar4You.Controllers.UserController;
import IdealCar4You.Controllers.VehicleController;
import IdealCar4You.Models.*;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CarManagementUI extends JFrame {
    //region Variables
    private JTabbedPane tabs;
    private JPanel VehicleManager;
    private JPanel vehicleLstPnl;
    private JPanel vehicleTxtPnl;
    private JLabel brandLbl;
    private JLabel modelLbl;
    private JLabel engineCapacityLbl;
    private JLabel fuelTypeLbl;
    private JLabel mileageLbl;
    private JLabel horsepowerLbl;
    private JLabel registrationDateLbl;
    private JLabel Color;
    private JLabel curbWeightLbl;
    private JPanel vehicleHeaderPnl;
    private JLabel vehicleHeaderLbl;
    private JList vehicleLst;
    private JList userLst;
    private JPanel userLstPnl;
    private JPanel UsersPnl;
    private JPanel userHeaderPnl;
    private JLabel userHeaderLbl;
    private JPanel UserDetailPnl;
    private JLabel lastnameLbl;
    private JLabel firstnameLbl;
    private JLabel streetLbl;
    private JLabel postalcodeLbl;
    private JLabel cityLbl;
    private JLabel pubPhoneLbl;
    private JLabel emailLabel;
    private JLabel dobLabel;
    private JLabel privPhoneLbl;
    private JPanel Login;
    private JTextField loginNameTbx;
    private JLabel loginEmailLbl;
    private JLabel loginPasswordLbl;
    private JLabel loginHeaderLbl;
    private JButton deleteVehicleBtn;
    private JButton newVehicleBtn;
    private JButton saveVehicleBtn;
    private JPanel vehicleBtnPnl;
    private JButton loginBtn;
    private JButton newUserBtn;
    private JButton deleteUserBtn;
    private JButton saveUserBtn;
    private JTextField brandTbx;
    private JTextField modelTbx;
    private JTextField engCapTbx;
    private JTextField fuelTypeTbx;
    private JTextField mileageTbx;
    private JTextField horsepowerTbx;
    private JTextField regDateTbx;
    private JTextField colorTbx;
    private JTextField weightTbx;
    private JTextField lastNameTbx;
    private JTextField firstNameTbx;
    private JTextField streetTbx;
    private JTextField postalTbx;
    private JTextField cityTbx;
    private JTextField pubPhoneTbx;
    private JTextField privPhoneTbx;
    private JTextField emailTbx;
    private JTextField dobTbx;
    private JPanel loginDetailsPnl;
    private JComboBox vhclTypeCbx;
    private JTextField maxLoadTbx;
    private JLabel maxLoadLbl;
    private JLabel bodyTypeLbl;
    private JCheckBox navigationCkbx;
    private JComboBox bodyTypeCbx;
    private JComboBox fuelTypeCbx;
    private JPanel vhclFilterPnl;
    private JPanel userFilterPnl;
    private JTextField firstNameFilterTbx;
    private JTextField lastNameFilterTbx;
    private JComboBox brandFilterCbx;
    private JComboBox modelFilterCbx;
    private JLabel filterHeaderLbl;
    private JLabel brandFilterLbl;
    private JLabel modelFilterLbl;
    private JLabel filterHeaderUsersLbl;
    private JLabel lastNameFilterLbl;
    private JLabel firstNameFilterLbl;
    private JPanel VehiclesPnl;
    private JPasswordField loginPasswordTbx;
    private JButton logoutBtn;
    private JPanel userBtnPnl;
    private JButton resetVhclBtn;
    private JButton resetCustomerBtn;
    private JLabel typeFilterLbl;
    private JComboBox typeFilterCbx;
    private JButton quitBtn;
    private JComboBox fuelTypeFilterCbx;
    private JButton newButton;
    private JButton saveButton;
    private JButton deleteButton;
//endregion

    private CustomerController customerController;
    private DefaultListModel<Customer> customerListModel;

    private UserController userController;

    private DefaultListModel<Vehicle> vehicleListModel;
    private VehicleController vehicleController;

    public CarManagementUI(CustomerController customerController, UserController userController, VehicleController vehicleController) {
        super("Car Management");
        this.customerController = customerController;
        this.userController = userController;
        this.vehicleController = vehicleController;

        customerListModel = new DefaultListModel<>();
        userLst.setModel(customerListModel);
        vehicleListModel = new DefaultListModel<>();
        vehicleLst.setModel(vehicleListModel);

        setContentPane(VehicleManager);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 1200);
        setVisible(true);
        setLocationRelativeTo(null);

        updateVehicleList();
        updateVehicleFilters();
        filterModelsByBrand();
        logout();
        updateCustomerList();
        checkVehicleType();
        fillFuelTypeCbx();

        //Add vehicle
        newVehicleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedVehicle = vhclTypeCbx.getSelectedItem().toString();

                int dialogResult = JOptionPane.showConfirmDialog(VehicleManager, "Are you sure you want to add this Vehicle?");
                if(dialogResult == JOptionPane.YES_OPTION) {
                    if (selectedVehicle == "Car") {
                        boolean hasNavigation;
                        if(navigationCkbx.isSelected()) {
                            hasNavigation = true;
                        } else {
                            hasNavigation = false;
                        }

                        Car car = new Car(
                                brandTbx.getText(),
                                modelTbx.getText(),
                                Integer.parseInt(engCapTbx.getText()),
                                fuelTypeCbx.getSelectedItem().toString(),
                                Integer.parseInt(mileageTbx.getText()),
                                Integer.parseInt(horsepowerTbx.getText()),
                                LocalDate.parse(
                                        regDateTbx.getText(),
                                        DateTimeFormatter.ofPattern("dd.MM.yyyy")
                                ),
                                colorTbx.getText(),
                                Integer.parseInt(weightTbx.getText()),
                                bodyTypeCbx.getSelectedItem().toString(),
                                hasNavigation
                        );
                        vehicleController.addVehicle(car);
                    } else if (selectedVehicle == "Transport") {
                        Transport transport = new Transport(
                                brandTbx.getText(),
                                modelTbx.getText(),
                                Integer.parseInt(engCapTbx.getText()),
                                fuelTypeCbx.getSelectedItem().toString(),
                                Integer.parseInt(mileageTbx.getText()),
                                Integer.parseInt(horsepowerTbx.getText()),
                                LocalDate.parse(
                                        regDateTbx.getText(),
                                        DateTimeFormatter.ofPattern("dd.MM.yyyy")
                                ),
                                colorTbx.getText(),
                                Integer.parseInt(weightTbx.getText()),
                                Integer.parseInt(maxLoadTbx.getText())
                        );
                        vehicleController.addVehicle(transport);
                    }
                }
                updateVehicleUI();
            }
        });

        vhclTypeCbx.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                checkVehicleType();
            }
        });

        //Select Vehicle
        vehicleLst.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = vehicleLst.getSelectedIndex();
                if (index != -1) {
                    Vehicle selectedVehicle = (Vehicle) vehicleLst.getSelectedValue();

                    if (selectedVehicle instanceof Car) {
                        Car car = (Car) selectedVehicle;

                        brandTbx.setText(car.getBrand());
                        modelTbx.setText(car.getModel());
                        engCapTbx.setText(String.valueOf(car.getEngineCapacity()));
                        fuelTypeCbx.setSelectedItem(car.getFuelType());
                        mileageTbx.setText(String.valueOf(car.getMileage()));
                        horsepowerTbx.setText(String.valueOf(car.getHorsepower()));
                        regDateTbx.setText(car.getRegistrationDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                        colorTbx.setText(car.getColor());
                        weightTbx.setText(String.valueOf(car.getCurbWeight()));
                        bodyTypeCbx.setSelectedItem(car.getBodyType());
                        navigationCkbx.setSelected(car.isHasNavigation());

                        checkVehicleType();
                        vhclTypeCbx.setSelectedItem("Car");
                        updateVehicleHeaderText();
                    } else if (selectedVehicle instanceof Transport) {
                        Transport transport = (Transport) selectedVehicle;
                        brandTbx.setText(transport.getBrand());
                        modelTbx.setText(transport.getModel());
                        engCapTbx.setText(String.valueOf(transport.getEngineCapacity()));
                        fuelTypeCbx.setSelectedItem(transport.getFuelType());
                        mileageTbx.setText(String.valueOf(transport.getMileage()));
                        horsepowerTbx.setText(String.valueOf(transport.getHorsepower()));
                        regDateTbx.setText(transport.getRegistrationDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                        colorTbx.setText(transport.getColor());
                        weightTbx.setText(String.valueOf(transport.getCurbWeight()));
                        maxLoadTbx.setText(String.valueOf(transport.getMaxLoadCapacity()));

                        checkVehicleType();
                        vhclTypeCbx.setSelectedItem("Transport");
                        updateVehicleHeaderText();
                    }
                }
                userRights(loggedInAs);
            }
        });

        //Delete Vehicle
        deleteVehicleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dialogResult = JOptionPane.showConfirmDialog(VehicleManager, "Are you sure you want to delete this Vehicle?");
                if (dialogResult == JOptionPane.YES_OPTION) {
                    int index = vehicleLst.getSelectedIndex();
                    if (index != -1) {
                        vehicleController.deleteVehicle(index);
                        updateVehicleUI();
                    }
                }
            }
        });

        //Update Vehicle
        saveVehicleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dialogResult = JOptionPane.showConfirmDialog(VehicleManager, "Are you sure you want to update this vehicle?");
                if (dialogResult == JOptionPane.YES_OPTION) {
                    int index = vehicleLst.getSelectedIndex();
                    if (index != -1) {
                        if (vhclTypeCbx.getSelectedItem().toString().equals("Car")) {
                            Car car = new Car(
                                    brandTbx.getText(),
                                    modelTbx.getText(),
                                    Integer.parseInt(engCapTbx.getText()),
                                    String.valueOf(fuelTypeCbx.getSelectedItem()),
                                    Integer.parseInt(mileageTbx.getText()),
                                    Integer.parseInt(horsepowerTbx.getText()),
                                    LocalDate.parse(
                                            regDateTbx.getText(),
                                            DateTimeFormatter.ofPattern("dd.MM.yyyy")
                                    ),
                                    colorTbx.getText(),
                                    Integer.parseInt(weightTbx.getText()),
                                    String.valueOf(bodyTypeCbx.getSelectedItem()),
                                    navigationCkbx.isSelected()
                            );
                            vehicleController.updateVehicle(index, car);
                        } else if (vhclTypeCbx.getSelectedItem().toString().equals("Transport")) {
                            Transport transport = new Transport(
                                    brandTbx.getText(),
                                    modelTbx.getText(),
                                    Integer.parseInt(engCapTbx.getText()),
                                    String.valueOf(fuelTypeCbx.getSelectedItem()),
                                    Integer.parseInt(mileageTbx.getText()),
                                    Integer.parseInt(horsepowerTbx.getText()),
                                    LocalDate.parse(
                                            regDateTbx.getText(),
                                            DateTimeFormatter.ofPattern("dd.MM.yyyy")
                                    ),
                                    colorTbx.getText(),
                                    Integer.parseInt(weightTbx.getText()),
                                    Integer.parseInt(maxLoadTbx.getText())
                            );
                            vehicleController.updateVehicle(index, transport);
                        }
                        updateVehicleUI();
                        updateVehicleHeaderText();
                        vehicleLst.setSelectedIndex(index);
                        vehicleLst.ensureIndexIsVisible(index);
                    }
                }
            }
        });

        resetVhclBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Component component : vehicleTxtPnl.getComponents()) {
                    if (component instanceof JTextField) {
                        ((JTextField) component).setText("");
                    }
                }
                navigationCkbx.setSelected(false);
                vehicleLst.clearSelection();
                vehicleHeaderLbl.setText("No Vehicle Selected.");
            }
        });

        //Select Customer
        userLst.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = userLst.getSelectedIndex();
                if (index != -1) {
                    Customer selectedcustomer = (Customer) userLst.getSelectedValue();

                    Customer customer = (Customer) selectedcustomer;
                    lastNameTbx.setText(selectedcustomer.getLastName());
                    firstNameTbx.setText(selectedcustomer.getFirstName());
                    streetTbx.setText(selectedcustomer.getStreet());
                    postalTbx.setText(selectedcustomer.getPostalCode());
                    cityTbx.setText(selectedcustomer.getCity());
                    pubPhoneTbx.setText(selectedcustomer.getPrivatePhone());
                    privPhoneTbx.setText(selectedcustomer.getMobilePhone());
                    emailTbx.setText(selectedcustomer.getEmail());
                    dobTbx.setText(selectedcustomer.getBirthdate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));

                    updateCustomerHeaderText();
                }
            }
        });

        //Add new Customer
        newUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dialogResult = JOptionPane.showConfirmDialog(VehicleManager, "Are you sure you want to add this Customer?");
                if(dialogResult == JOptionPane.YES_OPTION) {
                    Customer customer = new Customer(
                            lastNameTbx.getText(),
                            firstNameTbx.getText(),
                            streetTbx.getText(),
                            postalTbx.getText(),
                            cityTbx.getText(),
                            pubPhoneTbx.getText(),
                            privPhoneTbx.getText(),
                            emailTbx.getText(),
                            LocalDate.parse(
                                    dobTbx.getText(),
                                    DateTimeFormatter.ofPattern("dd.MM.yyyy")
                            )
                    );
                    customerController.addCustomer(customer);
                    updateCustomerList();
                }
            }
        });

        //Update Customer
        saveUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dialogResult = JOptionPane.showConfirmDialog(VehicleManager, "Are you sure you want to update this Customer?");
                if(dialogResult == JOptionPane.YES_OPTION) {
                    int index = userLst.getSelectedIndex();
                    if (index != -1) {
                        Customer customer = new Customer(
                                lastNameTbx.getText(),
                                firstNameTbx.getText(),
                                streetTbx.getText(),
                                postalTbx.getText(),
                                cityTbx.getText(),
                                pubPhoneTbx.getText(),
                                privPhoneTbx.getText(),
                                emailTbx.getText(),
                                LocalDate.parse(
                                        dobTbx.getText(),
                                        DateTimeFormatter.ofPattern("dd.MM.yyyy")
                                )
                        );
                        customerController.updateCustomer(index, customer);
                        updateCustomerList();
                        updateCustomerHeaderText();
                        userLst.setSelectedIndex(index);
                        userLst.ensureIndexIsVisible(index);
                    }
                }
            }
        });

        //Delete Customer
        deleteUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dialogResult = JOptionPane.showConfirmDialog(VehicleManager, "Are you sure you want to delete this Customer?");
                if (dialogResult == JOptionPane.YES_OPTION) {
                    int index = userLst.getSelectedIndex();
                    if (index != -1) {
                        customerController.deleteCustomer(index);
                        updateCustomerList();
                    }
                }
            }
        });

        resetCustomerBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Component component : UserDetailPnl.getComponents()) {
                    if (component instanceof JTextField) {
                        ((JTextField) component).setText("");
                    }
                }
                userLst.clearSelection();
                userHeaderLbl.setText("No Customers Selected.");
            }
        });

        //Customer filter after Lastname
        lastNameFilterTbx.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {}
            @Override
            public void removeUpdate(DocumentEvent e) {
                searchCustomers();
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                searchCustomers();
            }
        });

        //Customer filter after Firstname
        firstNameFilterTbx.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {}
            @Override
            public void removeUpdate(DocumentEvent e) {
                searchCustomers();
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                searchCustomers();
            }
        });

        //Filter after Brand
        brandFilterCbx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterModelsByBrand();
                filterVehicles();
            }
        });

        //Filter after Model
        modelFilterCbx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterVehicles();
            }
        });

        //Filter after Type
        typeFilterCbx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterVehicles();
            }
        });

        //Login
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = new String(loginPasswordTbx.getPassword());
                String role = login(loginNameTbx.getText(), password);

                if (role != null) {
                    JOptionPane.showMessageDialog(null, "Logged in as " + role, "Login Successful", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Login failed. Please check your credentials.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //Logout
        logoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logout();
            }
        });

        //Quit
        quitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dialogResult = JOptionPane.showConfirmDialog(VehicleManager, "Are you sure you want to Quit?");
                if (dialogResult == JOptionPane.YES_OPTION) {
                    System.exit(10);
                }
            }
        });
    }

    public void updateVehicleUI() {
        updateVehicleFilters();
        updateVehicleList();
    }

    public void updateCustomerHeaderText() {
        Customer selectedCustomer = (Customer) userLst.getSelectedValue();

        userHeaderLbl.setText(selectedCustomer.toString());
    }

    public void updateVehicleHeaderText() {
        Vehicle selectedVehicle = (Vehicle) vehicleLst.getSelectedValue();

        vehicleHeaderLbl.setText(selectedVehicle.toString());
    }

    public void updateCustomerList() {
        customerListModel.clear();

        for (Customer customer : customerController.readAllCustomers()) {
            customerListModel.addElement(customer);
        }
        userLst.setModel(customerListModel);
    }

    public void updateVehicleList() {
        vehicleListModel.clear();
        System.out.println("Updating vehicle list...");

        for (Vehicle vehicle : vehicleController.readAllVehicles()) {
            vehicleListModel.addElement(vehicle);
        }

        vehicleLst.setModel(vehicleListModel);

        System.out.println("Vehicle list updated successfully.");
        System.out.println("Number of vehicles in the list: " + vehicleListModel.size());

    }

    public void checkVehicleType() {
        String selectedVehicle = vhclTypeCbx.getSelectedItem().toString();
        if (selectedVehicle == "Transport") {
            bodyTypeLbl.setVisible(false);
            bodyTypeCbx.setVisible(false);
            navigationCkbx.setVisible(false);
            maxLoadLbl.setVisible(true);
            maxLoadTbx.setVisible(true);
        } else if (selectedVehicle == "Car") {
            bodyTypeLbl.setVisible(true);
            bodyTypeCbx.setVisible(true);
            navigationCkbx.setVisible(true);
            maxLoadLbl.setVisible(false);
            maxLoadTbx.setVisible(false);
        }
    }

    public void updateVehicleFilters() {
        List<Vehicle> vehicles = vehicleController.readAllVehicles();

        for (Vehicle vehicle : vehicles) {
            if (((DefaultComboBoxModel) brandFilterCbx.getModel()).getIndexOf(vehicle.getBrand()) == -1) {
                brandFilterCbx.addItem(vehicle.getBrand());
            }
        }

        brandFilterCbx.addActionListener(e -> filterModelsByBrand());
    }

    //Filters Models and Type by brand
    private void filterModelsByBrand() {
        String selectedBrand = (String) brandFilterCbx.getSelectedItem();
        modelFilterCbx.removeAllItems();
        typeFilterCbx.removeAllItems();

        if (selectedBrand.equals("None")) {
            for (Vehicle vehicle : vehicleController.readAllVehicles()) {
                if (((DefaultComboBoxModel) modelFilterCbx.getModel()).getIndexOf(vehicle.getModel()) == -1) {
                    modelFilterCbx.addItem(vehicle.getModel());
                }
            }
        } else {
            for (Vehicle vehicle : vehicleController.readAllVehicles()) {
                if (selectedBrand.equals(vehicle.getBrand()) &&
                        ((DefaultComboBoxModel) modelFilterCbx.getModel()).getIndexOf(vehicle.getModel()) == -1) {
                    modelFilterCbx.addItem(vehicle.getModel());
                }
            }
        }

        if (selectedBrand.equals("None")) {
            for (Vehicle vehicle : vehicleController.readAllVehicles()) {
                if (((DefaultComboBoxModel) typeFilterCbx.getModel()).getIndexOf(vehicle.getType()) == -1) {
                    typeFilterCbx.addItem(vehicle.getType());
                }
            }
        } else {
            for (Vehicle vehicle : vehicleController.readAllVehicles()) {
                if (selectedBrand.equals(vehicle.getBrand()) &&
                        ((DefaultComboBoxModel) typeFilterCbx.getModel()).getIndexOf(vehicle.getType()) == -1) {
                    typeFilterCbx.addItem(vehicle.getType());
                }
            }
        }

        modelFilterCbx.insertItemAt("None", 0);
        modelFilterCbx.setSelectedIndex(0);

        typeFilterCbx.insertItemAt("None", 0);
        typeFilterCbx.setSelectedIndex(0);
    }

    public void fillFuelTypeCbx() {
        List<Vehicle> vehicles = vehicleController.readAllVehicles();
        fuelTypeCbx.removeAllItems();

        for (Vehicle vehicle : vehicles) {
            if (((DefaultComboBoxModel) fuelTypeCbx.getModel()).getIndexOf(vehicle.getFuelType()) == -1) {
                fuelTypeCbx.addItem(vehicle.getFuelType());
            }
        }
    }

    public void searchCustomers() {
        String lastName = lastNameFilterTbx.getText().trim().toLowerCase();
        String firstName = firstNameFilterTbx.getText().trim().toLowerCase();

        customerListModel.clear();
        List<Customer> customers = customerController.readAllCustomers();

        for (Customer customer : customers) {
            boolean matchesLastName = lastName.isEmpty() || customer.getLastName().toLowerCase().contains(lastName);
            boolean matchesFirstName = firstName.isEmpty() || customer.getFirstName().toLowerCase().contains(firstName);

            if (matchesLastName && matchesFirstName) {
                customerListModel.addElement(customer);
            }
        }
        userLst.repaint();
    }

    public void filterVehicles() {
        String selectedBrand = (String) brandFilterCbx.getSelectedItem();
        String selectedModel = (String) modelFilterCbx.getSelectedItem();
        if (selectedModel == null) {
            selectedModel = "None";
        }
        String selectedType = (String) typeFilterCbx.getSelectedItem();
        if (selectedType == null) {
            selectedType = "None";
        }

        vehicleListModel.clear();

        List<Vehicle> vehicles = vehicleController.readAllVehicles();

        for (Vehicle vehicle : vehicles) {
            boolean matches = true;

            if (!selectedBrand.equals("None") && !selectedBrand.equals(vehicle.getBrand())) {
                matches = false;
            }

            if (!selectedModel.equals("None") && !selectedModel.equals(vehicle.getModel())) {
                matches = false;
            }

            if (!selectedType.equals("None") && !selectedType.equals(vehicle.getType())) {
                matches = false;
            }

            if (matches) {;
                vehicleListModel.addElement(vehicle);
            }
        }
    }


    boolean loggedIn = false;
    int tabIndexVehicle = tabs.indexOfTab("Vehicles");
    int tabIndexUser = tabs.indexOfTab("Users");
    int tabIndexlogin = tabs.indexOfTab("Log in");
    String loggedInAs = "";

    public void logout() {
        tabs.setSelectedIndex(tabIndexlogin);
        logoutBtn.setVisible(false);
        if(tabIndexVehicle != -1 && tabIndexUser != -1) {
            tabs.setEnabledAt(tabIndexVehicle, false);
            tabs.setEnabledAt(tabIndexUser, false);
        }
        loginNameTbx.setText("");
        loginPasswordTbx.setText("");
        loginBtn.setVisible(true);
    }

    public String login(String email, String password) {
        List<User> users = userController.readUsers();
        for (User user : users) {
            if (user.getName().equals(email) && user.getPassword().equals(password)) {
                loggedIn = true;
                loggedInAs = user.getRole();
                String name = user.getName();

                tabs.setEnabledAt(tabIndexVehicle, true);
                tabs.setEnabledAt(tabIndexUser, true);

                logoutBtn.setVisible(true);
                loginBtn.setVisible(false);

                System.out.println("Login successful as " + name);
                userRights(loggedInAs);

                tabs.setSelectedIndex(tabIndexVehicle);

                return name;
            }
        }
        System.out.println("Login failed: Invalid email or password.");
        return null;
    }

    public void userRights(String role) {
        if (role.equals("customerService")) {
            for (Component component : vehicleTxtPnl.getComponents()) {
                if (component instanceof JTextField){
                    ((JTextField) component).setEditable(false);
                }
                if (component instanceof JComboBox){
                    ((JComboBox) component).setEnabled(false);
                }
                if (component instanceof JCheckBox) {
                    ((JCheckBox) component).setEnabled(false);
                }
            }

            resetVhclBtn.setVisible(false);

            for (Component component : vehicleBtnPnl.getComponents()) {
                if (component instanceof JButton) {
                    ((JButton) component).setVisible(false);
                }
            }
        } else if ("admin".equals(role)){
            for (Component component : vehicleTxtPnl.getComponents()) {
                if (component instanceof JTextField){
                    ((JTextField) component).setEditable(true);
                }
                if (component instanceof JComboBox){
                    ((JComboBox) component).setEnabled(true);
                }
                if (component instanceof JCheckBox) {
                    ((JCheckBox) component).setEnabled(true);
                }
            }

            resetVhclBtn.setVisible(true);

            for (Component component : vehicleBtnPnl.getComponents()) {
                if (component instanceof JButton) {
                    ((JButton) component).setVisible(true);
                }
            }
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        CustomerController customerController = new CustomerController();
        UserController userController = new UserController();
        VehicleController vehicleController = new VehicleController();
        new CarManagementUI(customerController,userController,vehicleController);
    }

    public void createUIComponents() {

    }
}
