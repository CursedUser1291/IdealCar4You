package IdealCar4You.Controllers;

import IdealCar4You.Models.VehicleModel;
import IdealCar4You.Models.Vehicle;
import java.util.List;

public class VehicleController {
    private VehicleModel vehicleModel;

    public VehicleController() {
        this.vehicleModel = new VehicleModel();
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

    public List<Vehicle> readAllVehicles() {
        return vehicleModel.readAllVehicles();
    }

    public Vehicle getVehicle(int index) {
        return vehicleModel.readVehicle(index);
    }
}
