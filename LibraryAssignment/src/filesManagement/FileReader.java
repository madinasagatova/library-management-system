/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesManagement;

import book.Book;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import libraryassignment.LibraryAssignment;
import student.Student;

/**
 * Reader of the file MOCK_DATA.csv
 * make sure you changed the path where file is 
 * @author madinasagatova
 */
public class FileReader {
    public static ArrayList<Book> FileReader() throws FileNotFoundException, IOException{ //throw Exceptions 
        ArrayList<Book> content= new ArrayList<>();//array list of the content of the  file 
        //Buffered Reader was used to read the file 
        BufferedReader fileReader = new BufferedReader(new java.io.FileReader("/Users/madinasagatova/Desktop/lectures/Algorithms/ca/MOCK_DATA.csv"));
        String line = fileReader.readLine();
         //values of the book in Array List
            String[] values;
            String ID;
            String authorName;
            String authorLastName;
            String bookTitle;
            String bookGenre;
            try{
            while ((line = fileReader.readLine())!=null){
                values = line.split(",");
///showing an ID, a name, a last name,title and a genre of a book
System.out.println("ID: " + values[0] + " \nName: " + values[1] + " \nLast Name: " + values[2] + " \nTitle: "
        + values[3] + " \nGenre: " + values[4]);

System.out.println("---------------------------------------------------------------------------------------");
ID = values[0];
authorName = values[1];
authorLastName = values[2];
bookTitle = values[3];
bookGenre = values[4];
content.add(new Book(ID, authorName, authorLastName, bookTitle, bookGenre) {}); //Passing the Book toString

            }
            
        }catch(IOException e){
            java.util.logging.Logger.getLogger(LibraryAssignment.class.getName()).log(Level.SEVERE, null, e);
        }
        return content;
    }
    
    
    }

