/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import InputUtils.InputUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import student.Student;

/**
 *Different methods such as Write a data of a student into the memory(file called students.csv),
 *displaying a new menu for student,
 * add a new student,
 * list all student by name in alphabetical order,
 * search a particular student by name 
 * @author madinasagatova
 */
public class StudentMethods implements Serializable{
   //method 1 creating a file and a menu to disply the information 
    public static ArrayList<Student> WriteDataCSV() throws  IOException, FileNotFoundException, ClassNotFoundException{
    InputUtil myInput = new InputUtil();//take an input of the user 
    ArrayList<Student> students = new ArrayList<Student>(); //put the data into an array list of students
    File file = new File("students.csv"); //creating a file 
    ObjectOutputStream oos = null; //object output 
    ObjectInputStream ois =null; //oblect input 
////    ListIterator ls =null;
        if(file.isFile()){ //if the file is exist it shows the content 
           ois = new ObjectInputStream(new FileInputStream(file));
            students = (ArrayList<Student>)ois.readObject();
            ois.close();
        }
         //A new menu
        System.out.println("------------------------------------------------------------------------");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*- WELCOME TO THE LIBRARY -*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("------------------------------------------------------------------------");
        int choice = myInput.getUserInt("                           CHOOSE AN OPTION  " //using my InputUtilities
                +"\nPress 1 to add a new student into the system "
                + "\nPress 2 to list all students by name in alphabetical order"
                + "\nPress 3 to search a paricular student by name", 1, 3);
        
         switch(choice){ //using switch statment for options
             case 1: //adding a new student, asking how many student the user wants to add, name,surname,ID, age, adderess
                    int number = myInput.someUserInt("How many students would you like to add?");
                    for(int i =0; i<number; i++){
                    String studentName = myInput.someUserText("Enter student name: ");
                    String studentLastname = myInput.someUserText("Enter student Last Name: ");
                    String studentID =myInput.someUserText("Enter student ID: ");
                    String studentAge = myInput.someUserText("Enter student age: ");
                    String address = myInput.someUserText("Enter the adddress where student lives: ");
        
                    students.add(new Student(studentName,studentLastname, studentID,studentAge,address) {}); //adding a new student by passing toString
        }
                    oos = new ObjectOutputStream(new FileOutputStream(file));//upload the new info into the file 
                    oos.writeObject(students);
                    oos.close();
        break;
             case 2:
        
//                  ls = students.listIterator();
//                  while(ls.hasNext())
//                  System.out.println(ls.next());
                    System.out.println(bubbleSort(students)); //calling the bubble sort
//                  System.out.println(students);
        
        break;
             case 3:
                    System.out.println(linearSearch(students)); //calling the linear search   
        break;
             case 4:
                 
                 
         }
        return students;   
    }
      
    //method 2 list all students by  name in alphabetical order 
    //using Bubble sort alghorithm 
    public static ArrayList<Student> bubbleSort(ArrayList<Student>array) throws  IOException, FileNotFoundException, ClassNotFoundException{
    
        System.out.println("------------------------------------------------------------------------"
                           +"\nAll students in the system listed by names in alphabetical order: "
                           + "\n------------------------------------------------------------------------");
        ArrayList<Student> temp = new ArrayList<>();
        boolean swapHappened = false;
        // Sorting strings using bubble sort
        do {
           swapHappened = false;
            for (int j = 0; j < array.size() - 1; j++)//increasing order
            {
                if (array.get(j).getStudentName().compareTo(array.get(j+1).getStudentName())>0){
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
    //Method 3 Linear Search Algorithm to perform searching method 
    //searchs a students by name 
    public static ArrayList<Student> linearSearch(ArrayList<Student> array) throws  IOException, FileNotFoundException, ClassNotFoundException{
        InputUtil myInput = new InputUtil();
        String inputName = myInput.someUserText("What is a student name are you looking for? Enter the name, please: "); //asks user to input a name of a student
        int found = 0;
        // Going one by one the elements in the array
        for(int i = 0; i < array.size(); i++){ 
            if (array.get(i).getStudentName().equalsIgnoreCase(inputName)){
           System.out.println("\n-----------------------------------------------------------------------------"
                   + "\nThe student with name " +inputName.toUpperCase() // to upper case for input
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
    
    return null;
    }  
}
    

