package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DealershipFileManager {

    public Dealership getDealerShipFromFile() {

        Dealership dealership = null;
        try {
            FileReader fileReader = new FileReader("inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            /* Dealership */
            String dealerLine = bufferedReader.readLine();
            String[] dealer_part = dealerLine.split("\\|");

            String name = dealer_part[0];
            String address = dealer_part[1];
            String phone = dealer_part[2];

            dealership = new Dealership(name, address, phone);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                /* vehicle */
                String[] vehicle_part = line.trim().split("\\|");

                int vin = Integer.parseInt(vehicle_part[0]);
                int year = Integer.parseInt(vehicle_part[1]);
                String make = vehicle_part[2];
                String model = vehicle_part[3];
                String vehicleType = vehicle_part[4];
                String color = vehicle_part[5];
                int odometer = Integer.parseInt(vehicle_part[6]);
                double price = Double.parseDouble(vehicle_part[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

                dealership.addVehicle(vehicle);

            }

            bufferedReader.close();
            fileReader.close();

        } catch (Exception e) {
            System.out.println("Error!");
            e.printStackTrace();
        }

        return dealership;
    }

    public void saveDealership(Dealership dealership){

    }
}
