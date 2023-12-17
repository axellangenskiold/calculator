package calculator;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class CalculatorGrid extends JPanel {

    private static int FONT_SIZE = 25;
    private static int BUTTON_SIZE = 130;

    private String[][] calculatorStrings = {{"7","8","9","*","/"},{"4","5","6","+","-"},{"1","2","3","SQRT","DELETE"},{",","0","(",")","="}};

    public CalculatorGrid() {
        super(new GridLayout(4,5));

        for (String[] s1 : calculatorStrings) {
            for (String s2 : s1) {
                JButton button = new JButton();
                

                button.setText(s2);
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { 
                        
                    }
                });

                button.setFont(new Font("ComicSans", Font.BOLD, FONT_SIZE));
                button.setPreferredSize(new Dimension(BUTTON_SIZE, BUTTON_SIZE));
                button.setFocusable(false);
                button.setOpaque(true);
                button.setBorderPainted(true);
                add(button);
            }
        }
    }

    public void addToFrame(JFrame frame) {
        JPanel outPanel = new JPanel();
        outPanel.add(java.awt.BorderLayout.CENTER, this);
        frame.add(outPanel);
    }
    
}
