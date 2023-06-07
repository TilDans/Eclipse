package KE5;

import java.awt.event.*;
import java.awt.*;

public class EggTimerModelTest {
    public static void main(String[] args) {
        // Erzeugen eines EggTimerModel für eine Laufzeit von 60 Sekunden.
        EggTimerModel timermod = new EggTimerModel(60);
        
        // Erzeugen eines EggTimerCanvas, das das oben erzeugte Model verwendet.
        EggTimerCanvas timecanv = new EggTimerCanvas(timermod);
        
        // Erzeugen eines Haupfensters mit dem Titel "Kurzzeitwecker".
        Frame mainwin = new Frame ("Kurzzeitwecker");
        mainwin.setBackground(Color.BLACK);
        
        // Anmelden eines "anonymen" Listeners, der beim Schließen des 
        // Hauptfensters die Anwendung beendet.
        mainwin.addWindowListener(new WindowActionListener());
        // Einfügen des EggTimerCanvas im Zentralbereich des Hauptfensters.
        mainwin.add(timecanv, BorderLayout.CENTER);
        Font font = new Font("Arabica", Font.BOLD, 12);
        Button endbutton = new Button("End");
        endbutton.setBackground(Color.BLACK);
        endbutton.setFont(font);
        endbutton.setForeground(Color.WHITE);
        mainwin.add(endbutton, BorderLayout.BEFORE_FIRST_LINE);
        Label elapsedTime = new Label ("elapsed time : " + timermod.getElapsedTime() + " seconds.") {
            @Override
            public void repaint() {
                this.setText("elapsed time : " + timermod.getElapsedTime() + " seconds.");
            }
            
        };
        elapsedTime.setFont(font);
        elapsedTime.setForeground(Color.WHITE);
        mainwin.add(elapsedTime, BorderLayout.AFTER_LAST_LINE);
        // Dieser Aufruf sorgt dafür, dass der LayoutManager des Hauptfensters 
        // dessen Größe gemäß der Wunschgrößen der auf diesem angeordneten 
        // Komponenten berechnet. Hier müssen Sie nichts einfügen.
        mainwin.pack();
        
        // Positionieren des Fensters in der Bildschirmmitte 
        // (siehe Ad-hoc-Aufgabe 4 der KE5).
        mainwin.setLocationRelativeTo(null);
        
        // Sichtbarmachen des Fensters.
        mainwin.setVisible(true);
        
        
        for(int i = 0; i < 50; i++) {
            // Eine Sekunde Pause (wird in KE6 näher erläutert). 
            // Hier müssen Sie nichts einfügen.
            try {
                Thread.sleep(1000);
             } catch (InterruptedException e) {
                e.printStackTrace();
            }
        
            // "Hochzählen" des Models um eins
            timermod.increaseElapsedTime();
            
            // Anstoßen eines Neuzeichnens des EggTimerCanvas.
            timecanv.repaint();
            elapsedTime.repaint();
        } 
    }
}
class WindowActionListener extends WindowAdapter implements ActionListener {
    @Override
    public void windowClosing(WindowEvent e) {
        systemexit();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        systemexit();
    }
    
    private void systemexit() {
        System.exit(0);
    }
}
class EggTimerModel {
    // vorgesehene Laufzeit in Sekunden
    private int totalTimeInSeconds;
    // verstrichene Zeit in Sekunden
    private int elapsedTimeInSeconds;
    // erzeugt eine neue Instanz dieser Klasse für die angegebene Laufzeit
    public EggTimerModel(int totalTimeInSeconds) {
        this.totalTimeInSeconds = totalTimeInSeconds;
    }

    // liefert den Zeitanteil, der bereits verstrichen ist
    public double getElapsedPart() {
        return (double) elapsedTimeInSeconds / totalTimeInSeconds;
    }
    
    public int getElapsedTime() {
        return elapsedTimeInSeconds;
    }

    // erhöht die verstrichene Zeit um eine Sekunde
    public void increaseElapsedTime() {
        elapsedTimeInSeconds++;
    }
}
class EggTimerCanvas extends Canvas {
    EggTimerModel modelledtimer;
    
    EggTimerCanvas(EggTimerModel modelledtimer){
        this.modelledtimer = modelledtimer;
        this.setPreferredSize(new Dimension(320, 320));
    }
    
    @Override
    public void paint (Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.fillOval(10, 10, 300, 300);
        g.setColor(Color.GREEN);
        //vom gleichen Startpunkt: zeichne Kreisbogen mit elapsedtime/maxtime Fläche
        g.fillArc(10, 10, 300, 300, 90, (int) (-360 * modelledtimer.getElapsedPart()));
    }
}