package KE7;

import java.io.*;
import java.net.*;

public class FileServer {
    public static final int SERVER_PORT = 8181;
    
    public static void main(String[] args) throws IOException{
        BufferedInputStream fromFile = null;
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
                  Socket sock = serverSocket.accept();
                  BufferedReader fromclient = new BufferedReader(new InputStreamReader(sock.getInputStream()))) {
                      System.out.println("Server gestartet, bereit an Port " + SERVER_PORT);
                      String request = fromclient.readLine();
                      if (!request.startsWith("GET ")) throw new IllegalArgumentException();
                      
                      String filename = request.substring(4);
                      fromFile = new BufferedInputStream(new FileInputStream("C://Kram Studium/kurs1618/workspaceKurseinheit/src/KE7/" + filename));
                      
                      BufferedOutputStream toclient = new BufferedOutputStream(sock.getOutputStream());
                      int data = -1;
                      while ((data = fromFile.read()) != -1) {
                          toclient.write(data);
                      }
                      toclient.flush();
                      System.out.println("Datei mit Name: " + filename + " wurde an " + sock.getInetAddress() + " gesendet");
            }catch (IllegalArgumentException e) {
                System.out.println("Ein solcher Befehl wurde nicht gefunden: " + e.getMessage());
            }catch (FileNotFoundException e) {
                System.out.println("Datei konnte nicht gefunden werden " + e.getMessage());
            } catch (IOException e){
                System.out.println("Es gab einen Fehler in der Übertragung " + e.getMessage());
            } finally {
                if (fromFile != null) fromFile.close();
                System.out.println("Server wurde beendet.");
            }
        }
    }
}