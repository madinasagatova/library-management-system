/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *Ask the users some prompt
 * @author madinasagatova
 * 1. get some text input 
 * 2.get an integer input
 */
public class InputUtil {
    /**
     * ask user to input some text. Keep prompting if the user input not a text.
     * return the valid input
     * @param prompt - is a question or a prompt to display on screen 
     * @return only the valid input from the user
     */
    public String someUserText(String prompt){
        
        boolean valid = false;
        BufferedReader myKB = new BufferedReader(new InputStreamReader(System.in));
        String userInput = "";
        
        do{
            System.out.println(prompt);
            
            try{
                userInput = myKB.readLine();
                if ((userInput.matches("[a-zA-Z]+")) || userInput.contains(prompt) || userInput.contains(" ")||userInput.contains("'")){
                    //valid input
                    valid = true;
                }
                else{
                    //not valid - must output only letters
                    System.out.println("Only letters are allowed (a-z,A-Z), NO OTHER CHARACTERS!");
                    }
            }
            catch(Exception e){
                    
                valid = false;
                    }
        }
        while(!valid);
        
        return (userInput);
        
    }
    /**
     * Ask the user to input some integer value(a number) using a prompt
     * No spaces allowed
     * Keep asking if the output is not a number 
     * Only return valid input 
     * @param prompt - the prompt or the question to display
     * @return only a valid integer value
     */
      public int someUserInt(String prompt){
        
        boolean valid = false;
        BufferedReader myKB = new BufferedReader(new InputStreamReader(System.in));
        int userInput = 0;
        
        do{
            System.out.println(prompt);
            
            try{
                userInput = Integer.parseInt(myKB.readLine());
                    //valid input
                    valid = true;
                }
            catch(Exception e){
                System.out.println("Only Integers allowed (0-9), NO OTHER CHARACTERS!");
                valid = false;
                    }
        }
        while(!valid); //TRUE
        
        return (userInput);
        
    }
      /**
       * Ask the user to type an integer within a certain range using a prompt
       * Keep asking if the output is not an integer value 
       * No spaces allowed
       * Only return valid input
       * @param prompt - the prompt or the question to display
       * @param minValue - the min valued number
       * @param maxValue - the max valued number
       * @return the valid value
       */
      public int getUserInt(String prompt, int minValue, int maxValue){
        
        boolean valid = false;
        BufferedReader myKB = new BufferedReader(new InputStreamReader(System.in));
        int userInput = 0;
        
        do{
            System.out.println(prompt);
            System.out.println("You must enter a number between " + minValue + " and " + maxValue);
            
            try{
                userInput = Integer.parseInt(myKB.readLine()); // convert to an integer value
                valid = true;
                
            }catch(Exception e){
                //not a valid integer
                System.out.println("Only Integers allowed (0-9) - NO OTHER CHARACTERS!");
                valid = false; 
            }
            
            
        }while( (!valid) || (userInput < minValue) || (userInput > maxValue) );
        
        //must be valid input -- just return this
        
        return (userInput);
    }

    
}
