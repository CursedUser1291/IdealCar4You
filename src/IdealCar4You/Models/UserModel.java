package IdealCar4You.Models;

import IdealCar4You.Persistance.UserPersistenceService;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private List<User> users;
    private UserPersistenceService persistanceService;

    public UserModel() {
        users = new ArrayList<User>();
        persistanceService = new UserPersistenceService();
        seedUsers();
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
        saveUsers();
    }

    public void updateUser(int index, User updatedUser) {
        users.set(index, updatedUser);
        saveUsers();
    }

    public void deleteUser(int index) {
        users.remove(index);
        saveUsers();
    }

    public User readUser(int index) {
        return users.get(index);
    }

    public List<User> readAllUsers() {
        return users;
    }

    public void saveUsers() {
        persistanceService.saveUsers(users);
    }

    public void seedUsers() {
        persistanceService.SeedUsers();
    }
}
