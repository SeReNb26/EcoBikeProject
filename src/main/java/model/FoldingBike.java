package model;

import java.util.Objects;

public class FoldingBike extends Vehicle {
    private int sizeOfWheelsInInch;
    private int numberOfGears;

    public FoldingBike(Builder builder) {
        this.brand = builder.brand;
        this.sizeOfWheelsInInch = builder.sizeOfWheelsInInch;
        this.numberOfGears = builder.numberOfGears;
        this.weightInGrams = builder.weightInGrams;
        this.hasLightsAtFrontAndBack = builder.hasLightsAtFrontAndBack;
        this.color = builder.color;
        this.price = builder.price;
    }

    public static class Builder {
        private String brand;
        private int sizeOfWheelsInInch;
        private int numberOfGears;
        private int weightInGrams;
        private boolean hasLightsAtFrontAndBack;
        private String color;
        private int price;

        public Builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder setSizeOfWheelsInInch(int sizeOfWheelsInInch) {
            this.sizeOfWheelsInInch = sizeOfWheelsInInch;
            return this;
        }

        public Builder setNumberOfGears(int numberOfGears) {
            this.numberOfGears = numberOfGears;
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

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setPrice(int price) {
            this.price = price;
            return this;
        }

        public FoldingBike build() {
            return new FoldingBike(this);
        }
    }

    public int getSizeOfWheelsInInch() {
        return sizeOfWheelsInInch;
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    @Override
    public String toString() {
        return "FOLDING BIKE " + brand
                + " with " + numberOfGears + (numberOfGears == 1 ? " gear" : " gears") + " and "
                + (hasLightsAtFrontAndBack ? "head/tail lights" : "no head/tail lights")
                + System.lineSeparator() + "Price: " + price + " euros.";
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
        FoldingBike that = (FoldingBike) o;
        return Double.compare(that.sizeOfWheelsInInch, sizeOfWheelsInInch) == 0
                && numberOfGears == that.numberOfGears;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sizeOfWheelsInInch, numberOfGears);
    }
}
