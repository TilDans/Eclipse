package KE7;

import java.io.*;
import java.net.*;

public class FileClient {
    public final static int SERVER_PORT = 8181;
    
    public static void main(String[] args) throws IOException{
        final String host = args[0];
        final String fileNameAtServer = args[1];
        final String fileNameAtClient = args[2];
        
        try ( 
                    Socket sock = new Socket(host, SERVER_PORT);
                    BufferedOutputStream toFile = new BufferedOutputStream(new FileOutputStream("C://Kram Studium/kurs1618/workspaceKurseinheit/src/KE7/" + fileNameAtClient)); ) {
            
            // Ausgabestrom öffnen, zum Server schreiben
            BufferedWriter toServer = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
            String command = "GET " + fileNameAtServer;
            toServer.write(command + "\n");
            toServer.flush();
            
            //Eingabestrom öffnen, vom Server lesen und in Datei schreiben
            BufferedInputStream fromServer = new BufferedInputStream(sock.getInputStream());
            int data = -1;
            while ((data = fromServer.read()) != -1) {
                toFile.write(data);
            }
            toFile.flush();
        }catch (FileNotFoundException e) {
            System.out.println();
            System.out.println("Die Datei kann nicht geschrieben werden: " + e.getMessage());
        }catch (IOException e) {
            System.out.println(e);            
        }
    }
}
