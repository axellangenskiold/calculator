package calculator.expr;

public abstract class Expr {

    public String toString() {
        return toString(0);
    }

    public abstract String toString(int i);
    
    public abstract double value();

}
