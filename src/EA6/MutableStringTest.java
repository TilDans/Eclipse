package EA6;

import java.util.Arrays;


public class MutableStringTest {
    public static void main(String[] args) throws InterruptedException {
        Immobilien immospeicher = new Immobilien ();
        immospeicher.addProperty("Haus1", "3000");
        Thread A = new HouseAdder(immospeicher, "Haus2", "2222");
        Thread B = new HouseAdder(immospeicher, "Gebaeude2", "4444");
        Thread C = new HouseAdder(immospeicher, "Wohnung3", "6666");
        A.start();
        B.start();
        C.start();
        A.join();
        B.join();
        C.join();
        immospeicher.print();
        
        /*MutableString teststring = new MutableString ("Hello");
        Thread D = new Thread(new StringAppender(teststring, " Test1"));
        Thread E = new Thread(new StringAppender(teststring, " probe2"));
        D.start();
        E.start();
        D.join(); // Main-Thread wartet auf Beendigung von A
        E.join(); // Main-Thread wartet auf Beendigung von B
        System.out.println(teststring); // Main-Thread gibt Kontostand aus*/
    }
}


class HouseAdder extends Thread {
    private Immobilien testtstring;
    private String addhouse;
    private String addval;
    
    public HouseAdder(Immobilien testtstring, String addhouse, String addval) {
        this.testtstring = testtstring;
        this.addhouse = addhouse;
        this.addval = addval;
    }
    
    @Override
    public void run() {
        testtstring.addProperty(addhouse, addval);
    }
}
    
class StringAppender implements Runnable {
    private MutableString mutstring;
    private String appstring;
    
    public StringAppender(MutableString mutstring, String appstring) {
        this.mutstring = mutstring;
        this.appstring = appstring;
    }
    
    @Override
    public void run() {
        mutstring.append(appstring);
    }
}

class Immobilien {
    private MutableString ms = new MutableString("");

    public void addProperty(String name, String value) {
        synchronized(ms) {
            if (value != null && value.length() > 0) {
                if (ms.length() > 0) {
                    ms.append(", ");
                }
                ms.append(name).append(" = ").append(value);
            }
        }
    }
    
    public void print() {
        System.out.println(ms);
    }
}

class MutableString {
    private char[] chars;
    private int nextFreeIndex;

    public MutableString(String s) {
        chars = s.toCharArray();
        nextFreeIndex = s.length();
    }

    public synchronized MutableString append(String s) {
        for (int i = 0; i < s.length(); i++) {
            append(s.charAt(i));
        }
        return this;
    }

    private synchronized void append(char c) {
        if (chars.length == nextFreeIndex) {
            if (chars.length == 0) {
                chars = new char[1];
            } else {
                chars = Arrays.copyOf(chars, chars.length * 2);
            }
        }
        chars[nextFreeIndex] = c;
        nextFreeIndex++;
    }

    public synchronized int length() {
        return nextFreeIndex;
    }

    @Override
    public synchronized String toString() {
        return new String(Arrays.copyOfRange(chars, 0, nextFreeIndex));
    }
}