package Januario_Henrique.27528.q6;

import java.util.Date;

public class Deduction extends SalaryStructure {
    private double rssbContribution;
    private double payeTax;
    private double loanDeduction;
    
    public Deduction(int id, Date createdDate, Date updatedDate,
                    String orgName, String orgCode, String rssbNumber, String contactEmail,
                    String deptName, String deptCode, String managerName,
                    String employeeID, String fullName, String position, double baseSalary, boolean rssbRegistered,
                    int month, int year, Date startDate, Date endDate,
                    double basicPay, double transportAllowance, double housingAllowance,
                    double rssbContribution, double payeTax, double loanDeduction) {
        super(id, createdDate, updatedDate, orgName, orgCode, rssbNumber, contactEmail,
              deptName, deptCode, managerName, employeeID, fullName, position, baseSalary, rssbRegistered,
              month, year, startDate, endDate, basicPay, transportAllowance, housingAllowance);
        
        if (rssbContribution < 0 || payeTax < 0 || loanDeduction < 0) {
            throw new IllegalArgumentException("Deductions cannot be negative");
        }
        
        this.rssbContribution = rssbContribution;
        this.payeTax = payeTax;
        this.loanDeduction = loanDeduction;
    }
    
    public double getRssbContribution() { return rssbContribution; }
    public double getPayeTax() { return payeTax; }
    public double getLoanDeduction() { return loanDeduction; }
    
    public void setRssbContribution(double rssbContribution) {
        if (rssbContribution < 0) {
            throw new IllegalArgumentException("RSSB contribution cannot be negative");
        }
        this.rssbContribution = rssbContribution;
    }
    
    public void setPayeTax(double payeTax) {
        if (payeTax < 0) {
            throw new IllegalArgumentException("PAYE tax cannot be negative");
        }
        this.payeTax = payeTax;
    }
    
    public void setLoanDeduction(double loanDeduction) {
        if (loanDeduction < 0) {
            throw new IllegalArgumentException("Loan deduction cannot be negative");
        }
        this.loanDeduction = loanDeduction;
    }
    
    public double getTotalDeductions() {
        return rssbContribution + payeTax + loanDeduction;
    }
    
    public double calculateRssbContribution() {
        return isRssbRegistered() ? getBasicPay() * 0.05 : 0.0;
    }
}