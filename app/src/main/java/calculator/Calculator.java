package calculator;

import java.util.Observable;

import calculator.expr.ExprFactory;
import calculator.expr.Factory;

import java.awt.event.KeyEvent;
import java.io.IOException;

@SuppressWarnings("deprecation")
public class Calculator extends Observable {

    private StringBuilder sb;
    private ExprFactory factory;
    private double value;

    public Calculator() {
        sb = new StringBuilder();
        factory = new ExprFactory();
    }

    public void add(String s) throws IOException {
        Factory factory = new Factory();
        if (!s.isEmpty()) {
            value = factory.build(sb.toString()).value();
            setChanged();
            notifyObservers("successfull");
        }
        
    }

    public String stringValue() {
        return Double.toString(value);
    }

    
}
