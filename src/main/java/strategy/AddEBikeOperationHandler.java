package strategy;

import app.App;
import dao.VehicleDao;
import injection.Component;
import injection.Inject;
import model.EBike;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class AddEBikeOperationHandler implements OperationHandler {
    @Inject
    private VehicleDao vehicleDao;

    @Override
    public void apply() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Fill in the information about the bike");
        try {
            System.out.println("Brand:");
            String brand = reader.readLine();

            System.out.println("Max speed:");
            int maxSpeed = Integer.parseInt(reader.readLine());

            System.out.println("Weight in grams:");
            int weight = Integer.parseInt(reader.readLine());

            System.out.println("Is there a front light and a back light? (\"true\" or \"false\"):");
            boolean hasLightsAtFrontAndBack = Boolean.parseBoolean(reader.readLine());

            System.out.println("The battery capacity (in mAh):");
            int batteryCapacity = Integer.parseInt(reader.readLine());

            System.out.println("Color:");
            String color = reader.readLine();

            System.out.println("Price:");
            int price = Integer.parseInt(reader.readLine());

            vehicleDao.add(new EBike.Builder()
                    .setBrand(brand)
                    .setMaxSpeed(maxSpeed)
                    .setWeightInGrams(weight)
                    .setHasLightsAtFrontAndBack(hasLightsAtFrontAndBack)
                    .setBatteryCapacity(batteryCapacity)
                    .setColor(color)
                    .setPrice(price)
                    .build());
        } catch (Exception e) {
            throw new RuntimeException("Can't read from console!", e);
        }
        App app = App.getApp();
        app.run();
    }
}
