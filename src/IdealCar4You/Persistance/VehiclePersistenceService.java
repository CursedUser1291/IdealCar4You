package IdealCar4You.Persistance;
import IdealCar4You.Models.Transport;
import IdealCar4You.Models.Car;
import IdealCar4You.Models.Vehicle;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class VehiclePersistenceService {
    private String filename = "vehicles.json";
    private ObjectMapper mapper;

    public VehiclePersistenceService() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.registerSubtypes(Car.class, Transport.class);
    }

    public void saveVehicles(List<Vehicle> vehicles) {
        try {
            File jsonFile = new File(filename);
            for (Vehicle vehicle : vehicles) {
                if (vehicle instanceof Car) {
                    ((Car) vehicle).setType("Car");
                    String jsonString = mapper.writeValueAsString(vehicles);
                    System.out.println("JSON Output: " + jsonString);
                } else if (vehicle instanceof Transport) {
                    ((Transport) vehicle).setType("Transport");
                    String jsonString = mapper.writeValueAsString(vehicles);
                    System.out.println("JSON Output: " + jsonString);
                }
            }
            mapper.writeValue(jsonFile, vehicles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<Vehicle> readVehicles() {
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        try {
            File jsonFile = new File(filename);
            if (jsonFile.exists()) {
                Vehicle[] vehicleArray = mapper.readValue(jsonFile, Vehicle[].class);
                for (Vehicle vehicle : vehicleArray) {
                    if (vehicle instanceof Car) {
                        ((Car) vehicle).setType("Car");
                    } else if (vehicle instanceof Transport) {
                        ((Transport) vehicle).setType("Transport");
                    }

                    vehicles.add(vehicle);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vehicles;
    }
}
