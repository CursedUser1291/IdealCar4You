package IdealCar4You.Models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.LocalDate;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
public class Transport extends Vehicle {
    private int maxLoadCapacity;

    public Transport(String brand, String model, int engineCapacity, String fuelType, int mileage, int horsepower, LocalDate registrationDate, String color, int curbWeight, int maxLoadCapacity) {
        super(brand, model, engineCapacity, fuelType, mileage, horsepower, registrationDate, color, curbWeight);
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public Transport() {
    }

    public int getMaxLoadCapacity() {
        return maxLoadCapacity;
    }

    public void setMaxLoadCapacity(int maxLoadCapacity) {
        this.maxLoadCapacity = maxLoadCapacity;
    }
}
