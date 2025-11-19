package Januario_Henrique.27528.q5;

import java.util.Date;

public class Course extends Department {
    private String courseName;
    private String courseCode;
    private int credits;
    
    public Course(int id, Date createdDate, Date updatedDate,
                 String institutionName, String code, String address,
                 String departmentName, String departmentHead,
                 String courseName, String courseCode, int credits) {
        super(id, createdDate, updatedDate, institutionName, code, address,
              departmentName, departmentHead);
        
        if (credits <= 0) {
            throw new IllegalArgumentException("Credits must be greater than 0");
        }
        
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credits = credits;
    }
    
    public String getCourseName() { return courseName; }
    public String getCourseCode() { return courseCode; }
    public int getCredits() { return credits; }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    
    public void setCredits(int credits) {
        if (credits <= 0) {
            throw new IllegalArgumentException("Credits must be greater than 0");
        }
        this.credits = credits;
    }
    
    public boolean isAdvancedCourse() {
        return credits >= 4;
    }
}
