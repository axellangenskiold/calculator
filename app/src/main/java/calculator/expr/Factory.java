package calculator.expr;

import java.util.HashMap;
import java.util.Map;
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
        Map<Integer, Integer> parenthesis = mapParenthesisIndex(s);

        int left = 0;
        int right = s.length()-1;

        while (Character.isDigit(s.charAt(left))) {
            left += 1;
        }

        if (s.charAt(left) == '(') {
            
        }

        return new Num(0);
    }

    public Expr buildFromRight(String s, int left, int right) {
        


        return new Num(0);
    }

    public Expr buildFromLeft(String s, int left, int right) {


        return new Num(0);
    }


    //maps index of left parenthesis to index of the corresponding right parenthesis
    public Map mapParenthesisIndex(String s) {
        
        return new HashMap<>();
    }
    

}

