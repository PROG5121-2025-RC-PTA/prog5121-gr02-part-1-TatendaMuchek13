/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.regex.*;
////OpenAI [Accessed 13 April 2025] Available at:  https://chat.openai.com/ for regex used in the checkpassword method.

public class Project {

    
    public static void main(String[] args) {
    Scanner user = new Scanner(System.in);   
        
        String cellNr = "";
        String username = "";
       String password ="";
 // _________________________      
 String gender="";                    
 int age;                    
 int cellnr;
String name1 ="";
String surname ="";
//____________________      

        //Socializer is the name of the chat app.
 JOptionPane.showMessageDialog(null, "Hello new User, Welcome to Socializer.");

    //Small section of the user.
    System.out.println("Please enter your name: ");   
       name1 = user.nextLine();
    
    System.out.println("Enter your surname: "); 
       surname = user.nextLine();
    
    System.out.println(" What is your (Male/Female/Other):");
     gender = user.nextLine();
   
    System.out.println("How old are you?: ");  
    age = user.nextInt();
    
       

        //the following was used to check code
//_____________________________________________________________________________________________________________________________________________        
     JOptionPane.showMessageDialog(null, "Hello "+name1 );
    
    //CellPhone Number
   while(true){
    System.out.println("Enter your South African cellphone number and write it as the following (e.g. +27123456789): ");   
    cellNr = user.nextLine(); 
    checkcellnumber(cellNr);
        
     if (checkcellnumber(cellNr)){
     JOptionPane.showMessageDialog(null, "Cellphone number correctly saved.");
     break;
     }else {
     JOptionPane.showMessageDialog(null,"Incorrect. Please try writing the number South African number as follows: (+27)123456789 ");
     }   
}
//_______________________________________________________________________________________________________________________   
 //Username 
 
   while(true){  
  System.out.println("Create your Socializer username. Your username must have an underscore '_' and be more than 5 characters:");     
 username = user.nextLine();
 
   
 if (checkusername(username)){
       System.out.println("Username saved.");
 break;
 }
 else{System.out.println("Incorrect. Username must have an underscore '_' and be more than 5 characters.");
 }
 } user.close();
 //_______________________________________________________________________________________________
   
 //Password
 
   while(true){  
  System.out.println("Create your password with the following: must contain at least 1 capital letter, 1 number, 1 special character(!@#$%^&*()_{}) and be more than 8 characters long.");     
 password = user.nextLine();
 
   
 if (checkpassword(password)){
       System.out.println("Password now saved. " +username+ " you are officially register on Socializer."  );
 break;
 }
 else{System.out.println("Incorrect. Password must have at least 1 capital letter, 1 number, 1 special character(!@#$%^&*()_{}) and be more than 8 characters long.");
 }
 }  user.close();
  
   } 
    
 
    public static boolean checkcellnumber(String cellNr){
        return  cellNr.length()>=12;

    }

    public static boolean checkusername (String username){
  return username.length() >5 && username.contains("_");
 // This method code was adapted by chatGPT
//OpenAI [Accessed 13 April 2025] Available at:  https://chat.openai.com/ for validating the username method.
    }
  
    public static boolean checkpassword(String password){
// For this method, the FOR loop is used to met the password conditions
// the following is set to false to identify if it is true.

// Also this method was Adapted by the help of ChatGpt
//OpenAI [Accessed 13 April 2025] Available at:  https://chat.openai.com/ for validating the password code.
 
    if (password.length()<= 8){
        System.out.println("Password is less than 8.");
    return false;
   }
  
  if (!password.matches(".*[A-Z].*")){
        System.out.println("Password is missing at least one Capital letter.");
    return false;
    }
  
  if (!password.matches(".*\\d.*")){
        System.out.println("Password is missing at least one digit.");
    return false;
    
    }
  
  if (!password.matches(".[*!@#$%^&*()_{}.]*")){
        System.out.println("Password is missing at least one special character.");
    return false;
    
    }
  
return true;
      
      
      
      
      
      
      
      
      
      
      
      }  
        
     
    }


