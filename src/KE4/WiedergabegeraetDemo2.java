package KE4;

public class WiedergabegeraetDemo2 {
    public static void main(String[] args) {
        Wiedergabegeraet2<Cd2> player = new Wiedergabegeraet2<Cd2>();
        Cd2 cd = new Cd2();
        player.mediumEinlegen(cd);
        player.alleSpielen();
        Cd2 medium = player.mediumEntnehmen();
    }
}

interface Hoerbar {
    void liedSpielen(int LiedNr);
    int anzahlLieder();
}

class Cd2 implements Hoerbar {
    
    @Override
    public void liedSpielen(int LiedNr) {   System.out.println("Spiele Lied Nr. : " + LiedNr);  }
    public int anzahlLieder() {    return 12;  }
}

class Wiedergabegeraet2 <T extends Hoerbar>{
    T medium;
    
    void mediumEinlegen(T medium) {
        this.medium = medium;
    }
    
    T mediumEntnehmen() {
        T lokalesMedium = this.medium;
        this.medium = null;
        return lokalesMedium;
    }
    
    void alleSpielen() {
        int anzahl = this.medium.anzahlLieder();
        for(int i = 1; i <= anzahl; i++) {
            this.medium.liedSpielen(i);
        }
    }
}