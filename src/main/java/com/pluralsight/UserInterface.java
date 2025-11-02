package com.pluralsight;

import java.io.Console;
import java.util.ArrayList;

public class UserInterface {

    private Dealership dealership;
    DealershipFileManager fileManager = new DealershipFileManager();


    public UserInterface(){

    }

    /* Holds all the data */
    private void init() {
        /* Create an instance of DealershipFileManager */
        DealershipFileManager fileManager = new DealershipFileManager();

        /* Call it's 'getDealerShipFromFile' method and Assign the returned dealership to this.dealership */
        this.dealership = fileManager.getDealerShipFromFile();

    }

    public void display(){
        init();

        String dealershipMenu = """
                === Dealership Menu ===
                1) Get vehicles by price
                2) Get vehicles by make/model
                3) Get vehicles by year
                4) Get vehicles by color
                5) Get vehicles by mileage
                6) Get vehicles by vehicle type
                7) Get all vehicles
                8) Add a vehicle
                9) Remove a vehicle
                10) Sell a vehicle 
                11) Lease a vehicle
                0) Exit
                """;

        int command = -1;
        while (command != 0) {
            System.out.println(dealershipMenu);
            command = ConsoleHelper.promptForInt("Choose an option: ");

            switch (command) {
                case 1:
                    System.out.println("Get Vehicles by price! ");
                    processGetByPriceRequest();
                    break;

                case 2:
                    System.out.println("Get Vehicles by make/model! ");
                    processGetByMakeModelRequest();
                    break;

                case 3:
                    System.out.println("Get Vehicles by year! ");
                    processGetByYearRequest();
                    break;

                case 4:
                    System.out.println("Get Vehicles by color! ");
                    processGetByColorRequest();
                    break;

                case 5:
                    System.out.println("Get Vehicles by mileage! ");
                    processGetByMileageRequest();
                    break;

                case 6:
                    System.out.println("Get Vehicles by vehicle type! ");
                    processGetByVehicleTypeRequest();
                    break;

                case 7:
                    System.out.println("Get all vehicles! ");
                    processGetAllVehicleRequest();
                    break;

                case 8:
                    System.out.println("Add a vehicle! ");
                    processAddVehicleRequest();
                    break;

                case 9:
                    System.out.println("Remove a vehicle! ");
                    processRemoveVehicleRequest();
                    break;

                case 10:
                    System.out.println("Sell a vehicle!");
                    processSellVehicleRequest();
                    break;

                case 11:
                    System.out.println("Lease a vehicle!");
                    processLeaseVehicleRequest();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }


    public void processSellVehicleRequest() {
        dealership.getAllVehicles();

        ContractFileManager contractManager = new ContractFileManager();

        int vin = ConsoleHelper.promptForInt("Enter VIN of the vehicle to sell: ");
        Vehicle selectedVehicle = null;

        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getVin() == vin) {
                selectedVehicle = v;
                break;
            }
        }

        if (selectedVehicle == null) {
            System.out.println("Vehicle not found!");
            return;
        }

        String customerName = ConsoleHelper.promptForString("Enter customer name: ");
        String customerEmail = ConsoleHelper.promptForString("Enter customer email: ");
        String date = ConsoleHelper.promptForString("Enter contract date (YYYY-MM-DD): ");
        boolean isFinanced = ConsoleHelper.promptForString("Is the vehicle financed? (YES/NO): ").equalsIgnoreCase("YES");

        SalesContract contract = new SalesContract(date, customerName, customerEmail, selectedVehicle, isFinanced);

        // Save the contract
        contractManager.saveContract(contract);

        // Remove sold vehicle
        dealership.removeVehicles(selectedVehicle);

        // Update dealership file
        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.saveDealership(dealership);

        System.out.println("Vehicle sold and contract saved successfully!");
    }



    public void processLeaseVehicleRequest() {
        //this just prints out all the vehicles
        System.out.println(dealership.getAllVehicles());


        ContractFileManager contractManager = new ContractFileManager();

       //ask user to enter vin to locate vehicle of choosing
        int vin = ConsoleHelper.promptForInt("Enter vin of vehicle to lease: ");
        Vehicle selected_vehicle = null;

//        for (Vehicle v : dealership.getAllVehicles()) {
//            if (v.getVin() == vin) {
//                selectedVehicle = v;
//                break;
//            }
//        }

        for(int i = 0; i < dealership.getAllVehicles().size(); i++){
            Vehicle vin_vehicles = dealership.getAllVehicles().get(i);
            if(vin_vehicles.getVin() == vin){
                selected_vehicle = vin_vehicles;
                break;
            }

        }



        //says if selected vehicle is empty/not there - vehicle is not there
        if (selected_vehicle == null) {
            System.out.println("Vehicle not found!");
            return;
        }

        //asks for user input
        String contract_date = ConsoleHelper.promptForString("Enter the date: ");
        String customer_name = ConsoleHelper.promptForString("Enter your name: ");
        String customer_email = ConsoleHelper.promptForString("Enter your email: ");

        //saves user input into object
        LeaseContract leaseContract = new LeaseContract(contract_date, customer_name, customer_email, selected_vehicle);

        // Save contract - passes it thru parameter to write to csv
        ContractFileManager contractFileManager = new ContractFileManager();
        contractFileManager.saveContract(leaseContract);

        // Remove leased vehicle
        dealership.removeVehicles(selected_vehicle);

        // Update dealership file
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.saveDealership(dealership);


        System.out.println(" Vehicle leased and contract saved successfully!");
    }




    public void processGetByPriceRequest(){
        double min = ConsoleHelper.promptForDouble("Enter you minimum value for your price: ");
        double max = ConsoleHelper.promptForDouble("Enter you maximum value for your price: ");

        dealership.getVehiclesByPrice(min, max);

    }

    public void processGetByMakeModelRequest(){
        String make = ConsoleHelper.promptForString("Enter make: ");
        String model = ConsoleHelper.promptForString("Enter Model: ");

        dealership.getVehiclesByMakeModel(make,model);

    }

    public void processGetByYearRequest(){
        int min = ConsoleHelper.promptForInt("Enter min year: ");
        int max = ConsoleHelper.promptForInt("Enter max year: ");

        dealership.getVehiclesByYear(min, max);
    }

    public void processGetByColorRequest(){
        String vehicle_color = ConsoleHelper.promptForString("Enter vehicle color: ");
        dealership.getVehiclesByColor(vehicle_color);
    }

    public void processGetByMileageRequest(){
        int min = ConsoleHelper.promptForInt("Enter mileage min: ");
        int max = ConsoleHelper.promptForInt("Enter mileage max: ");

        dealership.getVehiclesByMileage(min, max);

    }

    public void processGetByVehicleTypeRequest(){
        String vehicle_type = ConsoleHelper.promptForString("Enter vehicle type: ");

        dealership.getVehiclesByType(vehicle_type);

    }

    public void displayVehicles(ArrayList<Vehicle> vehicles){
        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }
    }

    //stores all the data in the ArrayList: inventory
    public void processGetAllVehicleRequest(){
        //will work since you are calling the object with the data
        displayVehicles(dealership.getAllVehicles());

    }

    public void processAddVehicleRequest(){
        int vin = ConsoleHelper.promptForInt("Enter car vin:");
        int year = ConsoleHelper.promptForInt("Enter specific car year: ");
        String make = ConsoleHelper.promptForString("Enter car make: ");
        String model = ConsoleHelper.promptForString("Enter car model: ");
        String vehicleType = ConsoleHelper.promptForString("Enter vehicle type: ");
        String color = ConsoleHelper.promptForString("Enter car color: ");
        int odometer = ConsoleHelper.promptForInt("Enter the car mileage: ");
        double price = ConsoleHelper.promptForDouble("Enter car price; ");

        Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(newVehicle);


        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.saveDealership(dealership);

    }

    public void processRemoveVehicleRequest(){

//        Vehicle vehicle = new Vehicle();
//        dealership.removeVehicles(vehicle);
//
//        //updates the inventory back to the csv file
//        fileManager.saveDealership(dealership);

        int vin = ConsoleHelper.promptForInt("Enter VIN to remove: ");

        // Find the matching vehicle from inventory
        Vehicle toRemove = null;
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getVin() == vin) {
                toRemove = v;
                break;
            }
        }

        if (toRemove != null) {
            dealership.removeVehicles(toRemove);
            fileManager.saveDealership(dealership);
        } else {
            System.out.println("No vehicle found with VIN: " + vin);
        }


    }
}

