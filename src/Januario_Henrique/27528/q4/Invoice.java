package Januario_Henrique.27528.q4;

import java.util.Date;

public class Invoice extends Inspection {
    private String invoiceNo;
    private double invoiceAmount;
    
    public Invoice(int id, Date createdDate, Date updatedDate,
                  String orgName, String address, String contactEmail,
                  String deptName, String deptCode,
                  String supplierName, String supplierTIN, String contact,
                  String productName, double unitPrice, int quantity,
                  String poNumber, Date orderDate, double totalAmount,
                  Date deliveryDate, String deliveredBy,
                  String inspectionName, String status, String remarks,
                  String invoiceNo, double invoiceAmount) {
        super(id, createdDate, updatedDate, orgName, address, contactEmail,
              deptName, deptCode, supplierName, supplierTIN, contact,
              productName, unitPrice, quantity, poNumber, orderDate, totalAmount,
              deliveryDate, deliveredBy, inspectionName, status, remarks);
        
        if (invoiceAmount <= 0) {
            throw new IllegalArgumentException("Invoice amount must be greater than 0");
        }
        
        this.invoiceNo = invoiceNo;
        this.invoiceAmount = invoiceAmount;
    }
    
    public String getInvoiceNo() { return invoiceNo; }
    public double getInvoiceAmount() { return invoiceAmount; }
    
    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }
    
    public void setInvoiceAmount(double invoiceAmount) {
        if (invoiceAmount <= 0) {
            throw new IllegalArgumentException("Invoice amount must be greater than 0");
        }
        this.invoiceAmount = invoiceAmount;
    }
    
    public double getPaymentDifference() {
        return invoiceAmount - getTotalAmount();
    }
    
    public boolean isFullyPaid() {
        return Math.abs(getPaymentDifference()) < 0.01; // Account for floating point precision
    }
}