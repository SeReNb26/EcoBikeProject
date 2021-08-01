package dao;

import db.Storage;
import injection.Component;
import model.Vehicle;
import java.util.List;

@Component
public class VehicleDaoImpl implements VehicleDao {
    @Override
    public void add(Vehicle vehicle) {
        Storage.vehicles.add(vehicle);
    }

    @Override
    public List<Vehicle> getAll() {
        return Storage.vehicles;
    }
}
