package IdealCar4You.Models;

import IdealCar4You.Persistance.CustomerPersistenceService;

import java.util.ArrayList;
import java.util.List;

public class CustomerModel {
    private List<Customer> customers;
    private CustomerPersistenceService persistance;

    public CustomerModel() {
        customers = new ArrayList<>();
        persistance = new CustomerPersistenceService();
        loadCustomers();
    }

    //Getter and Setter
    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    //Methods
    public Customer readCustomer(int index) {
        return customers.get(index);
    }

    public List<Customer> readAllCustomers() {
        return customers;
    }

    public void saveCustomers() {
        persistance.saveCustomers(customers);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        saveCustomers();
    }

    public void updateCustomer(int index, Customer updatedCustomer) {
        customers.set(index, updatedCustomer);
        saveCustomers();
    }

    public void deleteCustomers(int index) {
        customers.remove(index);
        saveCustomers();
    }

    public void loadCustomers() {
        customers = persistance.readCustomers();
    }
}
