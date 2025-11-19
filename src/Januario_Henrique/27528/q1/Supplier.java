
package Januario_Henrique.27528.q1;

import java.util.Date;
import java.util.regex.Pattern;

public class Supplier extends Category {
    private String supplierName;
    private String supplierEmail;
    private String supplierPhone;
    
    public Supplier(int id, Date createdDate, Date updatedDate,
                   String warehouseName, String location, String contactNumber,
                   String categoryName, String categoryCode,
                   String supplierName, String supplierEmail, String supplierPhone) {
        super(id, createdDate, updatedDate, warehouseName, location, contactNumber, 
              categoryName, categoryCode);
        
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!Pattern.matches(emailRegex, supplierEmail)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        
        if (!supplierPhone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Supplier phone must be 10 digits");
        }
        
        this.supplierName = supplierName;
        this.supplierEmail = supplierEmail;
        this.supplierPhone = supplierPhone;
    }
    
    public String getSupplierName() { return supplierName; }
    public String getSupplierEmail() { return supplierEmail; }
    public String getSupplierPhone() { return supplierPhone; }
    
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
    
    public void setSupplierEmail(String supplierEmail) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!Pattern.matches(emailRegex, supplierEmail)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.supplierEmail = supplierEmail;
    }
    
    public void setSupplierPhone(String supplierPhone) {
        if (!supplierPhone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Supplier phone must be 10 digits");
        }
        this.supplierPhone = supplierPhone;
    }
}

