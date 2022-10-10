/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Borrowing;

/**
 *the user can borrow a book from the system and return 
 * @author madinasagatova
 */

public class Borrowing {
    private String bookId;
    private String bookTitle;
    private String studentID;
    private String studentName;
    private String authorName;
    private String authorLastName;
    boolean status; //available or not 
    public Borrowing(String bookId, String bookTitle, String studentID, String studentName,String authorName,String authorLastName) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.studentID = studentID;
        this.studentName = studentName;
        this.authorName = authorName;
        this.authorLastName = authorLastName;
        this.status =status;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = true;
    }
    

    @Override
    public String toString() {
        return "\nBook title:" + bookTitle + "\n Book ID: "
                + bookId + "\nAuthor name: "
                + authorName+ "\nAuthor Last Name: " 
                + authorLastName + "\nName: " + studentName  + "\nStudentID: " + studentID 
                +"\n Status: " + status + "\n---------------------------------------------------------------------------------------";
    }
    

    
  
}
