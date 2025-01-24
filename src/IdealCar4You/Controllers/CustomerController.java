package IdealCar4You.Controllers;

import IdealCar4You.Models.Customer;
import IdealCar4You.Models.CustomerModel;
import IdealCar4You.Persistance.CustomerPersistenceService;

import java.util.List;

public class CustomerController {
    private CustomerModel customerModel;

    public CustomerController() {
        customerModel = new CustomerModel();
    }

    public void addCustomer(Customer customer) {
        customerModel.addCustomer(customer);
    }

    public void updateCustomer(int index, Customer updatedCustomer) {
        customerModel.updateCustomer(index, updatedCustomer);
    }
    public Customer readCustomer(int index) {
        return customerModel.readCustomer(index);
    }

    public List<Customer> readAllCustomers() {
        return customerModel.readAllCustomers();
    }

    public void deleteCustomer(int index) {
        customerModel.deleteCustomers(index);
    }
}
