package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class ConsoleHelper {

    private static Scanner scanner = new Scanner(System.in);

    public static String promptForString(String prompt) {
        String input;

        while (true) {
            System.out.print(prompt + ": ");
            input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Error: Input cannot be empty. Please enter a valid string.");
            }
            // checks if all characters are digits
            else if (input.matches("\\d+")) {
                System.out.println("Error: Input cannot be numbers. Please enter text.");
            }
            else {
                break;
            }
        }

        return input;
    }


    public static int promptForInt(String prompt){

        boolean isValid = false;
        int result = 0;
        do{
            try{
                System.out.print(prompt + ": ");
                result = scanner.nextInt();
                scanner.nextLine();
                isValid = true;
            }
            catch(Exception ex){
                scanner.nextLine();
                System.out.println("Invalid Entry, please enter a whole number");
                //ex.printStackTrace();
            }
        } while (!isValid);


        //after the catch
        return result;

    }


    public static int promptForIntAlt(String prompt){

        int result = 0 ;

        try{
            System.out.print(prompt + ": ");
            result = scanner.nextInt();
            scanner.nextLine();
        }
        catch(Exception ex){
            scanner.nextLine();
            System.out.println("Invalid Entry, please enter a whole number");
        }

        //after the catch
        return result;

    }

    public static float promptForFloat(String prompt){
        System.out.print(prompt + ": ");
        float result = scanner.nextFloat();
        scanner.nextLine();
        return result;
    }

    public static double promptForDouble(String prompt) {
        double result = 0.0;

        while (true) {
            System.out.print(prompt + ": ");
            try {
                result = Double.parseDouble(scanner.nextLine().trim());
                break; // valid number, exit loop
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number (e.g., 12.5 or 3).");
            }
        }

        return result;
    }

    public static long promptForLong(String prompt){
        System.out.print(prompt + ": ");
        long result = scanner.nextLong();
        scanner.nextLine();
        return result;
    }
}