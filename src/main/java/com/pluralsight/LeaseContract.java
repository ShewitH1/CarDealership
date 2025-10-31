package com.pluralsight;

public class LeaseContract extends Contract{
    private double expected_ending_value; //= getVehicle_sold().getPrice() * .50;
    private double lease_fee; //= getVehicle_sold().getPrice() * 0.07;

    public LeaseContract(String contract_date, String customer_name, String customer_email, Vehicle vehicle_sold) {
        super(contract_date, customer_name, customer_email, vehicle_sold);
        this.expected_ending_value = vehicle_sold.getPrice() / 2;
        this.lease_fee = vehicle_sold.getPrice() * 0.07;
    }

    public double getExpected_ending_value() {
        return expected_ending_value;
    }

    public void setExpected_ending_value(double expected_ending_value) {
        this.expected_ending_value = expected_ending_value;
    }

    public double getLease_fee() {
        return lease_fee;
    }

    public void setLease_fee(double lease_fee) {
        this.lease_fee = lease_fee;
    }


    //Calculates the total price
    @Override
    public double getTotalPrice(){

        return 0;
    }

    //calculates the monthly payment
    @Override
    public double getMonthlyPayment(){
        double total_price = getTotalPrice();
        double amount_to_finance = total_price - expected_ending_value;
        double monthly_rate = 0.04 /12;
        int months = 36;
        double monthly_payment;

        monthly_payment = amount_to_finance * (monthly_rate * Math.pow(1 + monthly_rate, months)) /
                (Math.pow(1+monthly_rate, months)-1);


        return monthly_payment;
    }
}
