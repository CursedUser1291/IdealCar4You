package IdealCar4You.Controllers;


import IdealCar4You.Models.UserModel;
import IdealCar4You.Models.User;
import java.util.List;

public class UserController {
    private UserModel userModel;

    public UserController() {
        userModel = new UserModel();
    }

    public void addUser(User user) {
        userModel.addUser(user);
    }

    public void updateUser(int index, User updatedUser) {
        userModel.updateUser(index, updatedUser);
    }

    public User readUser(int index) {
        return userModel.readUser(index);
    }

    public List<User> readUsers() {
        return userModel.readAllUsers();
    }

    public void deleteUser(int index) {
        userModel.deleteUser(index);
    }
}
