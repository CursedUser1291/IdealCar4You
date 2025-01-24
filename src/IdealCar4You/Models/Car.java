package IdealCar4You.Models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.LocalDate;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")

public class Car extends Vehicle {
    private String bodyType;
    private boolean hasNavigation;

    public Car(String brand, String model, int engineCapacity, String fuelType, int mileage, int horsepower, LocalDate registrationDate, String color, int curbWeight, String bodyType, boolean hasNavigation) {
        super(brand, model, engineCapacity, fuelType, mileage, horsepower, registrationDate, color, curbWeight);
        this.bodyType = bodyType;
        this.hasNavigation = hasNavigation;
    }

    public Car() {
    }

    //Getter & Setter
    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public boolean isHasNavigation() {
        return hasNavigation;
    }

    public void setHasNavigation(boolean hasNavigation) {
        this.hasNavigation = hasNavigation;
    }
}
