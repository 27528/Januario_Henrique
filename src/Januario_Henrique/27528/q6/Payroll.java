package Januario_Henrique.27528.q6;

import java.util.Date;

public class Payroll extends Allowance {
    private double grossSalary;
    private double totalDeductions;
    private double netSalary;
    
    public Payroll(int id, Date createdDate, Date updatedDate,
                  String orgName, String orgCode, String rssbNumber, String contactEmail,
                  String deptName, String deptCode, String managerName,
                  String employeeID, String fullName, String position, double baseSalary, boolean rssbRegistered,
                  int month, int year, Date startDate, Date endDate,
                  double basicPay, double transportAllowance, double housingAllowance,
                  double rssbContribution, double payeTax, double loanDeduction,
                  double overtimeHours, double overtimeRate, double bonus,
                  double grossSalary, double totalDeductions, double netSalary) {
        super(id, createdDate, updatedDate, orgName, orgCode, rssbNumber, contactEmail,
              deptName, deptCode, managerName, employeeID, fullName, position, baseSalary, rssbRegistered,
              month, year, startDate, endDate, basicPay, transportAllowance, housingAllowance,
              rssbContribution, payeTax, loanDeduction, overtimeHours, overtimeRate, bonus);
        
        this.grossSalary = grossSalary;
        this.totalDeductions = totalDeductions;
        this.netSalary = netSalary;
    }
    
    public double getGrossSalary() { return grossSalary; }
    public double getTotalDeductions() { return totalDeductions; }
    public double getNetSalary() { return netSalary; }
    
    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }
    
    public void setTotalDeductions(double totalDeductions) {
        this.totalDeductions = totalDeductions;
    }
    
    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }
    
    public double calculateGrossSalary() {
        return getBasicPay() + getTotalAllowances() + getTotalAdditionalEarnings();
    }
    
    public double calculateNetSalary() {
        return calculateGrossSalary() - getTotalDeductions();
    }
    
    public boolean isSalaryCalculationValid() {
        double calculatedGross = calculateGrossSalary();
        double calculatedNet = calculateNetSalary();
        return Math.abs(calculatedGross - grossSalary) < 0.01 && 
               Math.abs(calculatedNet - netSalary) < 0.01;
    }
}