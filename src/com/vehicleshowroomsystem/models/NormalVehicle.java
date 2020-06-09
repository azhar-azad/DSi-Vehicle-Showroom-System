package com.vehicleshowroomsystem.models;

public class NormalVehicle extends Vehicle {

    public NormalVehicle() {
    }

    public NormalVehicle(String modelNumber, String engineType, double enginePower, int tireSize) {
        super("NR", modelNumber, engineType, enginePower, tireSize);
    }

    public void showVehicle() {

        super.showVehicle();
    }
}
