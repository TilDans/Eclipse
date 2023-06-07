package KE4;
import java.io.*;


public class FileAccessTest {
    public static void main(String[] args) {
        String fileName = "C://Users/Tilman/Desktop/javatest.txt";
        
        try {
            String text = "This is my first java created file";
            FileAccess.writeTextToFile(fileName, text);
        } catch (FileNotFoundException e) {
        System.out.println("Can't open " + fileName);
        return;
        } catch (IOException e) {
        System.out.println("IOException reading " + fileName);
        return;
        }
        try {
        FileAccess.readTextFromFile(fileName);
        } catch (IOException e) {
        System.out.println("Can't open " + fileName);
        }
    }
}

class FileAccess {
    public static void writeTextToFile(String fileName, String text) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(text);
        bw.close();
    }
        
    public static void readTextFromFile(String fileName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}