
package Januario_Henrique.27528.q1;

import java.util.*;
import java.text.SimpleDateFormat;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    public static void main(String[] args) {
        try {
            System.out.println("STUDENT ID: 27528");
            System.out.println("=== Stock Management System ===\n");
            
            System.out.print("Use sample data? (y/n): ");
            String choice = scanner.nextLine();
            
            StockReport report;
            if (choice.equalsIgnoreCase("y")) {
                report = createSampleData();
            } else {
                report = createUserData();
            }
            
            if (report != null) {
                report.generateReport();
                System.out.println("\n--- Quick Summary ---");
                report.generateReport(false);
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
    
    private static StockReport createSampleData() {
        try {
            Date currentDate = new Date();
            
            return new StockReport(
                1, currentDate, currentDate,
                "Main Warehouse", "Kigali", "0781234567",
                "Electronics", "ELEC123",
                "Tech Supplies Ltd", "contact@techsupplies.com", "0787654321",
                "Laptop", 1200.0, 50,
                25, 10,
                currentDate, 20, "Tech Supplies Ltd",
                currentDate, 5, "John Doe",
                150, 180000.0,
                currentDate, "Monthly stock report"
            );
            
        } catch (Exception e) {
            System.out.println("Error creating sample data: " + e.getMessage());
            return null;
        }
    }
    
    private static StockReport createUserData() {
        try {
            Date currentDate = new Date();
            
            System.out.println("\n--- Enter Stock Data ---");
            
            System.out.print("Enter Product Name: ");
            String productName = scanner.nextLine();
            
            System.out.print("Enter Unit Price: ");
            double unitPrice = Double.parseDouble(scanner.nextLine());
            
            System.out.print("Enter Quantity Available: ");
            int quantityAvailable = Integer.parseInt(scanner.nextLine());
            
            return new StockReport(
                1, currentDate, currentDate,
                "User Warehouse", "User Location", "0781111111",
                "User Category", "USER123",
                "User Supplier", "supplier@user.com", "0782222222",
                productName, unitPrice, 100,
                quantityAvailable, 15,
                currentDate, 50, "User Supplier",
                currentDate, 10, "Customer Name",
                200, 50000.0,
                currentDate, "User-generated report"
            );
            
        } catch (Exception e) {
            System.out.println("Error creating user data: " + e.getMessage());
            return null;
        }
    }
}