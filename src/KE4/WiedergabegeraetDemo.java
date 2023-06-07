package KE4;

public class WiedergabegeraetDemo {
    public static void main(String[] args) {
        Wiedergabegeraet<Cd> player = new Wiedergabegeraet<Cd>();
        Cd cd = new Cd("James Bond");
        player.mediumEinlegen(cd);
        player.medium.print();
        Cd medium = player.mediumEntnehmen();
        medium.print();
        player.print();
        Wiedergabegeraet<BluRay> blurayPlayer = new Wiedergabegeraet<BluRay>();
        blurayPlayer.mediumEinlegen(cd);
    }
}

class Cd extends BluRay {
    
    Cd(String name){
        super(name);
    }
    
    @Override
    void print() {
        System.out.println(name);
    }
}

class BluRay {
    String name;
        
    BluRay(String name){
        this.name = name;
    }
        
    void print() {
        System.out.println(name);
    }
}

class Wiedergabegeraet<T>{
    T medium;
    
    void mediumEinlegen(T medium) {
        this.medium = medium;
    }
    
    T mediumEntnehmen() {
        T lokalesMedium = this.medium;
        this.medium = null;
        return lokalesMedium;
    }
    
    void print() {
        System.out.println(this.medium);
    }
}