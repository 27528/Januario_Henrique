package Januario_Henrique.27528.q4;

import java.util.Date;

public class Product extends Supplier {
    private String productName;
    private double unitPrice;
    private int quantity;
    
    public Product(int id, Date createdDate, Date updatedDate,
                  String orgName, String address, String contactEmail,
                  String deptName, String deptCode,
                  String supplierName, String supplierTIN, String contact,
                  String productName, double unitPrice, int quantity) {
        super(id, createdDate, updatedDate, orgName, address, contactEmail,
              deptName, deptCode, supplierName, supplierTIN, contact);
        
        if (unitPrice <= 0) {
            throw new IllegalArgumentException("Unit price must be greater than 0");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }
    
    public String getProductName() { return productName; }
    public double getUnitPrice() { return unitPrice; }
    public int getQuantity() { return quantity; }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public void setUnitPrice(double unitPrice) {
        if (unitPrice <= 0) {
            throw new IllegalArgumentException("Unit price must be greater than 0");
        }
        this.unitPrice = unitPrice;
    }
    
    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity;
    }
    
    public double getTotalValue() {
        return unitPrice * quantity;
    }
}