package com.vehicleshowroomsystem.models;

import java.util.ArrayList;
import java.util.List;

public class Showroom {

    private List<Vehicle> vehicleList;
    private int expectedVisitor;

    public Showroom() {
        vehicleList = new ArrayList<>();
        this.expectedVisitor = 30;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public int getExpectedVisitor() {
        return expectedVisitor;
    }

    public void setExpectedVisitor(int expectedVisitor) {
        this.expectedVisitor = expectedVisitor;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicleList.remove(vehicle);
    }

    public void increaseEV() {
        expectedVisitor += 20;
    }

    public void decreaseEV() {
        expectedVisitor -= 20;
    }

    public void showVehicleList() {

        if (vehicleList.isEmpty()) {
            System.out.println("No Vehicle in Showroom.");
            return;
        }

        System.out.println("--VEHICLE LIST--");
        for (Vehicle vehicle: vehicleList) {
            vehicle.showVehicle();
        }
        System.out.println();
    }
}
