package IdealCar4You.Models;

import IdealCar4You.Persistance.VehiclePersistenceService;
import java.util.ArrayList;
import java.util.List;

public class VehicleModel {
    private List<Vehicle> vehicles;

    private VehiclePersistenceService persistenceService;

    public VehicleModel() {
        vehicles = new ArrayList<>();
        persistenceService = new VehiclePersistenceService();
        loadVehicles();
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void saveVehicles() {
        persistenceService.saveVehicles(vehicles);
    }

    public void updateVehicle(int index, Vehicle updatedVehicle) {
        vehicles.set(index, updatedVehicle);
        saveVehicles();
    }

    public Vehicle readVehicle(int index) {
        return vehicles.get(index);
    }

    public List<Vehicle> readAllVehicles() {
        return vehicles;
    }

    public void loadVehicles() {
        vehicles = persistenceService.readVehicles();
    }

    public void deleteVehicle(int index) {
        vehicles.remove(index);
        saveVehicles();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        saveVehicles();
    }
}
