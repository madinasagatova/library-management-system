/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Borrowing;

import InputUtils.InputUtil;
import book.Book;
import static filesManagement.FileReader.FileReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author madinasagatova
 */
public class Borrowings implements Serializable{
      public static ArrayList<Borrowing> Borrowing() throws IOException{
   
    ArrayList<Book> books = FileReader();
    InputUtil myInput = new InputUtil();//take an input of the user 
    ArrayList<Borrowing> borrowings = new ArrayList<Borrowing>();
    File file = new File("borrowings.csv"); //creating a file 
     ObjectOutputStream oos = null; //object output 
    ObjectInputStream ois =null; //oblect input    
    
 //A new menu
        System.out.println("------------------------------------------------------------------------");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*- WELCOME TO THE LIBRARY -*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("------------------------------------------------------------------------");
        int choice = myInput.getUserInt("                           CHOOSE AN OPTION  " //using my InputUtilities
                +"\nPress 1 to search a book you want to borrow "
                + "\nPress 2 to regester a borrowing"
                + "\nPress 3 to add a student into a waiting list"
                +"\nPress 4 t oreturn a book", 1, 5);
        switch(choice){ //using switch statment for options
             case 1: //search a book
                    Book.linearSearch(books);
                    String borrow = myInput.someUserText("Would you like to borrow the book? Please, enter Yes or No");
                    
                    if(borrow.equalsIgnoreCase("yes")){ //enter pearamentrs
                        String inputName = myInput.someUserText("Enter the student name: ");
                        String inputLastName = myInput.someUserText("Enter the student  last name: ");
                        String inputID = myInput.someUserText("Enter the student ID: ");
                        for (int i = 0; i < books.size() - 1; i++)
            {
                    
                        borrowings.add(new Borrowing(books.get(i).getBookTitle(),books.get(i).getAuthorLastName(),books.get(i).getAuthorName(),inputName,inputLastName,inputID));
                        }    
                        oos = new ObjectOutputStream(new FileOutputStream(file));//upload the new info into the file 
                    oos.writeObject(borrowings);
                    oos.close();
                    }
                    else if(borrow.equalsIgnoreCase("No")){ //if not, the user is jumping to the main menu
                        System.out.println("You are going to the main page.........");
                       
                    }
                    else;
                    
             
                    break;
             case 2: //to regester
                        String inputName = myInput.someUserText("Enter the student name: ");
                        String inputLastName = myInput.someUserText("Enter the student name: ");
                        String inputID = myInput.someUserText("Enter the student ID: ");
                        for (int i = 0; i < books.size() - 1; i++)
            {
                    
                        borrowings.add(new Borrowing(books.get(i).getBookTitle(),books.get(i).getAuthorLastName(),books.get(i).getAuthorName(),inputName,inputLastName,inputID));
                        }    
                        oos = new ObjectOutputStream(new FileOutputStream(file));//upload the new info into the file 
                    oos.writeObject(borrowings);
                    oos.close();
                    }
     return borrowings;    
}
     
         
}

