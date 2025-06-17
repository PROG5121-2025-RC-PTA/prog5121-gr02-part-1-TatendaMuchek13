/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package mainquickchat;
import java.util.*;
import java.security.MessageDigest;

/**
 *
 * @author 27671
 */
public class messageManagement {
/*
    messageManagement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    messageManagement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void addMessage(Message2 message2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void displayReport() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void deleteByHash(String sampleHash) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String searchByHash(String sampleHash) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String generateHash(String where_are_you_You_are_late_I_have_asked_y) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getLongestSentMessage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    } */
    

public class MessageManagement {
    private List<Message2> sentMessages = new ArrayList<>();
    private List<Message2> storedMessages = new ArrayList<>();
    private List<Message2> disregardedMessages = new ArrayList<>();
    private Map<String, Message2> messageHashMap = new HashMap<>();

    public void addMessage(Message2 m) {
        switch (m.getFlag().toLowerCase()) {
            case "sent" -> sentMessages.add(m);
            case "stored" -> storedMessages.add(m);
            case "disregard" -> disregardedMessages.add(m);
        }
        String hash = generateHash(m.getMessage());
        messageHashMap.put(hash, m);
    }

    public Message2 searchByHash(String hash) {
        return messageHashMap.get(hash);
    }

    public String generateHash(String msg) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(msg.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public void deleteByHash(String hash) {
        Message2 m = messageHashMap.remove(hash);
        if (m != null) sentMessages.remove(m);
    }

    public Message2 getLongestSentMessage() {
        Message2 longest = null;
        for (Message2 m : sentMessages) {
            if (longest == null || m.getMessage().length() > longest.getMessage().length()) {
                longest = m;
            }
        }
        return longest;
    }

    public void displayReport() {
        System.out.println("----- Sent Message Report -----");
        for (Message2 m : sentMessages) {
            System.out.println("Hash: " + generateHash(m.getMessage2()));
            System.out.println("Recipient: " + m.getRecipient());
            System.out.println("Message: " + m.getMessage());
            System.out.println("---------------------------");
        }
    }
}

}
