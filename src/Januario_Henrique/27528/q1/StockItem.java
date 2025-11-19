package Januario_Henrique.27528.q1;

import java.util.Date;

public class StockItem extends Product {
    private int quantityAvailable;
    private int reorderLevel;
    
    public StockItem(int id, Date createdDate, Date updatedDate,
                     String warehouseName, String location, String contactNumber,
                     String categoryName, String categoryCode,
                     String supplierName, String supplierEmail, String supplierPhone,
                     String productName, double unitPrice, int stockLimit,
                     int quantityAvailable, int reorderLevel) {
        super(id, createdDate, updatedDate, warehouseName, location, contactNumber,
              categoryName, categoryCode, supplierName, supplierEmail, supplierPhone,
              productName, unitPrice, stockLimit);
        
        if (quantityAvailable < 0) {
            throw new IllegalArgumentException("Quantity available cannot be negative");
        }
        if (reorderLevel < 0) {
            throw new IllegalArgumentException("Reorder level cannot be negative");
        }
        
        this.quantityAvailable = quantityAvailable;
        this.reorderLevel = reorderLevel;
    }
    
    public int getQuantityAvailable() { return quantityAvailable; }
    public int getReorderLevel() { return reorderLevel; }
    
    public void setQuantityAvailable(int quantityAvailable) {
        if (quantityAvailable < 0) {
            throw new IllegalArgumentException("Quantity available cannot be negative");
        }
        this.quantityAvailable = quantityAvailable;
    }
    
    public void setReorderLevel(int reorderLevel) {
        if (reorderLevel < 0) {
            throw new IllegalArgumentException("Reorder level cannot be negative");
        }
        this.reorderLevel = reorderLevel;
    }
    
    public boolean needsReorder() {
        return quantityAvailable <= reorderLevel;
    }
}