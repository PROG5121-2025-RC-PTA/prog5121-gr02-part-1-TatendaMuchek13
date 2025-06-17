/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainquickchat;


import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author 27671
*/
    
public class Message2{

    static int returntotalMessage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    private String messageID;
    private static int count = 0;
    private int messageNR;
    private String recipient;
    private String text;
    private String messageHash;
    Object getFlag;
    
    
    
    public Message2 (String recipient, String text){ 
      this.messageID = generateMessageID();
      this.recipient = recipient;
      this.text = text;
      this.messageNR =++count;
      this.messageHash = createHash();
 
    }

    Message2(String string, String did_you_get_the_cake, String sent) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getMessageID() {
        return messageID;
    }

    public static int getCount() {
        return count;
    }

    public int getMessageNR() {
        return messageNR;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getText() {
        return text;
    }

    public String getMessageHash() {
        return messageHash;
    }
    
    
    
    private String generateMessageID() {
     long number = (long)(Math.random()* 1_000_000_0000L);
     return String.format("%010d", number);
    }
    
    public boolean checkmessageID(){
    return messageID.length()==10;
    }

    public boolean checkRecipientCell(){
 return recipient.matches("\\d(10,13)");
 }

public String createHash(){
String[] words = text.trim().split("\\s+");
String first = words[0].toUpperCase();
String last = words[words.length -1].toUpperCase();
return messageID.substring(0,2) + ":" +messageNR + ":" +first + last;
}

public String sentMessage(String action){
switch(action.toLowerCase()){
    case "send":
        return"Message successfully sent";
    case "delete":
        return "Press 0 to delete.";
    case "save":
        return "Message successfully stored.";
    default:
        return"Invalid action";
    }
}

public void storeMessageForJSON(){
    try{
        JSONObject ob = new JSONObject();
        ob.put("messageID",messageID);
        ob.put("messageHash",messageHash);
        ob.put("Recipient",recipient);
        ob.put("Text", text);

        FileWriter file = new FileWriter("storedMessage.json", true);
       file.write(ob.toString()+ System.lineSeparator());
       file.close();
    }
       catch (IOException ex){
System.out.println("Error. Please save on Json" + ex.getMessage());
       } 
        
    
}

public String printMessageDetails(){
return "messageID: "+ messageID +
        "\nMessage Hash: " +messageHash+
        "\nRecipient: " +recipient+
        "\nText" +text;
}

public static int returnTotalMessage(){
    return count;

    }

    Object getFlag() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getMessage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getMessage2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
public class storeMessage {
    public int id;
    public String recipient;
    public String developer;
    public String message;
    public String flag;

    public storeMessage( String recipient, String developer, String message, String flag) {
        this.id = id;
        this.recipient = recipient;
        this.developer = developer;
        this.message = message;
        this.flag = flag;
    }

    public String toString() {
        return "ID: " + id + ", Recipient: " + recipient + ", Message: " + message;
    }

}
}