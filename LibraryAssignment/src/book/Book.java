/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

import InputUtils.InputUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * This class models a simple Book
 * and methods
 * @author madinasagatova
 */
public abstract class Book {
    
    //PROPERTIES
    private String bookID;
    private String authorName;
    private String authorLastName;
    private String bookTitle;
    private String bookGenre;
    
    Scanner input = new Scanner(System.in);
    
    //CONSTRUCTOR
    public Book(String bookID, String authorName,String authorLastName, String bookTitle,String bookGenre){
        this.bookID = bookID;
        this.authorName = authorName;
        this.authorLastName = authorLastName;
        this.bookTitle = bookTitle;
        this.bookGenre = bookGenre;
        
    }

    //GETTERS AND SETTERS 
    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
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

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }
    //TOSTRING 
    @Override
    public String toString() {
        return "\nID: " + bookID + "\nAuthor Name: " + authorName + "\nAutor Last Name: " + authorLastName 
                + "\nTitle: " + bookTitle + "\nGenre: " + bookGenre
                + "\n---------------------------------------------------------------------------------------";
        
    }

    //METHODS - DIFFERENT ALGHORITHMS 
    
    //Metod 1 list all books by author name in alphabetical order 
    //using Bubble sort alghorithm
    public static ArrayList<Book> bubbleSort(ArrayList<Book>array){
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("----------------------------Sorting books by Name----------------------------");
        ArrayList<Book> temp = new ArrayList<>();
        boolean swapHappened = false;
        do {
           swapHappened = false;
            for (int j = 0; j < array.size() - 1; j++)//increasing order
            {
                if (array.get(j).getAuthorName().compareTo(array.get(j+1).getAuthorName())>0){
                    temp.add(array.get(j));
                   array.set(j, array.get(j + 1));//here perform the swap of the possition j to the possition j + 1
                    array.set(j + 1, temp.get(0));
                    swapHappened = true;
                    temp.clear();
                }
            }
            }while (swapHappened);
       
            return array;
    }
    
    //Method 2 Linear Search Algorithm to perform searching method 
    //searchs a book by name 
    public static void linearSearch(ArrayList<Book> array){
        InputUtil myInput = new InputUtil();
        String inputName = myInput.someUserText("Enter the author name of the book you are looking for"); //asks user to input a name of the author
        int found = 0;
        // Going one by one the elements in the array
        for(int i = 0; i < array.size(); i++){ 
            if (array.get(i).getAuthorName().equalsIgnoreCase(inputName)){
           System.out.println("\n-----------------------------------------------------------------------------"
                   + "\nThe author with name " +inputName.toUpperCase() // to upper case for input
                   +  " is found: " 
                   + "\n----------------------------------------------------------------------"
                   + array.get(i));// When the element is found,the loop stops and returns the index
            found++;
            }            
        } if (found == 0)
        System.out.println("\n-----------------------------------------------------------------------------"
                           + "\nSearching name " + inputName.toUpperCase() 
                           +" is not found"
                           +"\n-----------------------------------------------------------------------------"); //if not found gives to the user a friendly message  
    }
    
    //Method 3 Merge Sort Algorithm to perfom sorting Books by title
     public static ArrayList<Book> mergeSort(ArrayList<Book> array) {
        ArrayList<Book> left = new ArrayList<Book>();
        ArrayList<Book> right = new ArrayList<Book>();
        int center;
 
        if (array.size() == 1) {    
            return array;
        } else {
            center = array.size()/2;
            // copy the left half of whole into the left.
            for (int i=0; i<center; i++) {
                    left.add(array.get(i));
            }
 
            //copy the right half of whole into the new arraylist.
            for (int i=center; i<array.size(); i++) {
                    right.add(array.get(i));
            }
 
            // Sort the left and right halves of the arraylist.
            left  = mergeSort(left);
            right = mergeSort(right);
 
            // Merge the results back together.
            merge(left, right, array);
        }
        return array;
    }
 
    private static void merge(ArrayList<Book> left, ArrayList<Book> right, ArrayList<Book> array) {
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;
 
        // As long as neither the left nor the right ArrayList has
        // been used up, keep taking the smaller of left.get(leftIndex)
        // or right.get(rightIndex) and adding it at both.get(bothIndex).
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ( (left.get(leftIndex).getBookTitle().compareToIgnoreCase(right.get(rightIndex).getBookTitle())) < 0) {
                array.set(wholeIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                array.set(wholeIndex, right.get(rightIndex));
                rightIndex++;
            }
            wholeIndex++;
        }
 
        ArrayList<Book> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            // The left ArrayList has been use up...
            rest = right;
            restIndex = rightIndex;
        } else {
            // The right ArrayList has been used up...
            rest = left;
            restIndex = leftIndex;
        }
 
        // Copy the rest of whichever ArrayList (left or right) was not used up.
        for (int i=restIndex; i<rest.size(); i++) {
            array.set(wholeIndex, rest.get(i));
            wholeIndex++;
        }
        System.out.println("Sorted:");
        for (int i=0; i< array.size();i++) {
            System.out.println(array.get(i));
        }
    }
 
    
    //Method 4 Binary alghorithm was used to search books by title 
    //I COULDN'T USE IT
    public static ArrayList<Book> binarySearchByTitle(ArrayList<Book>array){
       
        InputUtil myInput = new InputUtil();
        String inputTitle = myInput.someUserText("Enter a title of the book ");
        int found = 0;
        int start = 0;
        int end = array.size() - 1;
        int mid;
        while(start<=end){
            mid = (start + end)/2;
            if(inputTitle.equalsIgnoreCase(array.get(mid).getBookTitle())){
            System.out.println("\n-----------------------------------------------------------------------------"
                    + "\nThe book with the title " + inputTitle
                    + "is found: " + array.get(mid).getBookTitle()
                    + "\n-----------------------------------------------------------------------------");
            start = end;
            found++;
                
            }else if (array.get(mid).getBookTitle().compareToIgnoreCase(inputTitle) > 0){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
         if (found == 0)
            System.out.println("\n-----------------------------------------------------------------------------"
                    +"The book with the title " + inputTitle.toUpperCase() + " is not found."
                    + "\n-----------------------------------------------------------------------------"); //if not found gives to the user a friendly message 
        return null;
    }
    
    //METHOD 5 Instead I used Linear search alghorithm for searching books by title 
    public static void linearSearchByTitle(ArrayList<Book> array){
        InputUtil myInput = new InputUtil();
        String inputTitle = myInput.someUserText("Enter a title of the book you are looking for");
        
        int found = 0;
        // Going one by one the elements in the array
        for(int i = 0; i < array.size(); i++){ 
            if ((array.get(i).getBookTitle().equalsIgnoreCase(inputTitle)) ){ //check if the title prompt matches any in the book
           System.out.println("\n-----------------------------------------------------------------------------"
                   + "\nThe book with the title "
                   + inputTitle.toUpperCase() 
                   + " is found: " 
                   + "\n-----------------------------------------------------------------------------"
                   + array.get(i)); // When the element is found,the loop stops and returns the index
            found++;
            
            }            
        } if (found == 0)
        System.out.println("\n-----------------------------------------------------------------------------"
                +"\nThe book with the title " + inputTitle.toUpperCase() 
                + " is not found."
                + "\n-----------------------------------------------------------------------------"); //if not found gives to the user a friendly message 
       
        
    }
}


    
    


