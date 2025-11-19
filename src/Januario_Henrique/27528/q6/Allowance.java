package Januario_Henrique.27528.q6;

import java.util.Date;

public class Allowance extends Deduction {
    private double overtimeHours;
    private double overtimeRate;
    private double bonus;
    
    public Allowance(int id, Date createdDate, Date updatedDate,
                    String orgName, String orgCode, String rssbNumber, String contactEmail,
                    String deptName, String deptCode, String managerName,
                    String employeeID, String fullName, String position, double baseSalary, boolean rssbRegistered,
                    int month, int year, Date startDate, Date endDate,
                    double basicPay, double transportAllowance, double housingAllowance,
                    double rssbContribution, double payeTax, double loanDeduction,
                    double overtimeHours, double overtimeRate, double bonus) {
        super(id, createdDate, updatedDate, orgName, orgCode, rssbNumber, contactEmail,
              deptName, deptCode, managerName, employeeID, fullName, position, baseSalary, rssbRegistered,
              month, year, startDate, endDate, basicPay, transportAllowance, housingAllowance,
              rssbContribution, payeTax, loanDeduction);
        
        if (overtimeHours < 0 || overtimeRate < 0 || bonus < 0) {
            throw new IllegalArgumentException("Allowance components cannot be negative");
        }
        
        this.overtimeHours = overtimeHours;
        this.overtimeRate = overtimeRate;
        this.bonus = bonus;
    }
    
    public double getOvertimeHours() { return overtimeHours; }
    public double getOvertimeRate() { return overtimeRate; }
    public double getBonus() { return bonus; }
    
    public void setOvertimeHours(double overtimeHours) {
        if (overtimeHours < 0) {
            throw new IllegalArgumentException("Overtime hours cannot be negative");
        }
        this.overtimeHours = overtimeHours;
    }
    
    public void setOvertimeRate(double overtimeRate) {
        if (overtimeRate < 0) {
            throw new IllegalArgumentException("Overtime rate cannot be negative");
        }
        this.overtimeRate = overtimeRate;
    }
    
    public void setBonus(double bonus) {
        if (bonus < 0) {
            throw new IllegalArgumentException("Bonus cannot be negative");
        }
        this.bonus = bonus;
    }
    
    public double getOvertimePay() {
        return overtimeHours * overtimeRate;
    }
    
    public double getTotalAdditionalEarnings() {
        return getOvertimePay() + bonus;
    }
}