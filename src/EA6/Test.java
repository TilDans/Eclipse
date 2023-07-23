package EA6;

import java.awt.*;
import java.awt.event.*;

public class Test {
    public static void main(String[] args) {
        Frame f = new Frame();
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println(Thread.currentThread().getName());
                System.exit(0);
            }
        });
        SimpleModel model = new SimpleModel();
        SimpleView view = new SimpleView(model);
        f.add(view);
        
        
        //verändert:
        Button startButton = new Button("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(Thread.currentThread().getName());
                Thread countingThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 10; i++) {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                            model.incr();
                            view.repaint();                    
                            System.out.println(Thread.currentThread().getName());
                        }
                    }
                });
                countingThread.start();
            }
        });
        f.add(startButton, BorderLayout.SOUTH);
        //unverändert:
        f.pack();
        f.setVisible(true);
    }
}

class SimpleView extends Canvas {
    private SimpleModel model;

    public SimpleView(SimpleModel model) {
        this.model = model;
        setPreferredSize(new Dimension(200, 100));
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println(Thread.currentThread().getName());
        g.drawString(String.valueOf(model.getValue()), 100, 50);
    }
}

class SimpleModel {
    private int value;

    public int getValue() {
        return value;
    }

    public synchronized void incr() {
        value++;
        System.out.println(value);
    }
}
