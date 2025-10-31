//package com.pluralsight;
//
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.rmi.dgc.Lease;
//import java.util.ArrayList;
//
//public class ContractFileManager {
//
//    public void saveContract(Contract contract) {
//
//    //if sales contract
//
//        try {
//            FileWriter fileWriter = new FileWriter("contract.csv", true);
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            if(contract instanceof SalesContract){
//
//                bufferedWriter.write(contract.getContract_date() + "|" +
//                    contract.getCustomer_name() + "|" +
//                    contract.getCustomer_email());
//            bufferedWriter.newLine();
//
//            //cast our contract
//            SalesContract sale_contract = (SalesContract) contract;
//
//            String sale_contract_data =
//                    "Sale"
//                    + "|" +sale_contract.getContract_date()
//                    + "|" +sale_contract.getCustomer_name()
//                    + "|" + sale_contract.getCustomer_email()
//                    + "|" + sale_contract.getVehicle_sold().getVin()
//                    + "|" + sale_contract.getVehicle_sold().getYear()
//                    + "|" + sale_contract.getVehicle_sold().getMake()
//                    + "|" + sale_contract.getVehicle_sold().getModel()
//                    + "|" + sale_contract.getVehicle_sold().getVehicleType()
//                    + "|" + sale_contract.getVehicle_sold().getColor()
//                    + "|" + sale_contract.getVehicle_sold().getOdometer()
//                    + "|" + sale_contract.getVehicle_sold().getPrice()
//                    //[contract-specific-fields]
//
//                    + "|" + sale_contract.getTotalPrice()
//                    + "|" + sale_contract.getMonthlyPayment();
//                bufferedWriter.write(sale_contract_data);
//                bufferedWriter.newLine();
//            }
//
//            else if(contract instanceof LeaseContract){
//                //cast our contract
//                LeaseContract lease_contract = (LeaseContract) contract;
//
//                String lease_contract_data =
//                        "Sale"
//                                + "|" +lease_contract.getContract_date()
//                                + "|" +lease_contract.getCustomer_name()
//                                + "|" + lease_contract.getCustomer_email()
//                                + "|" + lease_contract.getVehicle_sold().getVin()
//                                + "|" + lease_contract.getVehicle_sold().getYear()
//                                + "|" + lease_contract.getVehicle_sold().getMake()
//                                + "|" + lease_contract.getVehicle_sold().getModel()
//                                + "|" + lease_contract.getVehicle_sold().getVehicleType()
//                                + "|" + lease_contract.getVehicle_sold().getColor()
//                                + "|" + lease_contract.getVehicle_sold().getOdometer()
//                                + "|" + lease_contract.getVehicle_sold().getPrice()
//                                //contract-specific fields
//                                + "|" + lease_contract.getTotalPrice()
//                                + "|" + lease_contract.getMonthlyPayment();
//                bufferedWriter.write(lease_contract_data);
//                bufferedWriter.newLine();
//            }
//            bufferedWriter.close();
//            fileWriter.close();
//
//            System.out.println("Contract saved successfully!");
//
//        } catch (Exception e) {
//            System.out.println("Error! Contract has not been added!");
//            e.printStackTrace();
//
//        }
//    }
//}
//
//
