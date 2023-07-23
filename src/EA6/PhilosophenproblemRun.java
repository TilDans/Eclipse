package EA6;

public class PhilosophenproblemRun {
    public static void main(String[] args) {
        Tisch reisTisch = new Tisch();
    }
}


class Philosopha extends Thread {
    Tisch tisch;
    Object leftFork;
    Object rightFork;
    
    Philosoph(Tisch tisch, Object leftFork, Object rightFork) {
        this.tisch = tisch;
        this.leftFork = rightFork;
        this.rightFork = leftFork;
    }
    
    @Override
    public void run() {
        try {
            while(true) { 
                doAction(System.nanoTime() + " : philosophierend.");
                synchronized(leftFork) {
                    doAction(System.nanoTime() + " : linke Gabel aufgenommen");
                    synchronized(rightFork) {
                        doAction(System.nanoTime() + " : rechte Gabel aufgenommen, essen angefangen");
                        System.out.println(Thread.currentThread().getName() + " " + System.nanoTime() + "legt Gabeln ab ");
                    }
                } 
            }
       } catch (InterruptedException e) {
           Thread.currentThread().interrupt();
           return;
       }
    }
    
    private void doAction(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random() * 100)));
    }
    
}

class Tischa {
    Object[] forks;
    Philosoph[] philosophers;
    
    Tisch() {
        philosophers = new Philosoph[5];
        forks = new Object[philosophers.length];

        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < philosophers.length; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];

            philosophers[i] = new Philosoph(this, leftFork, rightFork);
            
            Thread t = new Thread(philosophers[i], "Philosoph " + (i + 1));
            t.start();
        } 
    }
}