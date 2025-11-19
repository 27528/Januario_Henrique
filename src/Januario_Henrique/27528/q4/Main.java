package Januario_Henrique.27528.q4;

import java.util.*;
import java.text.SimpleDateFormat;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    public static void main(String[] args) {
        try {
            System.out.println("STUDENT ID: 27528");
            System.out.println("=== PROCUREMENT MANAGEMENT SYSTEM ===\n");
            
            System.out.print("Use sample data? (y/n): ");
            String choice = scanner.nextLine();
            
            ProcurementReport report;
            if (choice.equalsIgnoreCase("y")) {
                report = createSampleData();
            } else {
                report = createUserData();
            }
            
            if (report != null) {
                report.calculateTotal();
                double quickTotal = report.calculateTotal(false);
                System.out.println("Quick Total Calculation: $" + String.format("%.2f", quickTotal));
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
    
    private static ProcurementReport createSampleData() {
        try {
            Date currentDate = new Date();
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, 5); // Delivery in 5 days
            
            Date deliveryDate = cal.getTime();
            
            return new ProcurementReport(
                1, currentDate, currentDate,                    // Entity
                "Tech Solutions Ltd", "Kigali, Rwanda", "info@techsolutions.rw", // Organization
                "IT Department", "ITD001",                     // Department
                "Hardware Suppliers Ltd", "123456789", "0781234567", // Supplier
                "Laptop Dell XPS 15", 1500.0, 10,              // Product
                "PO-2024-001", currentDate, 15500.0,           // PurchaseOrder
                deliveryDate, "John Delivery",                 // Delivery
                "Quality Check", "Passed", "All items in good condition", // Inspection
                "INV-2024-001", 15500.0,                       // Invoice
                currentDate, "Monthly procurement report"      // ProcurementReport
            );
            
        } catch (Exception e) {
            System.out.println("Error creating sample data: " + e.getMessage());
            return null;
        }
    }
    
    private static ProcurementReport createUserData() {
        try {
            Date currentDate = new Date();
            
            System.out.println("\n--- Enter Procurement Data ---");
            
            System.out.print("Enter Product Name: ");
            String productName = scanner.nextLine();
            
            System.out.print("Enter Unit Price: ");
            double unitPrice = Double.parseDouble(scanner.nextLine());
            
            System.out.print("Enter Quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Enter Supplier Name: ");
            String supplierName = scanner.nextLine();
            
            return new ProcurementReport(
                1, currentDate, currentDate,
                "User Organization", "User Address", "contact@user.org",
                "User Department", "USD001",
                supplierName, "111222333", "0780000000",
                productName, unitPrice, quantity,
                "PO-" + System.currentTimeMillis(), currentDate, unitPrice * quantity * 1.05,
                currentDate, "User Delivery",
                "User Inspection", "Passed", "User remarks",
                "INV-" + System.currentTimeMillis(), unitPrice * quantity * 1.05,
                currentDate, "User-generated procurement report"
            );
            
        } catch (Exception e) {
            System.out.println("Error creating user data: " + e.getMessage());
            return null;
        }
    }
}