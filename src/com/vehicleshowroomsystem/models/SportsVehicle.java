package com.vehicleshowroomsystem.models;

public class SportsVehicle extends Vehicle {

    private double turbo;

    public SportsVehicle() {
    }

    public SportsVehicle(double turbo) {
        this.turbo = turbo;
    }

    public SportsVehicle(String modelNumber, String engineType, double enginePower,
                         int tireSize, double turbo) {
        super("SP", modelNumber, engineType, enginePower, tireSize);
        this.turbo = turbo;
    }

    public double getTurbo() {
        return turbo;
    }

    public void setTurbo(double turbo) {
        this.turbo = turbo;
    }

    public void showVehicle() {

        super.showVehicle();
        System.out.println("Turbo: " + turbo + "hp");
    }
}
