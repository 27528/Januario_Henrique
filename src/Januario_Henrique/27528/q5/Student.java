package Januario_Henrique.27528.q5;

import java.util.Date;

public class Student extends Instructor {
    private String studentName;
    private String studentID;
    private int age;
    
    public Student(int id, Date createdDate, Date updatedDate,
                  String institutionName, String code, String address,
                  String departmentName, String departmentHead,
                  String courseName, String courseCode, int credits,
                  String instructorName, String email, String phone,
                  String studentName, String studentID, int age) {
        super(id, createdDate, updatedDate, institutionName, code, address,
              departmentName, departmentHead, courseName, courseCode, credits,
              instructorName, email, phone);
        
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be greater than 0");
        }
        
        this.studentName = studentName;
        this.studentID = studentID;
        this.age = age;
    }
    
    public String getStudentName() { return studentName; }
    public String getStudentID() { return studentID; }
    public int getAge() { return age; }
    
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    
    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be greater than 0");
        }
        this.age = age;
    }
    
    public String getStudentCategory() {
        if (age < 18) return "Minor";
        else if (age < 25) return "Young Adult";
        else return "Adult";
    }
}