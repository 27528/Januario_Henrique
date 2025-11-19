package Januario_Henrique.27528.q1;

import java.util.Date;

public class Sale extends Purchase {
    private Date saleDate;
    private int soldQuantity;
    private String customerName;
    
    public Sale(int id, Date createdDate, Date updatedDate,
                String warehouseName, String location, String contactNumber,
                String categoryName, String categoryCode,
                String supplierName, String supplierEmail, String supplierPhone,
                String productName, double unitPrice, int stockLimit,
                int quantityAvailable, int reorderLevel,
                Date purchaseDate, int purchasedQuantity, String purchaseSupplierName,
                Date saleDate, int soldQuantity, String customerName) {
        super(id, createdDate, updatedDate, warehouseName, location, contactNumber,
              categoryName, categoryCode, supplierName, supplierEmail, supplierPhone,
              productName, unitPrice, stockLimit, quantityAvailable, reorderLevel,
              purchaseDate, purchasedQuantity, purchaseSupplierName);
        
        if (saleDate == null) {
            throw new IllegalArgumentException("Sale date cannot be null");
        }
        if (soldQuantity <= 0) {
            throw new IllegalArgumentException("Sold quantity must be greater than 0");
        }
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be empty");
        }
        
        this.saleDate = saleDate;
        this.soldQuantity = soldQuantity;
        this.customerName = customerName;
    }
    
    public Date getSaleDate() { return saleDate; }
    public int getSoldQuantity() { return soldQuantity; }
    public String getCustomerName() { return customerName; }
    
    public void setSaleDate(Date saleDate) {
        if (saleDate == null) {
            throw new IllegalArgumentException("Sale date cannot be null");
        }
        this.saleDate = saleDate;
    }
    
    public void setSoldQuantity(int soldQuantity) {
        if (soldQuantity <= 0) {
            throw new IllegalArgumentException("Sold quantity must be greater than 0");
        }
        this.soldQuantity = soldQuantity;
    }
    
    public void setCustomerName(String customerName) {
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be empty");
        }
        this.customerName = customerName;
    }
    
    public double getSaleTotal() {
        return soldQuantity * getUnitPrice();
    }
}