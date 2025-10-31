package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.rmi.dgc.Lease;
import java.util.ArrayList;

public class ContractFileManager {

//    public void saveDealership(Contract contract){
//
//        try {
//            FileWriter fileWriter = new FileWriter("inventory.csv", true);
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//
////            bufferedWriter.write(contract.getContract_date() + "|" +
////                    contract.getCustomer_name() + "|" +
////                    contract.getCustomer_email());
////            bufferedWriter.newLine();;
//
//            bufferedWriter.write(contract.con() + "|" +
//                    contract.getCustomer_name() + "|" +
//                    contract.getCustomer_email());
//            bufferedWriter.newLine();;
//
//            //write to csv file
//            for(Vehicle vehicle : ){
//                bufferedWriter.write(vehicle.getVin() + "|" +
//                        vehicle.getYear() + "|" +
//                        vehicle.getMake() + "|" +
//                        vehicle.getModel() + "|" +
//                        vehicle.getVehicleType() + "|" +
//                        vehicle.getColor() + "|" +
//                        vehicle.getOdometer() + "|" +
//                        vehicle.getPrice());
//                bufferedWriter.newLine();
//            }
//
//            bufferedWriter.close();
//            fileWriter.close();
//
//            //add this for confirmation that vehicle has been added
//            System.out.println("Your vehicle has been added successfully! Vehicle");
//
//        } catch (Exception e){
//            System.out.println("Error! Vehicle has not been added!");
//
//        }
//
//    }

public void saveContract(Contract contract) {

    //if sales contract

        try {
            FileWriter fileWriter = new FileWriter("inventory.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            if(contract instanceof SalesContract){

                bufferedWriter.write(contract.getContract_date() + "|" +
                    contract.getCustomer_name() + "|" +
                    contract.getCustomer_email());
            bufferedWriter.newLine();

            //cast our contract
            SalesContract sale_contract = (SalesContract) contract;

            String sale_contract_data =
                    "Sale"
                    + "|" +sale_contract.getContract_date()
                    + "|" +sale_contract.getCustomer_name()
                    + "|" + sale_contract.getCustomer_email()
                    + "|" + sale_contract.getVehicle_sold().getVin()
                    + "|" + sale_contract.getVehicle_sold().getYear()
                    + "|" + sale_contract.getVehicle_sold().getMake()
                    + "|" + sale_contract.getVehicle_sold().getModel()
                    + "|" + sale_contract.getVehicle_sold().getVehicleType()
                    + "|" + sale_contract.getVehicle_sold().getColor()
                    + "|" + sale_contract.getVehicle_sold().getOdometer()
                    + "|" + sale_contract.getVehicle_sold().getPrice()
                    //[contract-specific-fields]

                    + "|" + sale_contract.getTotalPrice()
                    + "|" + sale_contract.getMonthlyPayment();
                bufferedWriter.newLine();
            }

            if(contract instanceof LeaseContract){
                //cast our contract
                LeaseContract lease_contract = (LeaseContract) contract;

                String lease_contract_data =
                        "Sale"
                                + "|" +lease_contract.getContract_date()
                                + "|" +lease_contract.getCustomer_name()
                                + "|" + lease_contract.getCustomer_email()
                                + "|" + lease_contract.getVehicle_sold().getVin()
                                + "|" + lease_contract.getVehicle_sold().getYear()
                                + "|" + lease_contract.getVehicle_sold().getMake()
                                + "|" + lease_contract.getVehicle_sold().getModel()
                                + "|" + lease_contract.getVehicle_sold().getVehicleType()
                                + "|" + lease_contract.getVehicle_sold().getColor()
                                + "|" + lease_contract.getVehicle_sold().getOdometer()
                                + "|" + lease_contract.getVehicle_sold().getPrice()
                                //contract-specific fields
                                + "|" + lease_contract.getTotalPrice()
                                + "|" + lease_contract.getMonthlyPayment();
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();

        } catch (Exception e) {
            System.out.println("Error! Vehicle has not been added!");

        }
    }
}


