package Januario_Henrique.27528.q1;

import java.util.Date;

public class Category extends Warehouse {
    private String categoryName;
    private String categoryCode;
    
    public Category(int id, Date createdDate, Date updatedDate,
                   String warehouseName, String location, String contactNumber,
                   String categoryName, String categoryCode) {
        super(id, createdDate, updatedDate, warehouseName, location, contactNumber);
        
        if (categoryCode == null || categoryCode.length() < 3 || 
            !categoryCode.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("Category code must be alphanumeric and ≥ 3 characters");
        }
        
        this.categoryName = categoryName;
        this.categoryCode = categoryCode;
    }
    
    public String getCategoryName() { return categoryName; }
    public String getCategoryCode() { return categoryCode; }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    public void setCategoryCode(String categoryCode) {
        if (categoryCode == null || categoryCode.length() < 3 || 
            !categoryCode.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("Category code must be alphanumeric and ≥ 3 characters");
        }
        this.categoryCode = categoryCode;
    }
}