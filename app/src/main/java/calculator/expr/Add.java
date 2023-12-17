package calculator.expr;

public class Add extends BinaryExpr {

    public Add(Expr e1, Expr e2) {
        super(e1, e2);
    }

    @Override
    public double op(double e1, double e2) {
        return e1 + e2;
    }
    
}
