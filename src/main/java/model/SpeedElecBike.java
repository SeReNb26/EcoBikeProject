package model;

import java.util.Objects;

public class SpeedElecBike extends Vehicle {
    private int maxSpeed;
    private int batteryCapacity;

    public SpeedElecBike(Builder builder) {
        this.brand = builder.brand;
        this.maxSpeed = builder.maxSpeed;
        this.weightInGrams = builder.weightInGrams;
        this.hasLightsAtFrontAndBack = builder.hasLightsAtFrontAndBack;
        this.batteryCapacity = builder.batteryCapacity;
        this.color = builder.color;
        this.price = builder.price;
    }

    public static class Builder {
        private String brand;
        private int maxSpeed;
        private int weightInGrams;
        private boolean hasLightsAtFrontAndBack;
        private int batteryCapacity;
        private String color;
        private int price;

        public Builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder setMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        public Builder setWeightInGrams(int weightInGrams) {
            this.weightInGrams = weightInGrams;
            return this;
        }

        public Builder setHasLightsAtFrontAndBack(boolean hasLightsAtFrontAndBack) {
            this.hasLightsAtFrontAndBack = hasLightsAtFrontAndBack;
            return this;
        }

        public Builder setBatteryCapacity(int batteryCapacity) {
            this.batteryCapacity = batteryCapacity;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setPrice(int price) {
            this.price = price;
            return this;
        }

        public SpeedElecBike build() {
            return new SpeedElecBike(this);
        }
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    @Override
    public String toString() {
        return "SPEEDELEC " + brand
                + " with " + batteryCapacity + " mAh battery and "
                + (hasLightsAtFrontAndBack ? "head/tail light" : "no head/tail light");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        SpeedElecBike that = (SpeedElecBike) o;
        return maxSpeed == that.maxSpeed && batteryCapacity == that.batteryCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maxSpeed, batteryCapacity);
    }
}
