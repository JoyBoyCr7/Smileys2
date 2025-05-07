import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


import javax.swing.JPanel;

public class Smiley extends JPanel{
    int locx, locy, height, width;
    Color circleColor, eyecolor;

    boolean eyesClosed;

    public Smiley(int x,int y,int h,int w){
        locx = x;
        locy = y;
        height = h;
        width = w;
        circleColor = Color.ORANGE;
    }

    @Override
    public Dimension getPreferredSize() {
    return new Dimension(width, height);  
    }

    public void toggleEyes() {
        eyesClosed = !eyesClosed;
        repaint(); 
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(circleColor);
        g2d.fillOval(locx,locy,height, width);

        g2d.setColor(Color.BLACK);

        if (eyesClosed) {
            g2d.drawLine((int)(locx + height * .15), (int)(locy + height * .35),(int)(locx + height * .25), (int)(locy + height * .35));
            g2d.drawLine((int)(locx + height * .67), (int)(locy + height * .35),
                         (int)(locx + height * .77), (int)(locy + height * .35));
        }

        else {
            g2d.fillOval((int)(locx + height * .15), (int)(locy + height * .25),(int)(height - width * .80), (int)(height - width * .80));
            g2d.fillOval((int)(locx + height * .67), (int)(locy + height * .25),(int)(height - width * .80), (int)(height - width * .80));
        }
        g2d.fillArc((int)(locx + height * .15), (int)(locy + height * .35), (int)(height * .70), (int)(height * .50), 180, 180);
        
    }

    public void setSize(int size){
        height += size;
        width += size;
    }

    public void changeXleft(){
        locx -= 10;
    }

    
    public void changeXRight(){
        locx += 10;
    }

    public void setSmileyColor(Color color) {
        circleColor = color;
        repaint();
    }  
    
}
