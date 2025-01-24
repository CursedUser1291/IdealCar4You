package IdealCar4You.Models;

public class User {
    private String name;
    private String password;
    private String role;

    //Constructor
    public User(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public User() {}

    //Getter
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
