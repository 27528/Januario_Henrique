package Januario_Henrique.27528.q6;

import java.util.Date;

public class PayrollPeriod extends Employee {
    private int month;
    private int year;
    private Date startDate;
    private Date endDate;
    
    public PayrollPeriod(int id, Date createdDate, Date updatedDate,
                        String orgName, String orgCode, String rssbNumber, String contactEmail,
                        String deptName, String deptCode, String managerName,
                        String employeeID, String fullName, String position, double baseSalary, boolean rssbRegistered,
                        int month, int year, Date startDate, Date endDate) {
        super(id, createdDate, updatedDate, orgName, orgCode, rssbNumber, contactEmail,
              deptName, deptCode, managerName, employeeID, fullName, position, baseSalary, rssbRegistered);
        
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12");
        }
        if (year < 2000) {
            throw new IllegalArgumentException("Year must be 2000 or later");
        }
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Dates cannot be null");
        }
        
        this.month = month;
        this.year = year;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public int getMonth() { return month; }
    public int getYear() { return year; }
    public Date getStartDate() { return startDate; }
    public Date getEndDate() { return endDate; }
    
    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12");
        }
        this.month = month;
    }
    
    public void setYear(int year) {
        if (year < 2000) {
            throw new IllegalArgumentException("Year must be 2000 or later");
        }
        this.year = year;
    }
    
    public void setStartDate(Date startDate) {
        if (startDate == null) {
            throw new IllegalArgumentException("Start date cannot be null");
        }
        this.startDate = startDate;
    }
    
    public void setEndDate(Date endDate) {
        if (endDate == null) {
            throw new IllegalArgumentException("End date cannot be null");
        }
        this.endDate = endDate;
    }
    
    public String getPeriodDescription() {
        String[] months = {"January", "February", "March", "April", "May", "June",
                          "July", "August", "September", "October", "November", "December"};
        return months[month - 1] + " " + year;
    }
}