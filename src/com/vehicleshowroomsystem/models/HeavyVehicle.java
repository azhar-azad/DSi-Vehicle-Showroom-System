package com.vehicleshowroomsystem.models;

public class HeavyVehicle extends Vehicle {

    private double weight;

    public HeavyVehicle() {
    }

    public HeavyVehicle(double weight) {
        this.weight = weight;
    }

    public HeavyVehicle(String modelNumber, String engineType, double enginePower,
                        int tireSize, double weight) {
        super("HV", modelNumber, engineType, enginePower, tireSize);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void showVehicle() {

        super.showVehicle();
        System.out.println("Weight: " + weight + "kg");
    }
}
