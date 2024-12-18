package IdealCar4You.Models;

import java.time.LocalDate;

public class Vehicle {
    private String brand;
    private String model;
    private int engineCapacity;
    private String fuelType;
    private int mileage;
    private int horsepower;
    private LocalDate registrationDate;
    private String color;
    private int curbWeight;

    //Constructor
    public Vehicle() {}

    public Vehicle(String brand, String model, int engineCapacity, String fuelType, int mileage, int horsepower, LocalDate registrationDate, String color, int curbWeight) {
        this.brand = brand;
        this.model = model;
        this.engineCapacity = engineCapacity;
        this.fuelType = fuelType;
        this.mileage = mileage;
        this.horsepower = horsepower;
        this.registrationDate = registrationDate;
        this.color = color;
        this.curbWeight = curbWeight;
    }

    //Getter and Setter
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCurbWeight() {
        return curbWeight;
    }

    public void setCurbWeight(int curbWeight) {
        this.curbWeight = curbWeight;
    }
}
