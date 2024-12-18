package IdealCar4You.Models;

import java.time.LocalDate;

public class Customer {
    private String lastName;
    private String firstName;
    private String street;
    private String city;
    private String postalCode;
    private String privatePhone;
    private String mobilePhone;
    private String email;
    private LocalDate birthdate;

    //Constructor
    public Customer(String lastName, String firstName, String street, String city, String postalCode, String privatePhone, String mobilePhone, String email, LocalDate birthdate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.privatePhone = privatePhone;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.birthdate = birthdate;
    }

    public Customer() {}

    //Getter and Setter
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPrivatePhone() {
        return privatePhone;
    }

    public void setPrivatePhone(String privatePhone) {
        this.privatePhone = privatePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
