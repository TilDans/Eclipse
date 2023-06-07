package KE4;

import java.io.*;
import java.util.*;

public class Outputtest {
    public static void main(String[] args) {
        Persona p1 = new Persona("Ada", "Lovelace");
        Persona p2 = new Persona("Grace", "Hopper");
        Persona p3 = new Persona("Adele", "Goldberg");
        LinkedList<Persona> myList = new LinkedList<Persona>();
        myList.add(p1);
        myList.add(p2);
        myList.add(p2);
        myList.add(p3);
        String filename = "speicherndeDatei";
        try {
            OutputStream os = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(myList);
            oos.close();
        } catch (FileNotFoundException e) {
            System.out.println("Can't open " + filename);
            return;
        } catch (IOException e) {
            System.out.println("IOException reading " + filename);
            return;
        }
    }
}

class Persona implements Serializable {
    private String firstName;
    private String lastName;
    
    public Persona(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    void print() {
        System.out.println(firstName + " " + lastName);
    }
}
