import javax.swing.*;
import java.awt.*;


/**Smiley 2
 *@author Ronard Nyongkah
 *@version Spring 2025
 *CSci1130
*/

public class SmileyFrame extends JFrame{

    JPanel mainContainer, face1andControl1, titlePanel, face2andControl2, face3andControl3;
    JLabel title;

    Smiley face1, face2, face3;
    SmileyControl control1, control2, control3;


    public static void main(String[] args) {
        SmileyFrame frame = new SmileyFrame();
        frame.setSize(new Dimension(1250, 400));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setUpTitle();
        setUpCenter();
    }
// Title creation
    public void setUpTitle(){
        titlePanel = new JPanel(new FlowLayout());
        title =new JLabel("Smileys 2");
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);
    }
// sets up the center package holding all the instances
    public void setUpCenter() {
        setUpFaces();
    
        mainContainer = new JPanel(new FlowLayout());
    
        face1andControl1 = new JPanel(new BorderLayout());
        face1andControl1.setBorder(BorderFactory.createLineBorder(Color.black));
        face1andControl1.add(face1, BorderLayout.CENTER);
        control1 = new SmileyControl(face1);
        face1andControl1.add(control1, BorderLayout.SOUTH);
    
        face2andControl2 = new JPanel(new BorderLayout());
        face2andControl2.setBorder(BorderFactory.createLineBorder(Color.black));
        face2andControl2.add(face2, BorderLayout.CENTER);
        control2 = new SmileyControl(face2);
        face2andControl2.add(control2, BorderLayout.SOUTH);
    
        face3andControl3 = new JPanel(new BorderLayout());
        face3andControl3.setBorder(BorderFactory.createLineBorder(Color.black));
        face3andControl3.add(face3, BorderLayout.CENTER);
        control3 = new SmileyControl(face3);
        face3andControl3.add(control3, BorderLayout.SOUTH);
    
        mainContainer.add(face1andControl1);
        mainContainer.add(face2andControl2);
        mainContainer.add(face3andControl3);
        getContentPane().add(mainContainer, BorderLayout.CENTER);
    }
// creating all instances of the faces
    public void setUpFaces(){
        face1 = new Smiley(0, 0,250, 250);
        face2 = new Smiley(0, 0,250, 250);
        face3 = new Smiley(0, 0, 250, 250);
    }
}
