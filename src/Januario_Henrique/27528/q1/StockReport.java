package Januario_Henrique.27528.q1;

import java.util.Date;
import java.text.SimpleDateFormat;

public final class StockReport extends Inventory {
    private static final String STUDENT_ID = "27528";
    
    private Date reportDate;
    private String remarks;
    
    public StockReport(int id, Date createdDate, Date updatedDate,
                       String warehouseName, String location, String contactNumber,
                       String categoryName, String categoryCode,
                       String supplierName, String supplierEmail, String supplierPhone,
                       String productName, double unitPrice, int stockLimit,
                       int quantityAvailable, int reorderLevel,
                       Date purchaseDate, int purchasedQuantity, String purchaseSupplierName,
                       Date saleDate, int soldQuantity, String customerName,
                       int totalItems, double stockValue,
                       Date reportDate, String remarks) {
        super(id, createdDate, updatedDate, warehouseName, location, contactNumber,
              categoryName, categoryCode, supplierName, supplierEmail, supplierPhone,
              productName, unitPrice, stockLimit, quantityAvailable, reorderLevel,
              purchaseDate, purchasedQuantity, purchaseSupplierName,
              saleDate, soldQuantity, customerName, totalItems, stockValue);
        
        if (reportDate == null) {
            throw new IllegalArgumentException("Report date cannot be null");
        }
        
        this.reportDate = reportDate;
        this.remarks = remarks;
    }
    
    public Date getReportDate() { return reportDate; }
    public String getRemarks() { return remarks; }
    
    public void setReportDate(Date reportDate) {
        if (reportDate == null) {
            throw new IllegalArgumentException("Report date cannot be null");
        }
        this.reportDate = reportDate;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    // FINAL METHOD: generateReport() = summarizes total stock and sales
    public void generateReport() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        StringBuilder output = new StringBuilder();
        
        // STUDENT ID CONCATENATION AT BEGINNING
        output.append("STUDENT ID: ").append(STUDENT_ID).append("\n");
        output.append("╔══════════════════════════════════════════════╗\n");
        output.append("║           STOCK MANAGEMENT SYSTEM            ║\n");
        output.append("╚══════════════════════════════════════════════╝\n\n");
        
        output.append("Report Date: ").append(dateFormat.format(reportDate)).append("\n");
        output.append("Remarks: ").append(remarks != null ? remarks : "N/A").append("\n\n");
        
        output.append("--- Warehouse Information ---\n");
        output.append("Warehouse: ").append(getWarehouseName()).append("\n");
        output.append("Location: ").append(getLocation()).append("\n");
        output.append("Contact: ").append(getContactNumber()).append("\n\n");
        
        output.append("--- Product Information ---\n");
        output.append("Category: ").append(getCategoryName()).append(" (").append(getCategoryCode()).append(")\n");
        output.append("Product: ").append(getProductName()).append("\n");
        output.append("Supplier: ").append(getSupplierName()).append("\n");
        output.append("Unit Price: $").append(getUnitPrice()).append("\n\n");
        
        output.append("--- Stock Details ---\n");
        output.append("Quantity Available: ").append(getQuantityAvailable()).append("\n");
        output.append("Reorder Level: ").append(getReorderLevel()).append("\n");
        output.append("Stock Limit: ").append(getStockLimit()).append("\n");
        output.append("Needs Reorder: ").append(needsReorder() ? "YES" : "NO").append("\n\n");
        
        output.append("--- Transaction Summary ---\n");
        output.append("Purchased Quantity: ").append(getPurchasedQuantity()).append("\n");
        output.append("Purchase Total: $").append(String.format("%.2f", getPurchaseTotal())).append("\n");
        output.append("Purchase Supplier: ").append(getSupplierName()).append("\n");
        output.append("Sold Quantity: ").append(getSoldQuantity()).append("\n");
        output.append("Sales Total: $").append(String.format("%.2f", getSaleTotal())).append("\n");
        output.append("Customer: ").append(getCustomerName()).append("\n\n");
        
        output.append("--- Inventory Overview ---\n");
        output.append("Total Items: ").append(getTotalItems()).append("\n");
        output.append("Stock Value: $").append(String.format("%.2f", getStockValue())).append("\n");
        output.append("Average Item Value: $").append(String.format("%.2f", getAverageItemValue())).append("\n\n");
        
        output.append("--- Performance Metrics ---\n");
        double turnoverRate = getSoldQuantity() > 0 ? (double) getSoldQuantity() / getPurchasedQuantity() * 100 : 0;
        output.append(String.format("Stock Turnover Rate: %.1f%%\n", turnoverRate));
        output.append("Stock Availability: ").append(getQuantityAvailable() > 0 ? "IN STOCK" : "OUT OF STOCK").append("\n\n");
        
        output.append("--- System Metadata ---\n");
        output.append("Created: ").append(dateFormat.format(getCreatedDate())).append("\n");
        output.append("Last Updated: ").append(dateFormat.format(getUpdatedDate())).append("\n");
        output.append("=====================================\n");
        
        System.out.println(output.toString());
        saveReportToFile(output.toString());
    }
    
    private void saveReportToFile(String content) {
        String filename = STUDENT_ID + "_stock_report.txt";
        try (java.io.PrintWriter writer = new java.io.PrintWriter(filename)) {
            writer.println(content);
            System.out.println("Stock report saved as: " + filename);
        } catch (java.io.FileNotFoundException e) {
            System.err.println("Error saving report: " + e.getMessage());
        }
    }
    
    // Overloaded method for quick reporting
    public void generateReport(boolean includeDetails) {
        if (includeDetails) {
            generateReport();
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            StringBuilder quickOutput = new StringBuilder();
            
            quickOutput.append("STUDENT ID: ").append(STUDENT_ID).append("\n");
            quickOutput.append("=== QUICK STOCK SUMMARY ===\n");
            quickOutput.append("Date: ").append(dateFormat.format(reportDate)).append("\n");
            quickOutput.append("Product: ").append(getProductName()).append("\n");
            quickOutput.append("Available: ").append(getQuantityAvailable()).append("/").append(getStockLimit()).append("\n");
            quickOutput.append("Stock Value: $").append(String.format("%.2f", getStockValue())).append("\n");
            quickOutput.append("Status: ").append(needsReorder() ? "NEEDS REORDER" : "OK").append("\n");
            
            System.out.println(quickOutput.toString());
        }
    }
}