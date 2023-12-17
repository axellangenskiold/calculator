package calculator.expr;

public class Variable extends Expr{

    String name;

    public Variable() {
        name = "";
    }

    public Variable(String s) {
        name = s;
    }

    @Override
    public String toString(int i) {
        return Integer.toString(i);
    }

    @Override
    public double value() {
        return 0;
    }
    
}
