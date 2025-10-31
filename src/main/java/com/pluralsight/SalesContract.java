package com.pluralsight;

public class SalesContract extends Contract {
    private double sales_tax_amount;
    private int recording_fee ;
    private double processing_fee;
    private boolean isFinanced;

    public SalesContract(String contract_date, String customer_name, String customer_email, Vehicle vehicle_sold, boolean isFinanced) {
        super(contract_date, customer_name, customer_email, vehicle_sold);
        this.sales_tax_amount =  0.05;
        this.recording_fee = 100;
        this.processing_fee = calculate_processing_fee(vehicle_sold.getPrice());
        this.isFinanced = isFinanced;
    }

    //Calculates the processing fee
    private double calculate_processing_fee(double price){
        if(price < 10000){
            return 295;
        }
        else{
            return 495;
        }
    }

    public double getSales_tax_amount() {
        return sales_tax_amount;
    }

    public void setSales_tax_amount(double sales_tax_amount) {
        this.sales_tax_amount = sales_tax_amount;
    }

    public int getRecording_fee() {
        return recording_fee;
    }

    public void setRecording_fee(int recording_fee) {
        this.recording_fee = recording_fee;
    }

    public double getProcessing_fee() {
        return processing_fee;
    }

    public void setProcessing_fee(double processing_fee) {
        this.processing_fee = processing_fee;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }


    //Calculates the total price
    @Override
    public double getTotalPrice(){
        double vehicle_price = getVehicle_sold().getPrice();
        double total_price = vehicle_price + (vehicle_price * sales_tax_amount) + recording_fee + processing_fee;

        return total_price;
    }

    //calculates the monthly payment
    @Override
    public double getMonthlyPayment(){
        if(isFinanced != true){
            return 0.0;
        }

        double price = getTotalPrice();
        double rate;
        int months;

        if(price > 10000){
            rate = 0.0425/12;
            months = 48;

        }
        else{
            rate = 0.0525/12;
            months = 24;

        }

        //M = P * (r * (1+r)^n) / ((1+r)^n - 1)
        return price * (rate * Math.pow(1+rate, months))/ (Math.pow(1+rate, months) - 1);
    }
}
