package KE5;

import java.time.LocalTime;
import java.util.ArrayList;

class WakeUpService {
    private int wakeUpTime;
    private ArrayList<WakeUpServiceClient> wakeList = new ArrayList<WakeUpServiceClient>();
    
    WakeUpService(int hour) throws NoSuchNumberException {
        if (hour < 0 || hour > 24) throw new NoSuchNumberException(hour);
        wakeUpTime = hour;
    }
    
    
    public void register (WakeUpServiceClient Client) {
        wakeList.add(Client);
    }
    
    void wakeUpAllClients(){
        for (WakeUpServiceClient Client : wakeList)
            Client.wakeUp(wakeUpTime);
    }
    
    public void startService() {
        boolean finished = false;
        System.out.println("Weckdienst für Weckzeit " +
        wakeUpTime + ":00 Uhr gestartet.");
        while (!finished) {
            int currentHour = LocalTime.now().getHour();
            if (currentHour == wakeUpTime) {
                wakeUpAllClients();
                finished = true;
            }
            try {
                Thread.sleep(1000); // Eine Sekunde Pause
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class WakeTest {
    public static void main(String[] args) throws NoSuchNumberException {
        WakeUpService test18 = new WakeUpService(17);
        WakeUpServiceClient Herbert = new WakeUpServiceClient() {
            @Override
            public void wakeUp(int hour) {
                System.out.println("wake up Herbie, it's " + hour + " o'clock.");
            }
        };
        
        test18.register(Herbert);
        test18.register(new Person ("Sofia", 33.5));
        test18.register(s -> System.out.println("Methode: So geht es auch!"));
        test18.startService();
    }
}

class NoSuchNumberException extends Exception{
    NoSuchNumberException(int hour){
        System.out.println("Eine Stunde " + hour + " existiert nicht.");
    }
}

interface WakeUpServiceClient {
    void wakeUp (int hour);
}