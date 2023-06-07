package KE4;

import java.io.*;
import java.util.*;

public class InputTest {
    public static void main(String[] args) throws IOException {
        LinkedList<Persona> listFromFile;
        InputStream is = new FileInputStream("C://Users/Tilman/Desktop/printpers.txt");
        ObjectInputStream ois = new ObjectInputStream(is);
        try {
            listFromFile = (LinkedList<Persona>) ois.readObject();
            for (Persona person : listFromFile) {
                person.print();
            }
        } catch (ClassNotFoundException exc) {
        System.out.println("Klasse zu Eingabeobjekt fehlt");
        }
    }
}
