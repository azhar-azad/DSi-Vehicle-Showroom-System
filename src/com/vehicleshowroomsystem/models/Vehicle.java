package com.vehicleshowroomsystem.models;

public abstract class Vehicle {

    private String type;

    private String modelNumber;
    private String engineType;
    private double enginePower;
    private int tireSize;

    public Vehicle() {
    }

    public Vehicle(String type, String modelNumber, String engineType, double enginePower, int tireSize) {
        this.type = type;
        this.modelNumber = modelNumber;
        this.engineType = engineType;
        this.enginePower = enginePower;
        this.tireSize = tireSize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public int getTireSize() {
        return tireSize;
    }

    public void setTireSize(int tireSize) {
        this.tireSize = tireSize;
    }

    public void showVehicle() {

        System.out.println();
        System.out.println("Model Number: " + modelNumber);
        System.out.println("Engine Type: " + engineType);
        System.out.println("Engine Power: " + enginePower + "hp");
        System.out.println("Tire Size: " + tireSize + "mm");

    }
}
