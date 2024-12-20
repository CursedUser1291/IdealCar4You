package IdealCar4You.Controllers;

import java.util.List;
import IdealCar4You.Models.VehicleModel;
import IdealCar4You.Models.Vehicle;

public class VehicleController {
    private VehicleModel vehicleModel;

    public VehicleController() {
        vehicleModel = new VehicleModel();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleModel.addVehicle(vehicle);
    }

    public void updateVehicle(int index, Vehicle updatedVehicle) {
        vehicleModel.updateVehicle(index, updatedVehicle);
    }

    public void deleteVehicle(int index) {
        vehicleModel.deleteVehicle(index);
    }

    public void saveVehicles() {
        vehicleModel.saveVehicles();
    }

    public List<Vehicle> readAllVehicles() {
        return vehicleModel.readAllVehicles();
    }

    public Vehicle getVehicle(int index) {
        return vehicleModel.readVehicle(index);
    }
}
