package student;


import java.awt.print.Book;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *This class models a simple Student
 * and methods
 * @author madinasagatova
 */
public class Student implements Serializable{
    
    //student variables 
    private String studentID;
    private String studentName;
    private String studentLastname;
    private String studentAge;
    private String address;
    
    
    //how many books one student is able to borrow (only 5 max)

    Book BorrowedBooks[] = new Book[5];
    public int booksCounter = 0;
    
    
    //constructor 
    
    public Student(String studentName, String studentLastname, String studentID, String studentAge, String address){
        this.studentName = studentName;
        this.studentLastname = studentLastname;
        this.studentID =studentID;
        this.studentAge = studentAge;
        this.address = address;
       
    }
    //Getters and Setters
    public String getStudentID() {
        
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentLastname() {
        return studentLastname;
    }

    public void setStudentLastname(String studentLastname) {
        this.studentLastname = studentLastname;
    }

    public String getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(String studentAge) {
        this.studentAge = studentAge;
    }

    public  String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    //TOSTRING
    @Override
    public String toString() {
        return  "\nName: " + studentName  + "\nLast Name: " + studentLastname 
                + "\nStudent ID: " + studentID + "\nAge: " + studentAge + "\nAddress: " + address
                + "\n---------------------------------------------------------------------------------------";
    }
}
