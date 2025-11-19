package Januario_Henrique.27528.q6;

import java.util.Date;

public class Employee extends Department {
    private String employeeID;
    private String fullName;
    private String position;
    private double baseSalary;
    private boolean rssbRegistered;
    
    public Employee(int id, Date createdDate, Date updatedDate,
                   String orgName, String orgCode, String rssbNumber, String contactEmail,
                   String deptName, String deptCode, String managerName,
                   String employeeID, String fullName, String position, double baseSalary, boolean rssbRegistered) {
        super(id, createdDate, updatedDate, orgName, orgCode, rssbNumber, contactEmail,
              deptName, deptCode, managerName);
        
        if (employeeID == null || Integer.parseInt(employeeID) < 1000) {
            throw new IllegalArgumentException("Employee ID must be at least 1000");
        }
        if (baseSalary <= 0) {
            throw new IllegalArgumentException("Base salary must be greater than 0");
        }
        
        this.employeeID = employeeID;
        this.fullName = fullName;
        this.position = position;
        this.baseSalary = baseSalary;
        this.rssbRegistered = rssbRegistered;
    }
    
    public String getEmployeeID() { return employeeID; }
    public String getFullName() { return fullName; }
    public String getPosition() { return position; }
    public double getBaseSalary() { return baseSalary; }
    public boolean isRssbRegistered() { return rssbRegistered; }
    
    public void setEmployeeID(String employeeID) {
        if (employeeID == null || Integer.parseInt(employeeID) < 1000) {
            throw new IllegalArgumentException("Employee ID must be at least 1000");
        }
        this.employeeID = employeeID;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    
    public void setBaseSalary(double baseSalary) {
        if (baseSalary <= 0) {
            throw new IllegalArgumentException("Base salary must be greater than 0");
        }
        this.baseSalary = baseSalary;
    }
    
    public void setRssbRegistered(boolean rssbRegistered) {
        this.rssbRegistered = rssbRegistered;
    }
    
    public double getAnnualSalary() {
        return baseSalary * 12;
    }
}