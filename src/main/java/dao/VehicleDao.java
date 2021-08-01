package dao;

import model.Vehicle;
import java.util.List;

public interface VehicleDao {
    void add(Vehicle vehicle);

    List<Vehicle> getAll();
}
