package calculator.expr;

public class Num extends Expr {

    double value;

    public Num(double value) {
        this.value = value;
    }

    @Override
    public String toString(int i) {
        return Integer.toString(i);
    }

    @Override
    public double value() {
        return value;
    }
    
}
