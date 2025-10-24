package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DealershipFileManager {

    public Dealership getDealerShipFromFile() {
        ArrayList<Dealership> arrayList = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader("inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();

//            private String name;
//            private String address;
//            private String phone;
           //dealership

            String dealerLine = bufferedReader.readLine();
            String[] dealer_part =  dealerLine.split("\\|");

            String name = dealer_part[0];
            String address = dealer_part[1];
            String phone = dealer_part[2];

            Dealership dealership = new Dealership(name, address, phone);

            String line;
            while((line = bufferedReader.readLine()) != null){
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

        } catch (Exception e) {
            System.out.println("Error!");
        }


        return null;
    }

    public void saveDealership(Dealership dealership){

    }
}
