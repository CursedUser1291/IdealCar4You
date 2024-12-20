package IdealCar4You.Persistance;
import IdealCar4You.Models.Vehicle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VehiclePersistenceService {
    private String filename = "vehicles.json";
    private ObjectMapper mapper;

    public VehiclePersistenceService() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    public void saveVehicles(List<Vehicle> vehicles) {
        try {
            File jsonFile = new File(filename);
            mapper.writeValue(jsonFile, vehicles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Vehicle> readVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        try {
            File jsonFile = new File(filename);

            if (jsonFile.exists()) {
                Vehicle[] vehicleArray = mapper.readValue(jsonFile, Vehicle[].class);
                for (Vehicle vehicle : vehicleArray) {
                    vehicles.add(vehicle);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vehicles;
    }
}
