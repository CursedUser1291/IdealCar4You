package IdealCar4You.Persistance;

import IdealCar4You.Models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserPersistenceService {
    private String filename = "users.json";
    private ObjectMapper mapper;

    public UserPersistenceService() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    public List<User> readUsers() {
        List<User> users = new ArrayList<>();
        try {
            File jsonFile = new File(filename);

            if(jsonFile.exists()) {
                User[] userArray = mapper.readValue(jsonFile, User[].class);
                for(User user : userArray) {
                    users.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void saveUsers (List<User> users) {
        try {
            File jsonFile = new File(filename);
            mapper.writeValue(jsonFile, users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SeedUsers() {
        File jsonFile = new File(filename);
        try {
            if (!jsonFile.exists() || jsonFile.length() == 0) {
                List<User> defaultUsers = List.of(
                        new User("Admin", "admin1234","admin"),
                        new User("CustomerService","service1234", "customerService")
                );

                saveUsers(defaultUsers);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
