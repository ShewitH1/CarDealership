package com.pluralsight;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public Dealership() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 3 methods
     * @param vehicle
     */

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);

    }

    public ArrayList<Vehicle> getAllVehicles(){
        return new ArrayList<>(inventory);
        }


        public void removeVehicles(Vehicle vehicle) {
            if (inventory.remove(vehicle)) {
                System.out.println("Vehicle with VIN " + vehicle.getVin() + " removed successfully!");
            } else {
                System.out.println("Vehicle not found in inventory.");
            }
        }


    /**
     * Other methods
     * @param min
     * @param max
     * @return
     */

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max){
        ArrayList<Vehicle> price_vehicles = new ArrayList<>();


        for(int i = 0; i<inventory.size(); i++){
            Vehicle v = inventory.get(i);
            if (v.getPrice() >= min && v.getPrice() <= max){
                price_vehicles.add(v);
                System.out.println(v);
            }
        }
        return price_vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model){
        ArrayList<Vehicle> model_vehicles = new ArrayList<>();
        for(Vehicle model2 : inventory){
            if (model2.getMake().equalsIgnoreCase(make) && model2.getModel().equalsIgnoreCase(model)){
                model_vehicles.add(model2);
                System.out.println(model2);
            }
        }
        return model_vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max){
        ArrayList<Vehicle> year_vehicle = new ArrayList<>();

        for(int i = 0; i<inventory.size(); i++){
            Vehicle year = inventory.get(i);
            if(year.getYear() >= min && year.getYear()<=max){
                year_vehicle.add(year);
                System.out.println(year);
            }
        }
        return year_vehicle;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color){
        ArrayList<Vehicle> color_vehicle =  new ArrayList<>();

        for(Vehicle colorVehicle : inventory){
            if(colorVehicle.getColor().equalsIgnoreCase(color)){
                color_vehicle.add(colorVehicle);
                System.out.println(colorVehicle);
            }
        }
        return color_vehicle;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max){
        ArrayList<Vehicle> mileage_car = new ArrayList<>();

        for(Vehicle mileageCar : inventory){
            if (mileageCar.getOdometer() >= min && mileageCar.getOdometer() <= max){
                mileage_car.add(mileageCar);
                System.out.println(mileageCar);
            }
        }

        return mileage_car;
    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType){
        ArrayList<Vehicle> type_vehicle = new ArrayList<>();

        for(int i = 0; i<inventory.size(); i++){
            Vehicle typeVehicle = inventory.get(i);
            if (typeVehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
                type_vehicle.add(typeVehicle);
                System.out.println(typeVehicle);
            }
        }
        return type_vehicle;
    }

//    @Override
//    public String toString() {
//        return "Dealership{" +
//                "name='" + name + '\'' +
//                ", address='" + address + '\'' +
//                ", phone='" + phone + '\'' +
//                ", inventory=" + inventory +
//                '}';
//    }

    @Override
    public String toString() {
        return String.format(
                "%-20s | %-30s | %-15s | %-10s",
                name, address, phone, "Inventory: " + inventory
        );
    }
}


