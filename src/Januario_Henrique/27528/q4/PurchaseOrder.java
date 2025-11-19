package Januario_Henrique.27528.q4;

import java.util.Date;

public class PurchaseOrder extends Product {
    private String poNumber;
    private Date orderDate;
    private double totalAmount;
    
    public PurchaseOrder(int id, Date createdDate, Date updatedDate,
                        String orgName, String address, String contactEmail,
                        String deptName, String deptCode,
                        String supplierName, String supplierTIN, String contact,
                        String productName, double unitPrice, int quantity,
                        String poNumber, Date orderDate, double totalAmount) {
        super(id, createdDate, updatedDate, orgName, address, contactEmail,
              deptName, deptCode, supplierName, supplierTIN, contact,
              productName, unitPrice, quantity);
        
        if (totalAmount <= 0) {
            throw new IllegalArgumentException("Total amount must be greater than 0");
        }
        
        this.poNumber = poNumber;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }
    
    public String getPoNumber() { return poNumber; }
    public Date getOrderDate() { return orderDate; }
    public double getTotalAmount() { return totalAmount; }
    
    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }
    
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    
    public void setTotalAmount(double totalAmount) {
        if (totalAmount <= 0) {
            throw new IllegalArgumentException("Total amount must be greater than 0");
        }
        this.totalAmount = totalAmount;
    }
    
    public double getVariance() {
        return totalAmount - getTotalValue();
    }
}
