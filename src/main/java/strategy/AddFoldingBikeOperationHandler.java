package strategy;

import app.App;
import dao.VehicleDao;
import injection.Component;
import injection.Inject;
import model.FoldingBike;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class AddFoldingBikeOperationHandler implements OperationHandler {
    @Inject
    private VehicleDao vehicleDao;

    @Override
    public void apply() {
        System.out.println("Fill in the information about the bike");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Brand:");
            String brand = reader.readLine();

            System.out.println("The size of the wheels (in inch):");
            int size = Integer.parseInt(reader.readLine());

            System.out.println("The number of gears:");
            int numberOfGears = Integer.parseInt(reader.readLine());

            System.out.println("Weight in grams:");
            int weight = Integer.parseInt(reader.readLine());

            System.out.println("Is there a front light and a back light? (\"true\" or \"false\"):");
            boolean hasLightsAtFrontAndBack = Boolean.parseBoolean(reader.readLine());

            System.out.println("Color:");
            String color = reader.readLine();

            System.out.println("Price:");
            int price = Integer.parseInt(reader.readLine());

            vehicleDao.add(new FoldingBike.Builder()
                    .setBrand(brand)
                    .setSizeOfWheelsInInch(size)
                    .setNumberOfGears(numberOfGears)
                    .setWeightInGrams(weight)
                    .setHasLightsAtFrontAndBack(hasLightsAtFrontAndBack)
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
