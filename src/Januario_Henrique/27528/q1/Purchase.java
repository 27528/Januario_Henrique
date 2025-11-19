package Januario_Henrique.27528.q1;

import java.util.Date;

public class Purchase extends StockItem {
    private Date purchaseDate;
    private int purchasedQuantity;
    private String supplierName;
    
    public Purchase(int id, Date createdDate, Date updatedDate,
                    String warehouseName, String location, String contactNumber,
                    String categoryName, String categoryCode,
                    String supplierName, String supplierEmail, String supplierPhone,
                    String productName, double unitPrice, int stockLimit,
                    int quantityAvailable, int reorderLevel,
                    Date purchaseDate, int purchasedQuantity, String purchaseSupplierName) {
        super(id, createdDate, updatedDate, warehouseName, location, contactNumber,
              categoryName, categoryCode, supplierName, supplierEmail, supplierPhone,
              productName, unitPrice, stockLimit, quantityAvailable, reorderLevel);
        
        if (purchaseDate == null) {
            throw new IllegalArgumentException("Purchase date cannot be null");
        }
        if (purchasedQuantity <= 0) {
            throw new IllegalArgumentException("Purchased quantity must be greater than 0");
        }
        if (purchaseSupplierName == null || purchaseSupplierName.trim().isEmpty()) {
            throw new IllegalArgumentException("Supplier name cannot be empty");
        }
        
        this.purchaseDate = purchaseDate;
        this.purchasedQuantity = purchasedQuantity;
        this.supplierName = purchaseSupplierName;
    }
    
    public Date getPurchaseDate() { return purchaseDate; }
    public int getPurchasedQuantity() { return purchasedQuantity; }
    public String getSupplierName() { return supplierName; }
    
    public void setPurchaseDate(Date purchaseDate) {
        if (purchaseDate == null) {
            throw new IllegalArgumentException("Purchase date cannot be null");
        }
        this.purchaseDate = purchaseDate;
    }
    
    public void setPurchasedQuantity(int purchasedQuantity) {
        if (purchasedQuantity <= 0) {
            throw new IllegalArgumentException("Purchased quantity must be greater than 0");
        }
        this.purchasedQuantity = purchasedQuantity;
    }
    
    public void setSupplierName(String supplierName) {
        if (supplierName == null || supplierName.trim().isEmpty()) {
            throw new IllegalArgumentException("Supplier name cannot be empty");
        }
        this.supplierName = supplierName;
    }
    
    public double getPurchaseTotal() {
        return purchasedQuantity * getUnitPrice();
    }
}