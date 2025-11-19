package Januario_Henrique.27528.q6;

import java.util.*;
import java.text.SimpleDateFormat;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    public static void main(String[] args) {
        try {
            System.out.println("STUDENT ID: 27528");
            System.out.println("=== PAYROLL MANAGEMENT SYSTEM (RSSB) ===\n");
            
            System.out.print("Use sample data? (y/n): ");
            String choice = scanner.nextLine();
            
            Payslip payslip;
            if (choice.equalsIgnoreCase("y")) {
                payslip = createSampleData();
            } else {
                payslip = createUserData();
            }
            
            if (payslip != null) {
                payslip.generatePayslip();
                System.out.println("\n--- Quick Summary ---");
                payslip.generatePayslip(false);
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
    
    private static Payslip createSampleData() {
        try {
            Date currentDate = new Date();
            Calendar cal = Calendar.getInstance();
            cal.set(2024, Calendar.NOVEMBER, 1); // November 2024
            Date startDate = cal.getTime();
            cal.set(2024, Calendar.NOVEMBER, 30);
            Date endDate = cal.getTime();
            
            return new Payslip(
                1, currentDate, currentDate,                    // Entity
                "Tech Solutions Ltd", "TSL001", "12345678", "hr@techsolutions.rw", // Organization
                "IT Department", "ITD001", "Alice Uwase",       // Department
                "1001", "Jean de Dieu", "Software Developer", 250000, true, // Employee
                11, 2024, startDate, endDate,                  // PayrollPeriod
                200000, 25000, 50000,                          // SalaryStructure
                10000, 45000, 15000,                           // Deduction
                10, 5000, 20000,                               // Allowance
                300000, 70000, 230000,                         // Payroll
                "PSL202411001", currentDate                    // Payslip
            );
            
        } catch (Exception e) {
            System.out.println("Error creating sample data: " + e.getMessage());
            return null;
        }
    }
    
    private static Payslip createUserData() {
        try {
            Date currentDate = new Date();
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.DAY_OF_MONTH, 1);
            Date startDate = cal.getTime();
            cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
            Date endDate = cal.getTime();
            
            System.out.println("\n--- Enter Payroll Data ---");
            
            System.out.print("Enter Employee Name: ");
            String employeeName = scanner.nextLine();
            
            System.out.print("Enter Employee ID (≥1000): ");
            String employeeID = scanner.nextLine();
            
            System.out.print("Enter Base Salary: ");
            double baseSalary = Double.parseDouble(scanner.nextLine());
            
            System.out.print("Is RSSB Registered? (y/n): ");
            boolean rssbRegistered = scanner.nextLine().equalsIgnoreCase("y");
            
            return new Payslip(
                1, currentDate, currentDate,
                "User Organization", "UORG001", "87654321", "hr@user.org",
                "User Department", "UDEPT001", "Manager Name",
                employeeID, employeeName, "Employee Position", baseSalary, rssbRegistered,
                Calendar.getInstance().get(Calendar.MONTH) + 1, 
                Calendar.getInstance().get(Calendar.YEAR), startDate, endDate,
                baseSalary * 0.8, baseSalary * 0.1, baseSalary * 0.1,
                baseSalary * 0.05, baseSalary * 0.18, baseSalary * 0.06,
                5, baseSalary / 160, baseSalary * 0.08,
                baseSalary * 1.33, baseSalary * 0.29, baseSalary * 1.04,
                "PSL" + System.currentTimeMillis(), currentDate
            );
            
        } catch (Exception e) {
