package Januario_Henrique.27528.q3;

import java.util.Date;
import java.text.SimpleDateFormat;

public final class TaxRecord extends Payment {
    private static final String STUDENT_ID = "27528";
    
    private String receiptNo;
    private double totalTax;
    
    public TaxRecord(int id, Date createdDate, Date updatedDate,
                    String authorityName, String region, String email,
                    String categoryName, double rate, String code,
                    String tin, String taxpayerName, String address,
                    String employerName, String employerTIN, String contact,
                    String employeeName, double salary, String employeeEmployerTIN,
                    String declarationMonth, double totalIncome,
                    Date assessmentDate, double assessedTax,
                    Date paymentDate, double paymentAmount,
                    String receiptNo, double totalTax) {
        super(id, createdDate, updatedDate, authorityName, region, email,
              categoryName, rate, code, tin, taxpayerName, address,
              employerName, employerTIN, contact, employeeName, salary, employeeEmployerTIN,
              declarationMonth, totalIncome, assessmentDate, assessedTax,
              paymentDate, paymentAmount);
        
        this.receiptNo = receiptNo;
        this.totalTax = totalTax;
    }
    
    public String getReceiptNo() { return receiptNo; }
    public double getTotalTax() { return totalTax; }
    
    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }
    
    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }
    
    
    public void computeTax() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        StringBuilder output = new StringBuilder();
        
        
        output.append("STUDENT ID: ").append(STUDENT_ID).append("\n");
        output.append("╔══════════════════════════════════════════════╗\n");
        output.append("║           TAX ADMINISTRATION SYSTEM          ║\n");
        output.append("╚══════════════════════════════════════════════╝\n\n");
        
        
        double annualSalary = getSalary() * 12;
        double basicExemption = 1200000; 
        double taxableIncome = Math.max(0, annualSalary - basicExemption);
        double taxCredits = calculateTaxCredits();
        double computedTax = (taxableIncome * getRate()) - taxCredits;
        
        output.append("=== TAX COMPUTATION DETAILS ===\n");
        output.append("Receipt Number: ").append(receiptNo).append("\n");
        output.append("Taxpayer: ").append(getTaxpayerName()).append("\n");
        output.append("TIN: ").append(getTin()).append("\n");
        output.append("Declaration Month: ").append(getDeclarationMonth()).append("\n\n");
        
        output.append("--- Income Details ---\n");
        output.append(String.format("Monthly Salary:    Frw %.2f\n", getSalary()));
        output.append(String.format("Annual Salary:     Frw %.2f\n", annualSalary));
        output.append(String.format("Basic Exemption:   Frw %.2f\n", basicExemption));
        output.append(String.format("Taxable Income:    Frw %.2f\n\n", taxableIncome));
        
        output.append("--- Tax Calculation ---\n");
        output.append(String.format("Tax Rate:          %.1f%%\n", getRate() * 100));
        output.append(String.format("Tax Before Credits:Frw %.2f\n", taxableIncome * getRate()));
        output.append(String.format("Tax Credits:       Frw %.2f\n", taxCredits));
        output.append("─────────────────────────────────\n");
        output.append(String.format("COMPUTED TAX:      Frw %.2f\n\n", computedTax));
        
        output.append("--- Employer Information ---\n");
        output.append("Employer: ").append(getEmployerName()).append("\n");
        output.append("Employer TIN: ").append(getEmployerTIN()).append("\n");
        output.append("Employee: ").append(getEmployeeName()).append("\n\n");
        
        output.append("--- Assessment & Payment ---\n");
        output.append(String.format("Assessed Tax:      Frw %.2f\n", getAssessedTax()));
        output.append(String.format("Amount Paid:       Frw %.2f\n", getPaymentAmount()));
        output.append(String.format("Remaining Balance: Frw %.2f\n", getRemainingBalance()));
        output.append("Payment Status: ").append(isPaymentComplete() ? "COMPLETE" : "PENDING").append("\n");
        output.append("Assessment: ").append(isTaxUnderpaid() ? "UNDERPAID" : "CORRECT").append("\n\n");
        
        output.append("--- Tax Authority ---\n");
        output.append("Authority: ").append(getAuthorityName()).append("\n");
        output.append("Region: ").append(getRegion()).append("\n");
        output.append("Category: ").append(getCategoryName()).append(" (").append(getCode()).append(")\n\n");
        
        output.append("Record Created: ").append(dateFormat.format(getCreatedDate())).append("\n");
        output.append("Last Updated: ").append(dateFormat.format(getUpdatedDate())).append("\n");
        
        System.out.println(output.toString());
        saveTaxRecordToFile(output.toString());
    }
    
    private double calculateTaxCredits() {
        double credits = 0.0;
        
        
        credits += 96000; 
        
        credits += 2 * 60000; 
        
        
        credits += 50000;
        
        return credits;
    }
    
    private void saveTaxRecordToFile(String content) {
        String filename = STUDENT_ID + "_tax_record.txt";
        try (java.io.PrintWriter writer = new java.io.PrintWriter(filename)) {
            writer.println(content);
            System.out.println("Tax record saved as: " + filename);
        } catch (java.io.FileNotFoundException e) {
            System.err.println("Error saving tax record: " + e.getMessage());
        }
    }
    
    
    public double computeTax(boolean detailed) {
        if (!detailed) {
            double annualSalary = getSalary() * 12;
            double basicExemption = 1200000;
            double taxableIncome = Math.max(0, annualSalary - basicExemption);
            double taxCredits = calculateTaxCredits();
            return (taxableIncome * getRate()) - taxCredits;
        }
        computeTax();
        return 0.0;
    }
}
