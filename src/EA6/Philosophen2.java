package EA6;

import java.util.ArrayList;

public class Philosophen2 {
    public static final int NUMBER = 5;
    
    public static void main(String[] args)
    {
        Tisch tisch = new Tisch(NUMBER);
        for(int i = 0; i < NUMBER; i++)
            new Philosoph(tisch, i);
    }
}

class Tisch {
    boolean[] gabeln;
    int philosophencounter;
    Tischaufsicht aufsicht;
    
    Tisch(int nummer){
        this.gabeln = new boolean[nummer];
        for (int i = 0; i < gabeln.length; i++)
            gabeln[i] = false;
        this.aufsicht = new Tischaufsicht(this);
    }
    
    public synchronized void linkegabelnehmen(int nummer) throws InterruptedException {
        while (gabeln[nummer] == true) {
            wait();
        }
        gabeln[nummer] = true;
        System.out.println("Der Philosoph " + nummer + " nimmt die linke Gabel auf");
    }
    
    public synchronized void rechtegabelnehmen(int nummer) throws InterruptedException {
        while (gabeln[(nummer + 1) % Philosophen2.NUMBER] == true) {
            wait();
        }
        gabeln[(nummer + 1) % Philosophen2.NUMBER] = true;
        System.out.println("Der Philosoph " + nummer + " nimmt die rechte Gabel auf");
    }
    
    public synchronized void gabelnablegen(int nummer) throws InterruptedException {
        System.out.println("Der Philosoph " + nummer + " legt die linke Gabel ab");
        gabeln[nummer] = false;
        System.out.println("Der Philosoph " + nummer + " legt die rechte Gabel ab");
        gabeln[(nummer + 1) % Philosophen2.NUMBER] = false;
        //notifyAll();
    }
    
    public synchronized void hinsetzen (int nummer, Philosoph phil) throws InterruptedException {
        while (aufsicht.myList.size() >= 4) {
            System.out.println("\n" + "Der Philosoph " + nummer + " wartet auf einen Platz." + "\n");
            wait();
        }
        this.aufsicht.hinsetzen(phil);
        /*while (philosophencounter >= 4) {
            System.out.println("Der Philosoph " + nummer + " wartet auf einen Platz.");
            wait();
        }
        philosophencounter ++;
        System.out.println("Der Philosop " + nummer + " setzt sich an den Tisch.");*/
    }
    
    public synchronized void aufstehen (int nummer, Philosoph phil) throws InterruptedException {
        this.aufsicht.aufstehen(phil);
        notifyAll();
        /*philosophencounter --;
        System.out.println("Der Philosop " + nummer + " hat gegessen und steht auf.");
        notifyAll();*/
    }
    
    class Tischaufsicht {
        Tisch tisch;
        ArrayList<Philosoph> myList;
        
        Tischaufsicht(Tisch tisch) {
            this.tisch = tisch;
            this.myList = new ArrayList<Philosoph>();
        }
        
        public void hinsetzen(Philosoph phil) throws InterruptedException {
            myList.add(phil);
            System.out.println("aktuelle Besetzung des Tisches ist wie folgt mit " + myList.size() + " Philosophen:");
            for (Philosoph p : myList)
                System.out.print(p.getnum() + "  ");
            System.out.println("\n" +  "Der Philosop " + phil.getnum() + " setzt sich an den Tisch.");
        }
        
        public synchronized void aufstehen (Philosoph phil) throws InterruptedException {
            myList.remove(phil);
            System.out.println("Der Philosop " + phil.getnum() + " hat gegessen und steht auf.");
        }
    }
    
}



class Philosoph extends Thread {
    private Tisch tisch;
    private int nummer;

    public Philosoph(Tisch tisch, int nummer)
    {
        this.tisch = tisch;
        this.nummer = nummer;
        start();
    }
    
    public int getnum() {
        return this.nummer;
    }
    
    @Override
    public void run() {  
        while(true) {
            try {  
                philosophieren();
                tisch.hinsetzen(nummer, this);
                //sleep für ne gewisse Weile
                tisch.linkegabelnehmen(nummer);
                Thread.sleep(200);
                //wait
                tisch.rechtegabelnehmen(nummer);
                //wait
                essen();
                //sleep
                tisch.gabelnablegen(nummer);
                tisch.aufstehen(nummer, this);
                //notifyAll
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void philosophieren() throws InterruptedException {
        System.out.println("Der Philosoph " + this.nummer + " philosophiert.");
        Thread.sleep(500);
    }
    
    public void essen() throws InterruptedException {
        System.out.println("Der Philosoph " + this.nummer + " isst.");
        Thread.sleep(500);
    }
}

