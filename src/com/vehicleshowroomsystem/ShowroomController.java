package com.vehicleshowroomsystem;

public class ShowroomController {

    private ShowroomService service = new ShowroomService();

    public void runProgram() throws Exception {

        System.out.println();
        System.out.println("Welcome to Vehicle Showroom System.");

        for (;;) {

            int userChoice = service.initPrompt();

            if (userChoice == 0) {
                System.out.println("Thank you for visiting our Showroom\n");
                break;
            }

            else if (userChoice == 1) {  // add a vehicle

                service.addVehicletoShowroom();
//                if (service.addVehicletoShowroom() == 0)
//                    continue;
//                else
//                    System.out.println("VEHICLE IS ADDED");
            }

            else if (userChoice == 2) {     // remove a vehicle

//                System.out.println("Enter Model Number: ");
//                String modelNumber = scanner.nextLine();

                service.removeVehicleFromShowroom();

            }

            else if (userChoice == 3) {     // show list with ev
                service.showVehicleListWithEV();
            }

            else if (userChoice == 4) {     // show list without ev
                service.showVehicleList();
            }

            else if (userChoice == 5) {     // show ev
                service.showEV();
            }

            else {      // invalid choice prompt
                System.out.println("You've chosen wrong. Please enter valid number.");
            }
        }


    }

}
