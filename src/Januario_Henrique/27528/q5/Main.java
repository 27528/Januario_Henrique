package Januario_Henrique.27528.q5;

import java.util.*;
import java.text.SimpleDateFormat;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    public static void main(String[] args) {
        try {
            System.out.println("STUDENT ID: 27528");
            System.out.println("=== ATTENDANCE MANAGEMENT SYSTEM ===\n");
            
            System.out.print("Use sample data? (y/n): ");
            String choice = scanner.nextLine();
            
            AttendanceSummary summary;
            if (choice.equalsIgnoreCase("y")) {
                summary = createSampleData();
            } else {
                summary = createUserData();
            }
            
            if (summary != null) {
                summary.generateSummary();
                double quickPercentage = summary.generateSummary(false);
                System.out.println("Quick Attendance Percentage: " + String.format("%.1f", quickPercentage) + "%");
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
    
    private static AttendanceSummary createSampleData() {
        try {
            Date currentDate = new Date();
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, -7); // Session was 7 days ago
            
            Date sessionDate = cal.getTime();
            
            return new AttendanceSummary(
                1, currentDate, currentDate,                    // Entity
                "University of Rwanda", "UR", "Kigali, Rwanda", // Institution
                "Computer Science", "Dr. Alice Uwase",          // Department
                "Object-Oriented Programming", "CS201", 4,      // Course
                "Dr. John Smith", "john.smith@ur.ac.rw", "0781234567", // Instructor
                "Marie Uwase", "2024001", 20,                   // Student
                sessionDate, "Inheritance and Polymorphism",    // ClassSession
                "2024001", "SESS001", "Present",                // AttendanceRecord
                currentDate, "Medical appointment", false,      // LeaveRequest
                currentDate, 15, 2                              // AttendanceSummary
            );
            
        } catch (Exception e) {
            System.out.println("Error creating sample data: " + e.getMessage());
            return null;
        }
    }
    
    private static AttendanceSummary createUserData() {
        try {
            Date currentDate = new Date();
            
            System.out.println("\n--- Enter Attendance Data ---");
            
            System.out.print("Enter Student Name: ");
            String studentName = scanner.nextLine();
            
            System.out.print("Enter Student ID: ");
            String studentID = scanner.nextLine();
            
            System.out.print("Enter Age: ");
            int age = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Enter Total Present Sessions: ");
            int present = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Enter Total Absent Sessions: ");
            int absent = Integer.parseInt(scanner.nextLine());
            
            return new AttendanceSummary(
                1, currentDate, currentDate,
                "User University", "UU001", "User City",
                "User Department", "Department Head",
                "User Course", "CRS001", 3,
                "Instructor Name", "instructor@university.edu", "0780000000",
                studentName, studentID, age,
                currentDate, "Course Topic",
                studentID, "SESS001", "Present",
                currentDate, "Personal reasons", false,
                currentDate, present, absent
            );
            
        } catch (Exception e) {
            System.out.println("Error creating user data: " + e.getMessage());
            return null;
        }
    }
}