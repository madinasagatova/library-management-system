/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesManagement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import libraryassignment.LibraryAssignment;
import student.Student;

/**
 *Reader of the file students.csv
 * make sure you changed the path where file is 
 * COULN'T READ AND USE THIS METHOD IT GIVES ArrayIndexOutOfBoundsException: 1 WHEN I RUN IT 
 * @author madinasagatova
 */

public class FileReaderStudents extends FileReader{
    
    public static ArrayList<Student> FileReaderStudents() throws FileNotFoundException, IOException, IndexOutOfBoundsException{ //throw Exceptions 
     ArrayList<Student> content= new ArrayList<>();//array list of the content of the  file 
       //Buffered Reader was used to read the file 
        BufferedReader fileReader = new BufferedReader(new java.io.FileReader("students.txt"));
        String line = fileReader.readLine();
        
            //values of a student in Array List
            String[] values;
            String studentID;
            String studentName;
            String studentLastName;
            String studentAge;
            String address;
            try{
            while ((line = fileReader.readLine())!=null){
                values = line.split(",");
///showing  a name, a last name, an ID, an age and an address of a student

System.out.println("Name: " + values[0] + " \nLast Name: " + values[1] + " \nStudent ID: " + values[2] + " \nAge: "
        + values[3] + " \nAddress: " + values[4]);
System.out.println("---------------------------------------------------------------------------------------");

studentName = values[0];
studentLastName = values[1];
studentID = values[2];
studentAge = values[3];
address = values[4];
for (int index = 1; index < content.size(); index++){
content.add(new Student(studentName, studentLastName, studentID, studentAge , address) {}); //Passing the Student toString
            }
            }
            
        }catch(IOException e){
            java.util.logging.Logger.getLogger(LibraryAssignment.class.getName()).log(Level.SEVERE, null, e);
        }catch(IndexOutOfBoundsException ioob){
     ioob.printStackTrace();
        
    }
       return content;

   
}
}
