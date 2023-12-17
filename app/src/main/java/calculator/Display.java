package calculator;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.JTextField;
import java.util.Set;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class Display extends JTextField implements Observer {

    private static int FONT_SIZE = 70;
    private static char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '-', '*', '.', ',', '/', 's', 'q', 'r', 't', 'p', 'o', 'w', '(', ')'};
    private StringBuilder sb;
    private Set<Character> appropriateChars;
    private Calculator calculator;

    public Display(Calculator calculator) {
        this.calculator = calculator;
        sb = new StringBuilder();
        appropriateChars = new HashSet<>();

        for (char c : chars) {
            appropriateChars.add(c);
        }

        calculator.addObserver(this);
        setFont(new Font("Comic Sans", Font.BOLD, FONT_SIZE));
        setForeground(Color.BLACK);

        setFocusable(false);
    }

    public void add(KeyEvent e) {
        if (appropriateChars.contains(e.getKeyChar())) {
            sb.append(e.getKeyChar());
            update();
        }
    }

    public void delete() {
        sb.deleteCharAt(sb.length()-1);
        update();
    }

    public void clear() {
        setText("");
        sb = new StringBuilder();
    }

    public void update() {
        setText(sb.toString());
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg.equals("successfull")) {
            clear();
            setText(calculator.stringValue());
        }
    }
    
}
