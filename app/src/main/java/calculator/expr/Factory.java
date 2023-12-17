package calculator.expr;

import java.util.Stack;
import java.util.regex.Pattern;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.lang.Object;


public class Factory {

    private Stack<String> stack = new Stack<>();


    public Expr build(String s) {
        for (int i = s.length()-1; i >= 0; i--) {
            stack.push(Character.toString(s.charAt(i)));
        }

        return new Num(0);
    }

    public Expr buildFromRight(String s, int left, int right) {
        


        return new Num(0);
    }

    

}

