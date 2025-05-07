import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SmileyControl extends JPanel implements ItemListener, ActionListener{
    Smiley smiley;

    JPanel controlPanel;

    JButton bigger, smaller, left, right, Eyecolor;
    JRadioButton eyesControl1, eyesControl2;

    ButtonGroup eyeGroup;

    public SmileyControl(Smiley s){
        smiley = s;
        setUpControls();
    }
    JComboBox colorDropdown;

    public void setUpControls(){

        controlPanel = new JPanel(new FlowLayout());
        bigger = new JButton("Grow");
        smaller = new JButton("Shrink");
        left = new JButton("Left");
        right = new JButton("Right");

        left.addActionListener(this);
        right.addActionListener(this);
        bigger.addActionListener(this);
        smaller.addActionListener(this);

        eyesControl1 = new JRadioButton("Eyes Open");
        eyesControl2 = new JRadioButton("Eyes Closed");
        
        eyesControl2.addItemListener(this);

        eyeGroup= new ButtonGroup();

        eyeGroup.add(eyesControl1);
        eyeGroup.add(eyesControl2);

        colorDropdown = new JComboBox<>(new String[]{"Yellow", "Blue", "Green", "Red", "Orange"});
        colorDropdown.addItemListener(this);

        controlPanel.add(left);
        controlPanel.add(right);
        controlPanel.add(bigger);
        controlPanel.add(smaller);

        controlPanel.add(eyesControl1);
        controlPanel.add(eyesControl2);

        controlPanel.add(colorDropdown);

        add(controlPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source=e.getSource();

        if(source == bigger){
            smiley.setSize(10);
            smiley.repaint();
        }
        if(source == smaller){
            smiley.setSize(-10);
            smiley.repaint();
        }
        if (source == left ){
            smiley.changeXleft();
            smiley.repaint();
        }
        if (source == right ){
            smiley.changeXRight();
            smiley.repaint();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent event){
        Object source = event.getSource();

        if (source == eyesControl2){

            smiley.toggleEyes();;
        }

        if (source == colorDropdown) {
            String selectedColor = (String) colorDropdown.getSelectedItem();
            switch (selectedColor) {
                case "Yellow":
                    smiley.setSmileyColor(Color.YELLOW);
                    break;
                case "Blue":
                    smiley.setSmileyColor(Color.BLUE);
                    break;
                case "Green":
                    smiley.setSmileyColor(Color.GREEN);
                    break;
                case "Red":
                    smiley.setSmileyColor(Color.RED);
                    break;
                case "Orange":
                    smiley.setSmileyColor(Color.ORANGE);
                    break;
            }
        }

    }

    
}
