package Januario_Henrique.27528.q3;

import java.util.*;
import java.text.SimpleDateFormat;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    public static void main(String[] args) {
        try {
            System.out.println("STUDENT ID: 27528");
            System.out.println("=== TAX ADMINISTRATION SYSTEM ===\n");
            
            System.out.print("Use sample data? (y/n): ");
            String choice = scanner.nextLine();
            
            TaxRecord taxRecord;
            if (choice.equalsIgnoreCase("y")) {
                taxRecord = createSampleData();
            } else {
                taxRecord = createUserData();
            }
            
            if (taxRecord != null) {
                taxRecord.computeTax();
                double quickTax = taxRecord.computeTax(false);
                System.out.println("Quick Tax Calculation: Frw " + String.format("%.2f", quickTax));
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
    
    private static TaxRecord createSampleData() {
        try {
            Date currentDate = new Date();
            
            return new TaxRecord(
                1, currentDate, currentDate,                    // Entity
                "Rwanda Revenue Authority", "Kigali", "info@rra.gov.rw", // TaxAuthority
                "Individual Income Tax", 0.30, "IIT001",        // TaxCategory
                "123456789", "Jean de Dieu", "Kigali, Rwanda",  // Taxpayer
                "Tech Solutions Ltd", "987654321", "0781234567", // Employer
                "Marie Uwase", 250000, "987654321",             // Employee
                "January", 250000,                              // TaxDeclaration
                currentDate, 65000,                             // TaxAssessment
                currentDate, 60000,                             // Payment
                "RCT2024001", 65000                             // TaxRecord
            );
            
        } catch (Exception e) {
            System.out.println("Error creating sample data: " + e.getMessage());
            return null;
        }
    }
    
    private static TaxRecord createUserData() {
        try {
            Date currentDate = new Date();
            
            System.out.println("\n--- Enter Tax Data ---");
            
            System.out.print("Enter Taxpayer Name: ");
            String taxpayerName = scanner.nextLine();
            
            System.out.print("Enter TIN (9 digits): ");
            String tin = scanner.nextLine();
            
            System.out.print("Enter Monthly Salary: ");
            double salary = Double.parseDouble(scanner.nextLine());
            
            System.out.print("Enter Tax Rate (e.g., 0.30 for 30%): ");
            double taxRate = Double.parseDouble(scanner.nextLine());
            
            return new TaxRecord(
                1, currentDate, currentDate,
                "User Tax Authority", "User Region", "tax@user.gov",
                "User Tax Category", taxRate, "USR001",
                tin, taxpayerName, "User Address",
                "User Employer Ltd", "111222333", "0780000000",
                "Employee Name", salary, "111222333",
                "January", salary,
                currentDate, salary * taxRate * 12,
                currentDate, salary * taxRate * 10,
                "RCT" + System.currentTimeMillis(), salary * taxRate * 12
            );
            
        } catch (Exception e) {
            System.out.println("Error creating user data: " + e.getMessage());
            return null;
        }
    }
}