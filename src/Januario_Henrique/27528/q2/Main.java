package Januario_Henrique.27528.q2;

import java.util.*;
import java.text.SimpleDateFormat;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    public static void main(String[] args) {
        try {
            System.out.println("STUDENT ID: 27528");
            System.out.println("=== Flight Booking System ===\n");
            
            System.out.print("Use sample data? (y/n): ");
            String choice = scanner.nextLine();
            
            Ticket ticket;
            if (choice.equalsIgnoreCase("y")) {
                ticket = createSampleData();
            } else {
                ticket = createUserData();
            }
            
            if (ticket != null) {
                ticket.calculateFare();
                double quickFare = ticket.calculateFare(false);
                System.out.println("Quick Fare Calculation: $" + String.format("%.2f", quickFare));
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
    
    private static Ticket createSampleData() {
        try {
            Date currentDate = new Date();
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, 45);
            
            Date flightDate = cal.getTime();
            
            return new Ticket(
                1, currentDate, currentDate,
                "Kigali International Airport", "KGL", "Kigali",
                "RwandAir", "WB", "contact@rwandair.com",
                "WB950", "Kigali", "Nairobi", 450.0,
                "John Smith", "P1234567", 8,
                "Alice Johnson", "Chief Purser", "Day",
                "Marie Uwase", 28, "Female", "0781234567",
                currentDate, "15A", "Business",
                currentDate, "Credit Card", 1200.0,
                "TKT2024001", currentDate
            );
            
        } catch (Exception e) {
            System.out.println("Error creating sample data: " + e.getMessage());
            return null;
        }
    }
    
    private static Ticket createUserData() {
        try {
            Date currentDate = new Date();
            
            System.out.println("\n--- Enter Flight Booking Details ---");
            
            System.out.print("Enter Passenger Name: ");
            String passengerName = scanner.nextLine();
            
            System.out.print("Enter Age: ");
            int age = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Enter Travel Class (Economy/Business/First): ");
            String travelClass = scanner.nextLine();
            
            System.out.print("Enter Base Fare: ");
            double baseFare = Double.parseDouble(scanner.nextLine());
            
            return new Ticket(
                1, currentDate, currentDate,
                "User Airport", "UAR", "User City",
                "User Airlines", "UAL", "contact@user.com",
                "UAL001", "City A", "City B", baseFare,
                "User Pilot", "P987654", 5,
                "User Crew", "Flight Attendant", "Day",
                passengerName, age, "Other", "0780000000",
                currentDate, "10B", travelClass,
                currentDate, "Cash", baseFare * 2,
                "TKT" + System.currentTimeMillis(), currentDate
            );
            
        } catch (Exception e) {
            System.out.println("Error creating user data: " + e.getMessage());
            return null;
        }
    }
}