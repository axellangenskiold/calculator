package calculator.expr;

public class Sqrt extends Expr  {

    double value;

    public Sqrt(double value) {
        this.value = java.lang.Math.sqrt(value);
    }

    public double value() {
        return value;
    }

    @Override
    public String toString(int i) {
        return Integer.toString(i);
    }

}
