package IdealCar4You.Persistance;

import IdealCar4You.Models.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerPersistanceService {
        private String filename = "customer.json";
        private ObjectMapper mapper;

        public CustomerPersistanceService() {
            mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
        }

        public List<Customer> readCustomers() {
            List<Customer> customers = new ArrayList<>();
            try {
                File jsonFile = new File(filename);

                if(jsonFile.exists()) {
                    Customer[] customerArray = mapper.readValue(jsonFile, Customer[].class);
                    for(Customer customer : customerArray) {
                        customers.add(customer);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return customers;
        }

        public void saveCustomers (List<Customer> employees) {
            try {
                File jsonFile = new File(filename);
                mapper.writeValue(jsonFile, employees);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
