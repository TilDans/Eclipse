package KE3;


public class FahrzeugTest {
    public static void main(String[] args) {
        mitReifen a = new Schubkarre();
        System.out.println(a.anzahlReifen());
    }
}

abstract class Fahrzeug{
    public abstract String fahrzeugArt();
}

class Boot extends Fahrzeug {
    
    @Override
    public String fahrzeugArt() {
        return " ";
    }
}
    
interface mitReifen{
    public int anzahlReifen();
}


class Auto extends Fahrzeug implements mitReifen {
    
    @Override
    public String fahrzeugArt() {
        return "Auto";
    }
    
    @Override
    public int anzahlReifen() {
        return 4;
    }
}

class Schubkarre implements mitReifen {
    @Override
    public int anzahlReifen() {
        return 1;
    }
}