package Januario_Henrique.27528.q3;

import java.util.Date;

public class Employee extends Employer {
    private String employeeName;
    private double salary;
    private String employerTIN;
    
    public Employee(int id, Date createdDate, Date updatedDate,
                   String authorityName, String region, String email,
                   String categoryName, double rate, String code,
                   String tin, String taxpayerName, String address,
                   String employerName, String employerTIN, String contact,
                   String employeeName, double salary, String employeeEmployerTIN) {
        super(id, createdDate, updatedDate, authorityName, region, email,
              categoryName, rate, code, tin, taxpayerName, address,
              employerName, employerTIN, contact);
        
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary must be greater than 0");
        }
        if (employeeEmployerTIN == null || !employeeEmployerTIN.matches("\\d{9}")) {
            throw new IllegalArgumentException("Employer TIN must be 9 digits");
        }
        
        this.employeeName = employeeName;
        this.salary = salary;
        this.employerTIN = employeeEmployerTIN;
    }
    
    public String getEmployeeName() { return employeeName; }
    public double getSalary() { return salary; }
    public String getEmployerTIN() { return employerTIN; }
    
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    
    public void setSalary(double salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary must be greater than 0");
        }
        this.salary = salary;
    }
    
    public void setEmployerTIN(String employerTIN) {
        if (employerTIN == null || !employerTIN.matches("\\d{9}")) {
            throw new IllegalArgumentException("Employer TIN must be 9 digits");
        }
        this.employerTIN = employerTIN;
    }
    
    public double calculateAnnualSalary() {
        return salary * 12;
    }
}