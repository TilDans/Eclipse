package KE5;

import java.util.*;


interface Beobachter {
    void steigen(Aktie aktie);
    void fallen(Aktie aktie);
}

class Aktie {
    private String name;
    private int kursWert;
    private ArrayList<Beobachter> beobachterListe = new ArrayList<Beobachter>();
    
    Aktie(String name, int kursWert) {
        this.name = name;
        this.kursWert = kursWert;
    }
    
    public void anmeldenBeobachter(Beobachter beobachter) {
        beobachterListe.add(beobachter);
    }
    
    public String getName() {
        return name;
    }
    
    public int getKursWert() {
        return kursWert;
    }
    
    void setKursWert(int neuerWert) {
        int alterWert = kursWert;
        kursWert = neuerWert > 0 ? neuerWert : 1;
        if (kursWert > alterWert) {
            for (Beobachter beobachter : beobachterListe) {
                beobachter.steigen(this);
            }
        } else if (kursWert < alterWert) {
            for (Beobachter beobachter : beobachterListe) {
                beobachter.fallen(this);
            }
        } 
    }
}

public class Boerse {
    public static void main(String[] argv) {
        Aktie vw = new Aktie("VW", 354);
        Aktie bmw = new Aktie("BMW", 548);
        Beobachter silke = new Beobachter() {
            private boolean besitzt;
            @Override
            public void fallen(Aktie aktie) {
                if (aktie.getKursWert() < 300 && !besitzt) {
                    System.out.println("Silke: Kauf von " + aktie.getName());
                    besitzt = true;
                }
            }
            @Override
            public void steigen(Aktie aktie) {
                if (aktie.getKursWert() > 400 && besitzt) {
                    System.out.println("Silke: Verkauf von " + aktie.getName());
                    besitzt = false;
                }
            }
        };
        
        vw.anmeldenBeobachter(silke);
        Beobachter georg = new Beobachter() {
            private int maximum;
            @Override
            public void steigen(Aktie a) {
                if (a.getKursWert() > maximum) {
                    maximum = a.getKursWert();
                    System.out.println("Georg: Neues Maximum " + a.getName() + ": " + maximum);
                }
            }
            @Override
            public void fallen(Aktie a) {
            }
        };
        vw.anmeldenBeobachter(georg);
        bmw.anmeldenBeobachter(georg);
        for (int i = 0; i < 10; i++) {
            System.out.print("VW: " + vw.getKursWert());
            System.out.println("\t\tBMW: " + bmw.getKursWert());
            vw.setKursWert(vw.getKursWert() +
            (int) Math.round(Math.random() * 1) - 10);
            bmw.setKursWert(bmw.getKursWert() +
            (int) Math.round(Math.random() * 1) - 10);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print("VW: " + vw.getKursWert());
            System.out.println("\t\tBMW: " + bmw.getKursWert());
            vw.setKursWert(vw.getKursWert() +
            (int) Math.round(Math.random() * 100) - 5);
            bmw.setKursWert(bmw.getKursWert() +
            (int) Math.round(Math.random() * 100) - 5);
        }
    }
}