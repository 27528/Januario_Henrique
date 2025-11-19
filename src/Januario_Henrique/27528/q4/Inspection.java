package Januario_Henrique.27528.q4;

import java.util.Date;

public class Inspection extends Delivery {
    private String inspectionName;
    private String status;
    private String remarks;
    
    public Inspection(int id, Date createdDate, Date updatedDate,
                     String orgName, String address, String contactEmail,
                     String deptName, String deptCode,
                     String supplierName, String supplierTIN, String contact,
                     String productName, double unitPrice, int quantity,
                     String poNumber, Date orderDate, double totalAmount,
                     Date deliveryDate, String deliveredBy,
                     String inspectionName, String status, String remarks) {
        super(id, createdDate, updatedDate, orgName, address, contactEmail,
              deptName, deptCode, supplierName, supplierTIN, contact,
              productName, unitPrice, quantity, poNumber, orderDate, totalAmount,
              deliveryDate, deliveredBy);
        
        if (!status.equals("Passed") && !status.equals("Failed")) {
            throw new IllegalArgumentException("Status must be 'Passed' or 'Failed'");
        }
        
        this.inspectionName = inspectionName;
        this.status = status;
        this.remarks = remarks;
    }
    
    public String getInspectionName() { return inspectionName; }
    public String getStatus() { return status; }
    public String getRemarks() { return remarks; }
    
    public void setInspectionName(String inspectionName) {
        this.inspectionName = inspectionName;
    }
    
    public void setStatus(String status) {
        if (!status.equals("Passed") && !status.equals("Failed")) {
            throw new IllegalArgumentException("Status must be 'Passed' or 'Failed'");
        }
        this.status = status;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    public boolean isAccepted() {
        return status.equals("Passed");
    }
}
