package com.vehicleshowroomsystem;

import com.vehicleshowroomsystem.models.*;

import java.util.List;
import java.util.Scanner;

public class ShowroomService {

    private Scanner scanner = new Scanner(System.in);

    private Showroom showroom = new Showroom();

    public int initPrompt() {

        showMainMenu();

        String uc;
        uc = scanner.nextLine();
        if (isInteger(uc))
            return Integer.parseInt(uc);
        else
            return -1;
//        for (uc = scanner.nextLine(); ;uc = scanner.nextLine()) {
//
//            if (uc.equals("0") || uc.equals("1") || uc.equals("2") || uc.equals("3") || uc.equals("4") || uc.equals("5")) {
//                break;
//            }
//            System.out.println("Not a valid choice. Please stick to the menu!!");
//        }

//        return Integer.parseInt(uc);
    }

    public void addVehicletoShowroom() throws Exception {

        int vehicleType = vehicleTypeChoice();

        if (vehicleType == 0) {
            return;
            //            continue;
//            return 0;
        }


        else if (vehicleType == 1) {
            System.out.println("Adding a Normal Vehicle --");
            Vehicle vehicle = getVehicleToAdd("normal");
            showroom.addVehicle(vehicle);
        }

        else if (vehicleType == 2) {
            System.out.println("Adding a Sports Vehicle --");
            Vehicle vehicle = getVehicleToAdd("sports");
            showroom.addVehicle(vehicle);
            showroom.increaseEV();
        }

        else if (vehicleType == 3) {
            System.out.println("Adding a Heavy Vehicle --");
            Vehicle vehicle = getVehicleToAdd("heavy");
            showroom.addVehicle(vehicle);
        }

        else {
            System.out.println("Not a valid car choice. Please enter a valid choice.");
//            continue;
//            return 0;
        }
        System.out.println("VEHICLE IS ADDED");
//        return 1;
    }

    public void removeVehicleFromShowroom() {

        List<Vehicle> vehicleList = showroom.getVehicleList();

        if (vehicleList.isEmpty()) {
            System.out.println("No vehicle in Showroom.");
            return;
        }

        System.out.println("Please select the vehicle to remove: ");
        int i;
        for (i = 0; i < vehicleList.size(); i++) {
            System.out.println(vehicleList.get(i).getModelNumber() + " (press " + (i+1) + ")");
        }
        int rmvChoice;
        for (;;) {
            rmvChoice = getIntegerInput("Invalid input. Enter integer");

            if (rmvChoice > i || rmvChoice <= 0) {
                System.out.println("Invalid choice. Please enter appropriate choice.");
            }
            else
                break;
        }
        Vehicle vehicleToRemove = vehicleList.get(rmvChoice-1);
        if (vehicleToRemove.getType().equals("SP")) {
            showroom.decreaseEV();
        }
        showroom.removeVehicle(vehicleList.get(rmvChoice-1));
        System.out.println("VEHICLE IS REMOVED");



//        System.out.println("Please enter the vehicle's Model Number to remove: ");
//        for (int i = 0; i < vehicleList.size(); i++) {
//            System.out.println((i + 1) + ". " + vehicleList.get(i).getModelNumber());
//        }
//        String modelNumber = scanner.nextLine();
//
//        for (Vehicle vehicle: vehicleList) {
//            if (vehicle.getModelNumber().equals(modelNumber)) {
//                if (vehicle.getType().equals("SP"))
//                    showroom.decreaseEV();
//                showroom.removeVehicle(vehicle);
//                System.out.println("VEHICLE IS REMOVED");
//            }
//
//        }
    }

    public void showVehicleListWithEV() {
        showVehicleList();
        showEV();
    }

    public void showVehicleList() {
        showroom.showVehicleList();
    }

    public void showEV() {
        System.out.println("Currently Expected Visitor: " + showroom.getExpectedVisitor());
    }

    public int vehicleTypeChoice() {

        showVehicleSelectMenu();

        String vt;
        for (vt = scanner.nextLine(); ; vt = scanner.nextLine()) {

            if (vt.equals("0") || vt.equals("1") || vt.equals("2") || vt.equals("3")) {
                break;
            }
            System.out.println("Not a valid car choice. Please enter a valid choice.");
        }

        return Integer.parseInt(vt);
    }

    public Vehicle getVehicleToAdd(String vehicleType) {

        System.out.print("Enter Model Number: ");
        String modelNumber = scanner.nextLine();

        System.out.print("Enter Engine Power(hp): ");
        double enginePower = getDoubleInput("Engine Power is numerical. Please try again.");

        System.out.print("Enter Tire Size(mm): ");
        int tireSize = getIntegerInput("Tire Size is numerical. Please try again.");

        if (vehicleType.equals("normal")) {

            System.out.println("Select Engine Type: ");
            System.out.print("Oil(press 1), Gas(press 2), Diesel(press 3): ");
            String engineType;
            for (;;) {
                int engineTypeChoice = getIntegerInput("Must enter a numeric value. Try again.");

                if (engineTypeChoice == 1) {
                    engineType = "Oil";
                    break;
                }
                else if (engineTypeChoice == 2) {
                    engineType = "Gas";
                    break;
                }
                else if (engineTypeChoice == 3) {
                    engineType = "Diesel";
                    break;
                }
                else System.out.println("Invalid choice. Please enter correct code for Engine Type");
            }


            return new NormalVehicle(modelNumber, engineType, enginePower, tireSize);
        }

        else if (vehicleType.equals("sports")) {

            String engineType = "Oil";

            System.out.print("Enter Turbo(hp): ");
            double turbo = getDoubleInput("Turbo value is numerical. Please try again.");

            return new SportsVehicle(modelNumber, engineType, enginePower, tireSize, turbo);
        }

        else if (vehicleType.equals("heavy")) {

            String engineType = "Diesel";

            System.out.print("Enter Weight(kg): ");
            double weight = getDoubleInput("Vehicle weight is numerical. Please try again.");

            return new HeavyVehicle(modelNumber, engineType, enginePower, tireSize, weight);
        }

        else {
            throw new RuntimeException("Undefined Vehicle.");
        }
    }

    // Print Main Menu
    private void showMainMenu() {
        System.out.println("\n--MAIN MENU--");
        System.out.println("1. Add a Vehicle (press 1)");
        System.out.println("2. Remove a Vehicle (press 2)");
        System.out.println("3. View the list of Vehicles with current expected visitor count (press 3)");
        System.out.println("4. View the list of Vehicles (press 4)");
        System.out.println("5. View current expected visitor count (press 5)");
        System.out.println("To Close the program (press 0)");
    }

    // Print Vehicle Select Menu
    private void showVehicleSelectMenu() {
        System.out.println("--VEHICLE TYPE SELECT MENU--");
        System.out.println("What type of Vehicle do you want to add: ");
        System.out.println("Normal class vehicle (press 1)");
        System.out.println("Sports class vehicle (press 2)");
        System.out.println("Heavy class vehicle (press 3)");
        System.out.println("GO BACK to Main Menu (press 0)");
    }

    // Safe-convert user input to integer value
    private int getIntegerInput(String msg) {
        String str = scanner.nextLine();
        for (;;) {
            if (isInteger(str))
                return Integer.parseInt(str);
            else {
                System.out.println(msg);
                str = scanner.nextLine();
            }
        }
    }

    // Safe-convert user input to double value
    private double getDoubleInput(String msg) {
        String str = scanner.nextLine();
        for (;;) {
            if (isDouble(str))
                return Double.parseDouble(str);
            else {
                System.out.println(msg);
                str = scanner.nextLine();
            }
        }
    }

    // Check if user input is positive-integer or not
    private boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            System.out.println("Negative value is invalid for this property.");
            return false;

        }
        for (; i < length; i++) {
            char c = str.charAt(i);

            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    // Check if user input is positive-double or not
    private boolean isDouble(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            System.out.println("Negative value is invalid for this property.");
            return false;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);

            if ((c < '0' || c > '9') && c != '.') {
                return false;
            }
        }
        return true;
    }


}
