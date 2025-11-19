package Januario_Henrique.27528.q6;

import java.util.Date;

public class SalaryStructure extends PayrollPeriod {
    private double basicPay;
    private double transportAllowance;
    private double housingAllowance;
    
    public SalaryStructure(int id, Date createdDate, Date updatedDate,
                          String orgName, String orgCode, String rssbNumber, String contactEmail,
                          String deptName, String deptCode, String managerName,
                          String employeeID, String fullName, String position, double baseSalary, boolean rssbRegistered,
                          int month, int year, Date startDate, Date endDate,
                          double basicPay, double transportAllowance, double housingAllowance) {
        super(id, createdDate, updatedDate, orgName, orgCode, rssbNumber, contactEmail,
              deptName, deptCode, managerName, employeeID, fullName, position, baseSalary, rssbRegistered,
              month, year, startDate, endDate);
        
        if (basicPay < 0 || transportAllowance < 0 || housingAllowance < 0) {
            throw new IllegalArgumentException("Salary components cannot be negative");
        }
        
        this.basicPay = basicPay;
        this.transportAllowance = transportAllowance;
        this.housingAllowance = housingAllowance;
    }
    
    public double getBasicPay() { return basicPay; }
    public double getTransportAllowance() { return transportAllowance; }
    public double getHousingAllowance() { return housingAllowance; }
    
    public void setBasicPay(double basicPay) {
        if (basicPay < 0) {
            throw new IllegalArgumentException("Basic pay cannot be negative");
        }
        this.basicPay = basicPay;
    }
    
    public void setTransportAllowance(double transportAllowance) {
        if (transportAllowance < 0) {
            throw new IllegalArgumentException("Transport allowance cannot be negative");
        }
        this.transportAllowance = transportAllowance;
    }
    
    public void setHousingAllowance(double housingAllowance) {
        if (housingAllowance < 0) {
            throw new IllegalArgumentException("Housing allowance cannot be negative");
        }
        this.housingAllowance = housingAllowance;
    }
    
    public double getTotalAllowances() {
        return transportAllowance + housingAllowance;
    }
    
    public double getGrossSalary() {
        return basicPay + getTotalAllowances();
    }
}
