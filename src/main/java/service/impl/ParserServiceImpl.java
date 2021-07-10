package service.impl;

import injection.Component;
import model.EBike;
import model.FoldingBike;
import model.SpeedElecBike;
import model.Vehicle;
import service.ParserService;

@Component
public class ParserServiceImpl implements ParserService {
    @Override
    public Vehicle parse(String line) {
        String[] splited = line.split("; ");
        Vehicle vehicle = null;
        if (splited[0].contains("SPEEDELEC")) {
            vehicle = new SpeedElecBike.Builder()
                    .setBrand(splited[0].substring(splited[0].indexOf(" ") + 1))
                    .setMaxSpeed(Integer.parseInt(splited[1]))
                    .setWeightInGrams(Integer.parseInt(splited[2]))
                    .setHasLightsAtFrontAndBack(Boolean.parseBoolean(splited[3]))
                    .setBatteryCapacity(Integer.parseInt(splited[4]))
                    .setColor(splited[5])
                    .setPrice(Integer.parseInt(splited[6]))
                    .build();
        } else if (splited[0].contains("FOLDING BIKE")) {
            vehicle = new FoldingBike.Builder()
                    .setBrand(splited[0].substring(splited[0].indexOf("E") + 2))
                    .setSizeOfWheelsInInch(Integer.parseInt(splited[1]))
                    .setNumberOfGears(Integer.parseInt(splited[2]))
                    .setWeightInGrams(Integer.parseInt(splited[3]))
                    .setHasLightsAtFrontAndBack(Boolean.parseBoolean(splited[4]))
                    .setColor(splited[5])
                    .setPrice(Integer.parseInt(splited[6]))
                    .build();
        } else {
            vehicle = new EBike.Builder()
                    .setBrand(splited[0].substring(splited[0].indexOf(" ") + 1))
                    .setMaxSpeed(Integer.parseInt(splited[1]))
                    .setWeightInGrams(Integer.parseInt(splited[2]))
                    .setHasLightsAtFrontAndBack(Boolean.parseBoolean(splited[3]))
                    .setBatteryCapacity(Integer.parseInt(splited[4]))
                    .setColor(splited[5])
                    .setPrice(Integer.parseInt(splited[6]))
                    .build();
        }
        return vehicle;
    }
}
