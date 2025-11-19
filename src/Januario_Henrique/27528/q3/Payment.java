package Januario_Henrique.27528.q3;

import java.util.Date;

public class Payment extends TaxAssessment {
    private Date paymentDate;
    private double paymentAmount;
    
    public Payment(int id, Date createdDate, Date updatedDate,
                  String authorityName, String region, String email,
                  String categoryName, double rate, String code,
                  String tin, String taxpayerName, String address,
                  String employerName, String employerTIN, String contact,
                  String employeeName, double salary, String employeeEmployerTIN,
                  String declarationMonth, double totalIncome,
                  Date assessmentDate, double assessedTax,
                  Date paymentDate, double paymentAmount) {
        super(id, createdDate, updatedDate, authorityName, region, email,
              categoryName, rate, code, tin, taxpayerName, address,
              employerName, employerTIN, contact, employeeName, salary, employeeEmployerTIN,
              declarationMonth, totalIncome, assessmentDate, assessedTax);
        
        if (paymentAmount <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than 0");
        }
        
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
    }
    
    public Date getPaymentDate() { return paymentDate; }
    public double getPaymentAmount() { return paymentAmount; }
    
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
    
    public void setPaymentAmount(double paymentAmount) {
        if (paymentAmount <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than 0");
        }
        this.paymentAmount = paymentAmount;
    }
    
    public double getRemainingBalance() {
        return getAssessedTax() - paymentAmount;
    }
    
    public boolean isPaymentComplete() {
        return getRemainingBalance() <= 0;
    }
}