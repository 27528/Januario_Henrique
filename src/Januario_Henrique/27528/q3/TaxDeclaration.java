package Januario_Henrique.27528.q3;

import java.util.Date;

public class TaxDeclaration extends Employee {
    private String declarationMonth;
    private double totalIncome;
    
    public TaxDeclaration(int id, Date createdDate, Date updatedDate,
                         String authorityName, String region, String email,
                         String categoryName, double rate, String code,
                         String tin, String taxpayerName, String address,
                         String employerName, String employerTIN, String contact,
                         String employeeName, double salary, String employeeEmployerTIN,
                         String declarationMonth, double totalIncome) {
        super(id, createdDate, updatedDate, authorityName, region, email,
              categoryName, rate, code, tin, taxpayerName, address,
              employerName, employerTIN, contact, employeeName, salary, employeeEmployerTIN);
        
        if (totalIncome < 0) {
            throw new IllegalArgumentException("Total income cannot be negative");
        }
        
        this.declarationMonth = declarationMonth;
        this.totalIncome = totalIncome;
    }
    
    public String getDeclarationMonth() { return declarationMonth; }
    public double getTotalIncome() { return totalIncome; }
    
    public void setDeclarationMonth(String declarationMonth) {
        this.declarationMonth = declarationMonth;
    }
    
    public void setTotalIncome(double totalIncome) {
        if (totalIncome < 0) {
            throw new IllegalArgumentException("Total income cannot be negative");
        }
        this.totalIncome = totalIncome;
    }
    
    public double getTaxableIncome() {
        double basicExemption = 1200000; // Basic annual exemption
        double annualIncome = totalIncome * 12;
        return Math.max(0, annualIncome - basicExemption);
    }
}