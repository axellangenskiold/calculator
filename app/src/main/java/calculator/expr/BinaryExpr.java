package calculator.expr;

public abstract class BinaryExpr extends Expr {

    private Expr e1;
    private Expr e2;

    public BinaryExpr(Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public String toString(int i) {
        return Integer.toString(i);
    }

    public double value() {
        return op(e1.value(), e2.value());
    }

    public double op(Expr expr1, Expr expr2) {
        return op(expr1.value(), expr2.value());
    }

    public abstract double op(double e1, double e2);
    
}
