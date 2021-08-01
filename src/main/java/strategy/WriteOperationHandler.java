package strategy;

import app.App;
import dao.VehicleDao;
import injection.Component;
import injection.Inject;
import model.EBike;
import model.FoldingBike;
import model.SpeedElecBike;
import model.Vehicle;
import service.FileWriterService;
import java.util.List;

@Component
public class WriteOperationHandler implements OperationHandler {
    private static final String path = "src/main/resources/ecobike.txt";
    @Inject
    VehicleDao vehicleDao;
    @Inject
    FileWriterService writerService;

    @Override
    public void apply() {
        List<Vehicle> list = vehicleDao.getAll();
        for (Vehicle vehicle : list) {
            if (vehicle.getClass().getName().equals(FoldingBike.class.getName())) {
                writerService.write(System.lineSeparator() + "FOLDING BIKE "
                        + vehicle.getBrand() + "; "
                        + ((FoldingBike) vehicle).getSizeOfWheelsInInch() + "; "
                        + ((FoldingBike) vehicle).getNumberOfGears() + "; "
                        + vehicle.getWeightInGrams() + "; "
                        + vehicle.getIsHasLightsAtFrontAndBack() + "; "
                        + vehicle.getColor() + "; "
                        + vehicle.getPrice(), path);
            } else if (vehicle.getClass().getName().equals(SpeedElecBike.class.getName())) {
                writerService.write(System.lineSeparator() + "SPEEDELEC "
                        + vehicle.getBrand() + "; "
                        + ((SpeedElecBike) vehicle).getMaxSpeed() + "; "
                        + vehicle.getWeightInGrams() + "; "
                        + vehicle.getIsHasLightsAtFrontAndBack() + "; "
                        + ((SpeedElecBike) vehicle).getBatteryCapacity() + "; "
                        + vehicle.getColor() + "; "
                        + vehicle.getPrice(), path);
            } else {
                writerService.write(System.lineSeparator() + "E-BIKE "
                        + vehicle.getBrand() + "; "
                        + ((EBike) vehicle).getMaxSpeed() + "; "
                        + vehicle.getWeightInGrams() + "; "
                        + vehicle.getIsHasLightsAtFrontAndBack() + "; "
                        + ((EBike) vehicle).getBatteryCapacity() + "; "
                        + vehicle.getColor() + "; "
                        + vehicle.getPrice(), path);
            }
        }
        App app = App.getApp();
        app.run();
    }
}
