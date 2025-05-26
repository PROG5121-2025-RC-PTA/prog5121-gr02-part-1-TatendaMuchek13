/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainquickchat;
import javax.swing.JOptionPane;
/**
 *
 * @author 27671
 */
public class MainQuickChat {

    public static void main(String[] args, int option) {
        // TODO code application logic here
 
Project one = new Project();
     int count = 0;
     int messageLimit = 10;

    while(true){
        String choice = JOptionPane.showInputDialog("Choose an option: \n1) Send Message \n2) Show previous messages \n3) Quit");
        if (choice==null) break;
        int select = Integer.parseInt(choice);

        switch (select) {
            case 1:
                if (count >= messageLimit) {
                    JOptionPane.showMessageDialog(null, "Message limit reached.");
                    break;
                }

                String recipient = JOptionPane.showInputDialog("Enter recipient cell number (+country code 123456789)");
                String message = JOptionPane.showInputDialog("Enter message of max 250 chars):");

                if (message.length() > 250) {
                    JOptionPane.showMessageDialog(null,
                            "Message exceeds 250 characters by " + (message.length() - 250) + ", please reduce the size of characters.");
                    break;
                }

                Message2 msg = new Message2(recipient, message);

                if (!msg.checkRecipientCell()) {
                    JOptionPane.showMessageDialog(null,
                            "Cell phone number is incorrectly formatted or missing country code.");
                    break;
                }
                
                String action="";
             
                String[] options = {"Send Message", "Discard Message", "Store Message"};
                int choice2 = JOptionPane.showOptionDialog(null, "Choose an action:", "Send Message",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                switch (choice2) {
                    case 0: // "Send Message"
                        action = msg.sentMessage("Send");
                        count++;
                        break;
                    
                
                    case 1:
                        action= msg.sentMessage("Delete");
                      break;  
                    case 2:
                        action= msg.sentMessage("Store");
                        break;
                    default:
                        action ="No futher action taken.";
                
                }
JOptionPane.showMessageDialog(null,"\n\nAction"+msg.printMessageDetails()+action);
            break;
    case 2:
          JOptionPane.showMessageDialog(null,"Coming Soon");
          break;
          
    case 3:         
           JOptionPane.showMessageDialog(null, "Total Message Sent:" +Message.returntotalMessage()+ "\nExiting QuickChat.");
            System.exit(0);
            break;
            
    default:
        JOptionPane.showMessageDialog(null, "Invalid. Press 1, 2 or 3.");
            
    }
}   
    }  

    void startApplication() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    }
  


