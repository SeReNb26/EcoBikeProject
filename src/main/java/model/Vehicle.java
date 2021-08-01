package model;

import java.util.Objects;

public abstract class Vehicle {
    protected String brand;
    protected int weightInGrams;
    protected boolean hasLightsAtFrontAndBack;
    protected String color;
    protected int price;

    public String getBrand() {
        return brand;
    }

    public int getWeightInGrams() {
        return weightInGrams;
    }

    public boolean getIsHasLightsAtFrontAndBack() {
        return hasLightsAtFrontAndBack;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vehicle vehicle = (Vehicle) o;
        return Double.compare(vehicle.weightInGrams, weightInGrams) == 0
                && hasLightsAtFrontAndBack == vehicle.hasLightsAtFrontAndBack
                && Double.compare(vehicle.price, price) == 0
                && Objects.equals(brand, vehicle.brand)
                && Objects.equals(color, vehicle.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, weightInGrams, hasLightsAtFrontAndBack, color, price);
    }
}
