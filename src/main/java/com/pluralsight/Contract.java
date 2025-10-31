package com.pluralsight;

import java.util.ArrayList;

public abstract class Contract {
    private String contract_date;
    private String customer_name;
    private String customer_email;
    private Vehicle vehicle_sold;
    private double total_price;
    private double monthly_payment;

    private Dealership dealership;
    private ArrayList<Vehicle> inventory_copy;

    public Contract(String contract_date, String customer_name, String customer_email, Vehicle vehicle_sold) {
        this.contract_date = contract_date;
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.vehicle_sold = vehicle_sold;
        this.inventory_copy =
    }

    public String getContract_date() {
        return contract_date;
    }

    public void setContract_date(String contract_date) {
        this.contract_date = contract_date;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public Vehicle getVehicle_sold() {
        return vehicle_sold;
    }

    public void setVehicle_sold(Vehicle vehicle_sold) {
        this.vehicle_sold = vehicle_sold;
    }



    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();
}
