package Januario_Henrique.27528.q4;

import java.util.Date;
import java.text.SimpleDateFormat;

public final class ProcurementReport extends Invoice {
    private static final String STUDENT_ID = "27528";
    
    private Date reportDate;
    private String summary;
    
    public ProcurementReport(int id, Date createdDate, Date updatedDate,
                            String orgName, String address, String contactEmail,
                            String deptName, String deptCode,
                            String supplierName, String supplierTIN, String contact,
                            String productName, double unitPrice, int quantity,
                            String poNumber, Date orderDate, double totalAmount,
                            Date deliveryDate, String deliveredBy,
                            String inspectionName, String status, String remarks,
                            String invoiceNo, double invoiceAmount,
                            Date reportDate, String summary) {
        super(id, createdDate, updatedDate, orgName, address, contactEmail,
              deptName, deptCode, supplierName, supplierTIN, contact,
              productName, unitPrice, quantity, poNumber, orderDate, totalAmount,
              deliveryDate, deliveredBy, inspectionName, status, remarks,
              invoiceNo, invoiceAmount);
        
        this.reportDate = reportDate;
        this.summary = summary;
    }
    
    public Date getReportDate() { return reportDate; }
    public String getSummary() { return summary; }
    
    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }
    
    public void setSummary(String summary) {
        this.summary = summary;
    }
    
    // FINAL METHOD: calculateTotal() = sum of all invoice amounts
    public void calculateTotal() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        StringBuilder output = new StringBuilder();
        
        // STUDENT ID CONCATENATION AT BEGINNING
        output.append("STUDENT ID: ").append(STUDENT_ID).append("\n");
        output.append("╔══════════════════════════════════════════════╗\n");
        output.append("║           PROCUREMENT MANAGEMENT SYSTEM      ║\n");
        output.append("╚══════════════════════════════════════════════╝\n\n");
        
        output.append("Report Date: ").append(dateFormat.format(reportDate)).append("\n");
        output.append("Summary: ").append(summary != null ? summary : "N/A").append("\n\n");
        
        output.append("=== PROCUREMENT OVERVIEW ===\n");
        output.append("Organization: ").append(getOrgName()).append("\n");
        output.append("Department: ").append(getDeptName()).append(" (").append(getDeptCode()).append(")\n");
        output.append("Address: ").append(getAddress()).append("\n");
        output.append("Contact: ").append(getContactEmail()).append("\n\n");
        
        output.append("--- Supplier Information ---\n");
        output.append("Supplier: ").append(getSupplierName()).append("\n");
        output.append("Supplier TIN: ").append(getSupplierTIN()).append("\n");
        output.append("Contact: ").append(getContact()).append("\n\n");
        
        output.append("--- Product Details ---\n");
        output.append("Product: ").append(getProductName()).append("\n");
        output.append("Unit Price: $").append(getUnitPrice()).append("\n");
        output.append("Quantity: ").append(getQuantity()).append("\n");
        output.append("Product Value: $").append(String.format("%.2f", getTotalValue())).append("\n\n");
        
        output.append("--- Purchase Order ---\n");
        output.append("PO Number: ").append(getPoNumber()).append("\n");
        output.append("Order Date: ").append(dateFormat.format(getOrderDate())).append("\n");
        output.append("PO Amount: $").append(String.format("%.2f", getTotalAmount())).append("\n");
        output.append("Variance: $").append(String.format("%.2f", getVariance())).append("\n\n");
        
        output.append("--- Delivery Information ---\n");
        output.append("Delivery Date: ").append(dateFormat.format(getDeliveryDate())).append("\n");
        output.append("Delivered By: ").append(getDeliveredBy()).append("\n");
        output.append("Delivery Days: ").append(getDeliveryDays()).append(" days\n\n");
        
        output.append("--- Inspection Results ---\n");
        output.append("Inspection: ").append(getInspectionName()).append("\n");
        output.append("Status: ").append(getStatus()).append("\n");
        output.append("Remarks: ").append(getRemarks() != null ? getRemarks() : "N/A").append("\n");
        output.append("Accepted: ").append(isAccepted() ? "YES" : "NO").append("\n\n");
        
        output.append("--- Invoice & Payment ---\n");
        output.append("Invoice No: ").append(getInvoiceNo()).append("\n");
        output.append("Invoice Amount: $").append(String.format("%.2f", getInvoiceAmount())).append("\n");
        output.append("Payment Difference: $").append(String.format("%.2f", getPaymentDifference())).append("\n");
        output.append("Payment Status: ").append(isFullyPaid() ? "FULLY PAID" : "PENDING").append("\n\n");
        
        output.append("=== FINANCIAL SUMMARY ===\n");
        output.append("Total Product Value: $").append(String.format("%.2f", getTotalValue())).append("\n");
        output.append("Total PO Amount: $").append(String.format("%.2f", getTotalAmount())).append("\n");
        output.append("Total Invoice Amount: $").append(String.format("%.2f", getInvoiceAmount())).append("\n");
        output.append("Overall Variance: $").append(String.format("%.2f", getInvoiceAmount() - getTotalValue())).append("\n\n");
        
        output.append("--- Performance Metrics ---\n");
        double deliveryEfficiency = getDeliveryDays() <= 7 ? 100.0 : 
                                  Math.max(0, 100 - ((getDeliveryDays() - 7) * 5));
        output.append(String.format("Delivery Efficiency: %.1f%%\n", deliveryEfficiency));
        output.append("Inspection Result: ").append(isAccepted() ? "PASS" : "FAIL").append("\n");
        output.append("Financial Accuracy: ").append(Math.abs(getVariance()) < 100 ? "GOOD" : "REVIEW NEEDED").append("\n\n");
        
        output.append("--- System Information ---\n");
        output.append("Created: ").append(dateFormat.format(getCreatedDate())).append("\n");
        output.append("Last Updated: ").append(dateFormat.format(getUpdatedDate())).append("\n");
        output.append("==========================================\n");
        
        System.out.println(output.toString());
        saveProcurementReport(output.toString());
    }
    
    private void saveProcurementReport(String content) {
        String filename = STUDENT_ID + "_procurement_report.txt";
        try (java.io.PrintWriter writer = new java.io.PrintWriter(filename)) {
            writer.println(content);
            System.out.println("Procurement report saved as: " + filename);
        } catch (java.io.FileNotFoundException e) {
            System.err.println("Error saving procurement report: " + e.getMessage());
        }
    }
    
    // Overloaded method for quick calculation
    public double calculateTotal(boolean detailed) {
        if (!detailed) {
            return getInvoiceAmount();
        }
        calculateTotal();
        return getInvoiceAmount();
    }
}