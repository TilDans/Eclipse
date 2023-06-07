package KE5;

import java.awt.*;

public class LabelCanvas2 extends Canvas {
    private String text;
    private Dimension calculatedSize;
    private int verticalOffset;
    
    
    public LabelCanvas2(String text) {
        this.text = text;
        setFont(new Font("Serif", Font.PLAIN, 12));
        FontMetrics fontMetrics = getFontMetrics(getFont());
        System.out.println(fontMetrics.getAscent());
        System.out.println(fontMetrics.getDescent());
        System.out.println(fontMetrics.getHeight());
        int height = fontMetrics.getHeight();
        int descent = fontMetrics.getDescent();
        int width = fontMetrics.stringWidth(text);
        verticalOffset = height - descent;
        calculatedSize = new Dimension(width, height);
    }
    
    
    
    @Override 
    public void paint(Graphics g) {
        g.drawString(text, 0, verticalOffset);
    }
    
    public Dimension getPrefferedSize() {
        return this.calculatedSize;
    }
    
    @Override
    public Dimension getMinimumSize() {
        return this.calculatedSize;
    }
}
