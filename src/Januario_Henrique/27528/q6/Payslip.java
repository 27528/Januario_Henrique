ppackage Januario_Henrique.27528.q6;

import java.util.Date;
import java.text.SimpleDateFormat;

public final class Payslip extends Payroll {
    private static final String STUDENT_ID = "27528";
    
    private String payslipNumber;
    private Date issueDate;
    
    public Payslip(int id, Date createdDate, Date updatedDate,
                  String orgName, String orgCode, String rssbNumber, String contactEmail,
                  String deptName, String deptCode, String managerName,
                  String employeeID, String fullName, String position, double baseSalary, boolean rssbRegistered,
                  int month, int year, Date startDate, Date endDate,
                  double basicPay, double transportAllowance, double housingAllowance,
                  double rssbContribution, double payeTax, double loanDeduction,
                  double overtimeHours, double overtimeRate, double bonus,
                  double grossSalary, double totalDeductions, double netSalary,
                  String payslipNumber, Date issueDate) {
        super(id, createdDate, updatedDate, orgName, orgCode, rssbNumber, contactEmail,
              deptName, deptCode, managerName, employeeID, fullName, position, baseSalary, rssbRegistered,
              month, year, startDate, endDate, basicPay, transportAllowance, housingAllowance,
              rssbContribution, payeTax, loanDeduction, overtimeHours, overtimeRate, bonus,
              grossSalary, totalDeductions, netSalary);
        
        this.payslipNumber = payslipNumber;
        this.issueDate = issueDate;
    }
    
    public String getPayslipNumber() { return payslipNumber; }
    public Date getIssueDate() { return issueDate; }
    
    public void setPayslipNumber(String payslipNumber) {
        this.payslipNumber = payslipNumber;
    }
    
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }
    
    // FINAL METHOD: generatePayslip() = compute RSSB + PAYE + Net Salary
    public void generatePayslip() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        StringBuilder output = new StringBuilder();
        
        // STUDENT ID CONCATENATION AT BEGINNING
        output.append("STUDENT ID: ").append(STUDENT_ID).append("\n");
        output.append("╔══════════════════════════════════════════════╗\n");
        output.append("║           PAYROLL MANAGEMENT SYSTEM (RSSB)  ║\n");
        output.append("╚══════════════════════════════════════════════╝\n\n");
        
        // Calculate actual values
        double actualRssb = calculateRssbContribution();
        double actualGross = calculateGrossSalary();
        double actualNet = calculateNetSalary();
        double actualPaye = calculatePAYETax(actualGross);
        
        output.append("Payslip Number: ").append(payslipNumber).append("\n");
        output.append("Issue Date: ").append(dateFormat.format(issueDate)).append("\n");
        output.append("Pay Period: ").append(getPeriodDescription()).append("\n");
        output.append("Start Date: ").append(dateFormat.format(getStartDate())).append(" | ");
        output.append("End Date: ").append(dateFormat.format(getEndDate())).append("\n\n");
        
        output.append("=== EMPLOYEE INFORMATION ===\n");
        output.append("Employee ID: ").append(getEmployeeID()).append("\n");
        output.append("Full Name: ").append(getFullName()).append("\n");
        output.append("Position: ").append(getPosition()).append("\n");
        output.append("Department: ").append(getDeptName()).append(" (").append(getDeptCode()).append(")\n");
        output.append("Manager: ").append(getManagerName()).append("\n");
        output.append("RSSB Registered: ").append(isRssbRegistered() ? "YES" : "NO").append("\n\n");
        
        output.append("=== ORGANIZATION DETAILS ===\n");
        output.append("Organization: ").append(getOrgName()).append(" (").append(getOrgCode()).append(")\n");
        output.append("RSSB Number: ").append(getRssbNumber()).append("\n");
        output.append("Contact: ").append(getContactEmail()).append("\n\n");
        
        output.append("=== EARNINGS BREAKDOWN ===\n");
        output.append(String.format("Basic Pay:           Frw %12.2f\n", getBasicPay()));
        output.append(String.format("Transport Allowance: Frw %12.2f\n", getTransportAllowance()));
        output.append(String.format("Housing Allowance:   Frw %12.2f\n", getHousingAllowance()));
        output.append(String.format("Total Allowances:    Frw %12.2f\n", getTotalAllowances()));
        output.append(String.format("Overtime Pay:        Frw %12.2f\n", getOvertimePay()));
        output.append(String.format("Bonus:               Frw %12.2f\n", getBonus()));
        output.append(String.format("Total Additions:     Frw %12.2f\n", getTotalAdditionalEarnings()));
        output.append("─────────────────────────────────────────────\n");
        output.append(String.format("GROSS SALARY:        Frw %12.2f\n", actualGross));
        output.append("\n");
        
        output.append("=== DEDUCTIONS BREAKDOWN ===\n");
        output.append(String.format("RSSB Contribution:   Frw %12.2f\n", actualRssb));
        output.append(String.format("PAYE Tax:            Frw %12.2f\n", actualPaye));
        output.append(String.format("Loan Deduction:      Frw %12.2f\n", getLoanDeduction()));
        output.append("─────────────────────────────────────────────\n");
        output.append(String.format("TOTAL DEDUCTIONS:    Frw %12.2f\n", getTotalDeductions()));
        output.append("\n");
        
        output.append("=== NET SALARY CALCULATION ===\n");
        output.append(String.format("Gross Salary:        Frw %12.2f\n", actualGross));
        output.append(String.format("Total Deductions:    Frw %12.2f\n", getTotalDeductions()));
        output.append("─────────────────────────────────────────────\n");
        output.append(String.format("NET SALARY:          Frw %12.2f\n", actualNet));
        output.append("\n");
        
        output.append("=== TAX AND CONTRIBUTION DETAILS ===\n");
        output.append(String.format("RSSB Rate:           5.0%% of Basic Pay\n"));
        output.append(String.format("RSSB Calculated:     Frw %.2f\n", actualRssb));
        output.append(String.format("PAYE Calculated:     Frw %.2f\n", actualPaye));
        output.append("RSSB Status: ").append(isRssbRegistered() ? "ACTIVE" : "NOT REGISTERED").append("\n\n");
        
        output.append("=== SUMMARY ===\n");
        output.append(String.format("Base Salary:         Frw %12.2f\n", getBaseSalary()));
        output.append(String.format("Annual Salary:       Frw %12.2f\n", getAnnualSalary()));
        output.append(String.format("Monthly Gross:       Frw %12.2f\n", actualGross));
        output.append(String.format("Monthly Net:         Frw %12.2f\n", actualNet));
        output.append(String.format("Tax Efficiency:      %.1f%%\n", (actualNet / actualGross) * 100));
        output.append("\n");
        
        output.append("=== VALIDATION ===\n");
        output.append("Calculation Valid: ").append(isSalaryCalculationValid() ? "YES" : "NO").append("\n");
        if (!isSalaryCalculationValid()) {
            output.append("⚠️  Warning: Calculated values differ from stored values!\n");
        }
        
        output.append("\n--- System Information ---\n");
        output.append("Payslip Created: ").append(dateFormat.format(getCreatedDate())).append("\n");
        output.append("Last Updated: ").append(dateFormat.format(getUpdatedDate())).append("\n");
        output.append("==========================================\n");
        
        System.out.println(output.toString());
        savePayslipToFile(output.toString());
    }
    
    private double calculatePAYETax(double grossSalary) {
        // Simplified PAYE tax calculation for Rwanda
        double annualSalary = grossSalary * 12;
        double tax = 0.0;
        
        if (annualSalary <= 360000) {
            tax = 0.0;
        } else if (annualSalary <= 720000) {
            tax = (annualSalary - 360000) * 0.20;
        } else {
            tax = 72000 + (annualSalary - 720000) * 0.30;
        }
        
        return tax / 12; // Monthly tax
    }
    
    private void savePayslipToFile(String content) {
        String filename = STUDENT_ID + "_payslip_" + payslipNumber + ".txt";
        try (java.io.PrintWriter writer = new java.io.PrintWriter(filename)) {
            writer.println(content);
            System.out.println("Payslip saved as: " + filename);
        } catch (java.io.FileNotFoundException e) {
            System.err.println("Error saving payslip: " + e.getMessage());
        }
    }
    
    // Overloaded method for quick payslip generation
    public void generatePayslip(boolean detailed) {
        if (!detailed) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            StringBuilder quickOutput = new StringBuilder();
            
            quickOutput.append("STUDENT ID: ").append(STUDENT_ID).append("\n");
            quickOutput.append("=== QUICK PAYSLIP SUMMARY ===\n");
            quickOutput.append("Payslip: ").append(payslipNumber).append(" | ").append(getPeriodDescription()).append("\n");
            quickOutput.append("Employee: ").append(getFullName()).append(" (").append(getEmployeeID()).append(")\n");
            quickOutput.append(String.format("Gross: Frw %.2f | Net: Frw %.2f\n", calculateGrossSalary(), calculateNetSalary()));
            quickOutput.append("RSSB: ").append(isRssbRegistered() ? "Yes" : "No").append("\n");
            
            System.out.println(quickOutput.toString());
        } else {
            generatePayslip();
        }
    }
}
