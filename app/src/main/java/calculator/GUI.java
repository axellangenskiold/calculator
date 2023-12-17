package calculator;

import javax.swing.JFrame;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.KeyAdapter;

@SuppressWarnings("deprecation")
public class GUI extends JFrame implements Observer {

    private Calculator calculator;

    public GUI(Calculator calculator) {
        this.calculator = calculator;
        
        CalculatorGrid cg = new CalculatorGrid();
        Display display = new Display(calculator);

        cg.addToFrame(this);
        add(java.awt.BorderLayout.NORTH, display);

        this.addKeyListener(new KeyAdapter() {
            @Override 
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        calculator.add(display.getText());
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    display.delete();
                } else {
                    display.add(e);
                }
            }
        });

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);
        requestFocus();
    }


    public static void main(String[] args) {
        new GUI(new Calculator());
    }


    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
