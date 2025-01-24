package test;

import static org.junit.jupiter.api.Assertions.*;
import IdealCar4You.Controllers.*;
import IdealCar4You.Models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

class CarManagementUITest {
    private VehicleController vehicleController;
    private CustomerController customerController;

    @BeforeEach
    void setUp() {
        vehicleController = new VehicleController();
        customerController = new CustomerController();
    }

    @Test
    void testAddVehicle() {
        Car car = new Car();
        vehicleController.addVehicle(car);
        assertTrue(vehicleController.readAllVehicles().contains(car),"The car was not added correctly.");
        vehicleController.deleteVehicle(vehicleController.readAllVehicles().indexOf(car));

        Transport transport = new Transport();
        vehicleController.addVehicle(transport);
        assertTrue(vehicleController.readAllVehicles().contains(transport),"The transport was not added correctly.");
        vehicleController.deleteVehicle(vehicleController.readAllVehicles().indexOf(transport));
    }

    @Test
    void testRemoveVehicle() {
        Car car = new Car();
        vehicleController.addVehicle(car);
        int initialSize = vehicleController.readAllVehicles().size();

        vehicleController.deleteVehicle(vehicleController.readAllVehicles().indexOf(car));

        assertFalse(vehicleController.readAllVehicles().contains(car),"The car is still in the list and has not been deleted.");
    }

    @Test
    void testUpdateCustomer() {
        Customer customerOld = new Customer("Meier", "Hans", "Bahnhofstrasse 5", "8000", "Zürich", "123456", "789456", "hans.meier@example.com", LocalDate.of(1990, 5, 15));
        Customer customerNew = new Customer("Müller", "Peter", "Hauptstrasse 10", "8000", "Zürich", "987654", "321456", "peter.mueller@example.com", LocalDate.of(1985, 8, 20));

        customerController.addCustomer(customerOld);

        int index = customerController.readAllCustomers().indexOf(customerOld);

        assertNotEquals(-1, index, "The old customer does not exist in the list.");

        customerController.updateCustomer(index, customerNew);

        assertFalse(customerController.readAllCustomers().contains(customerOld), "The old customer is still in the list and was not updated.");
        assertTrue(customerController.readAllCustomers().contains(customerNew), "The new customer was not updated correctly.");

        customerController.deleteCustomer(index);
    }


    @Test void testFilterCustomerAfterLastname() {
        Customer customer1 = new Customer("Meier", "Hans", "Bahnhofstrasse 5", "8000", "Zürich", "123456", "789456", "hans.meier@example.com", LocalDate.of(1990, 5, 15));
        Customer customer2 = new Customer("Müller", "Peter", "Hauptstrasse 10", "8000", "Zürich", "987654", "321456", "peter.mueller@example.com", LocalDate.of(1985, 8, 20));
        customerController.addCustomer(customer1);
        customerController.addCustomer(customer2);

        List<Customer> filtered = customerController.readAllCustomers().stream()
                .filter(c -> c.getLastName().toLowerCase().contains("meier"))
                .toList();

        assertEquals(1, filtered.size());
        assertEquals("Meier", filtered.get(0).getLastName());

        customerController.deleteCustomer(customerController.readAllCustomers().indexOf(customer1));
        customerController.deleteCustomer(customerController.readAllCustomers().indexOf(customer2));
    }
}

