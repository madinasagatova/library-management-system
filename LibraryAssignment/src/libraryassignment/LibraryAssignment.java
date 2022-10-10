/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryassignment;


import static Borrowing.Borrowings.Borrowing;
import InputUtils.InputUtil;
import book.Book;
import static filesManagement.FileReader.*;
import static filesManagement.FileReaderStudents.FileReaderStudents;
import static student.StudentMethods.WriteDataCSV;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import student.Student;

/**
 * Main Assignment (CCT Library System)
 * A simple library management program with a simple menu
 * different options that user can do - list books by title or author name in alphabetical order, search a book by author name or title
 * list students by name in alphabetical order, add student, search a student by name 
 * borrow a book and if book is not available add a student to the waiting list
 * @author madinasagatova
 * @Teacher: Aldana Louzan
 * @Subject: Algorithm&Constructs
 * @Date Started: 01/03/2022
 * @Submission Deadline Date: 14/05/2022
 */
public  class LibraryAssignment implements Serializable{

    /**
     * @param args the command line arguments
     */
    
    private ArrayList<Book> books = FileReader() ; //Loading the books 
    ArrayList<Student> students = new ArrayList<Student>(); //loading the information about students
    
    
    public static void main(String[] args) throws Exception {
        new LibraryAssignment();
    }
    
    public LibraryAssignment() throws IOException, FileNotFoundException, ClassNotFoundException {
        
        InputUtil myInput = new InputUtil(); //to get user input 
        boolean valid =false; // boolean is for do/while loop 
        // Simple menu with multiple choices 
        do{ 
        System.out.println("------------------------------------------------------------------------");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*- WELCOME TO THE LIBRARY -*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("------------------------------------------------------------------------");
        int input = myInput.getUserInt("                           CHOOSE AN OPTION  " //using my InputUtilities
                    + "\n * Press 1 to list all books by author name in alphabetical order"
                    + "\n * Press 2 to list all books by title in alphabetical order"
                    + "\n * Press 3 to search a book by an author name"
                    + "\n * Press 4 to search a book by a title"
                    + "\n * Press 5 if you want to add, search or list students"
                    + "\n * Press 6 if you want to go to the borrowing menu"
                    + "\n * Press 7 to QUIT\",",1, 7);
            System.out.println("------------------------------------------------------------------------");
            
        switch(input){ //using switch statment for options
            case 1: 
                listSortedBooks(); // call the method to sort the books by name 
                break;
            case 2:
                sortByTitle();//call the method to sort the books by title
                break;
            case 3:
                searchAuthor(); //call the method to search the books by name 
                break;
            case 4:
                searchTitle(); //call the method to search the books by title 
                break;
            case 5:
                System.out.println(students = WriteDataCSV()); // call the menu for students and respecrive methods
                break;
            case 6:
               Borrowing();
                break;
            case 7://quit the program
                System.out.println("***********************************************");
                    String quit = myInput.someUserText("Are you sure you want to quit? Please, enter Yes or No");
                    
                    if(quit.equalsIgnoreCase("yes")){ //close the program
                        System.out.println("Closing the Library..............");
                        System.out.println("***********************************************");
                        valid=true; 
                    }
                    else if(quit.equalsIgnoreCase("No")){ //if not, the user is jumping to the main menu
                        System.out.println("You are going to the main page.........");
                       
                    }
                    else;
                    
             }
        }while (!valid);     
        
    }
    // the methods sorts all books by name in alphabetical order
    //returns sorted arrayList of books
    //Bubble Sort was used 
    public ArrayList<Book> listSortedBooks() throws IOException{ 
        System.out.println(Book.bubbleSort(books));
        return books;
    }
    //the method allows user to search a book by author name
    //Linear Search was used, returns founded book
    public ArrayList<Book> searchAuthor() throws IOException{
        Book.linearSearch(books);
        return books;
    }
    //the method allows user to search a book by title
    //again I used Linear Search to perform searchin alghorithm, returns founded book
    public ArrayList<Book> searchTitle() throws IOException{
        Book.linearSearchByTitle(books);
        return books;
    }
    //the methods sorts all books by title in alphabetical order
    //returns sorted arrayList of books
    //Merge Sort was used 
    public ArrayList<Book> sortByTitle() throws IOException{
        Book.mergeSort(books);
        return books;
    }
    //the method return all students (I COULDN'T USE IT DUE TO IT GIVES ME AN ERROR) 
    //I DIDN'T USE IT
    public ArrayList<Student> readFile() throws IOException{
        ArrayList<Student> list = FileReaderStudents();
        return list;
        
    }
        

}
