package calculator.expr;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.regex.Pattern;

public class ExprFactory {

    private int token;
    private StreamTokenizer tokenizer;

    public Expr build(Reader reader) throws IOException {
        tokenizer = new StreamTokenizer(reader);
        tokenizer.ordinaryChar('-');
        tokenizer.ordinaryChar('/');
        token = tokenizer.nextToken();
        Expr e = expr();
        if (token == StreamTokenizer.TT_EOF) return e;
        else throw new IllegalArgumentException("trailing garbage");
    }

    public Expr build(String input) throws IOException {
        return build(new StringReader(input));
    }

    private Expr expr() throws IOException {
        Expr result, term;
        result = term();
        while (token == '+' || token == '-') {
            int op = token;
            token = tokenizer.nextToken();
            term = term();
            switch (op) {
                case '+':
                    result = new Add(result, term);
                    break;
                case '-':
                    result = new Sub(result, term);
                    break;
            }
        }
        return result;
    }

    private Expr factor() throws IOException {
        Expr e;
        switch (token) {
            case '(':
                token = tokenizer.nextToken();
                e = expr();
                if (token != ')') throw new IllegalArgumentException("expecting \")\", found: " + token);
                token = tokenizer.nextToken();
                return e;
            case StreamTokenizer.TT_NUMBER:
                double x = tokenizer.nval;
                token = tokenizer.nextToken();
                return new Num(x);
            case StreamTokenizer.TT_WORD:
                String address = tokenizer.sval.toUpperCase();
                if (!Pattern.matches("[A-Z][0-9]+", address))
                    throw new IllegalArgumentException("illegal address: " + address);
                token = tokenizer.nextToken();
                return new Variable(address);
            case StreamTokenizer.TT_EOF:
                throw new IllegalArgumentException("unexpected end of text");
            default:
                throw new IllegalArgumentException("unexpected " + (char) token);
        }
    }

    private Expr term() throws IOException {
        Expr result, factor;
        result = factor();
        while (token == '*' || token == '/') {
            int op = token;
            token = tokenizer.nextToken();
            factor = factor();
            switch (op) {
                case '*':
                    result = new Mul(result, factor);
                    break;
                case '/':
                    try {                                   //Testar divition med noll, om divitionen inte går igenom skickas
                        Div div = new Div(result, factor);  //felmeddelandet vidare till CellFactory
                        div.op(0,factor.value());
                        result = div;
                    } catch (IllegalArgumentException e) {
                        throw e;
                    }

                    break;
            }
        }
        return result;
    }
}

