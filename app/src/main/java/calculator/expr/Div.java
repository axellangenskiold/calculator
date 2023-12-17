package calculator.expr;

public class Div extends BinaryExpr {

    public Div(Expr e1, Expr e2) {
        super(e1, e2);
    }

    @Override
    public double op(double e1, double e2) {
        if (e2 != 0) {

            return e1 / e2;
        }
        else {
            
            throw new IllegalArgumentException("error: division by zero");
        }
    }
}
