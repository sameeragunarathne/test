package fiverr4;

import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class Expr {

    abstract public String toString();

    abstract public boolean isGround();

    static void print(Expr e) {
        System.out.println(e.toString());

    }

    static String betweenParens(final Expr e) {
        return (e.isGround()) ? e.toString()
                : "( " + e.toString() + " )";
    }

    static String evalToInt(Expr e) throws NotAnIntegerException {
        String evalText = e.toString();
        String str = evalText.replaceAll(" ", "");
        String[] result = Infix2RPN(str).split(" ");

        double curResult = evalRPN(result);
        if (curResult % 1 == 0) {
        } else {
            throw new NotAnIntegerException("not an integer");
        }

        return (int) curResult + "";
    }

    static double evalToFloat(Expr e) throws NotAnIntegerException {
        String evalText = e.toString();
        String str = evalText.replaceAll(" ", "");
        String[] result = Infix2RPN(str).split(" ");

        double curResult = evalRPN(result);

        return curResult;
    }

    private static String Infix2RPN(String input) {
        if (input == null) {
            return "";
        }
        char[] in = input.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        Stack<Character> stack2 = new Stack<Character>();
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < in.length; i++) {
            switch (in[i]) {
                case '+':
                case '-':
                    while (!stack.empty()
                            && (stack.peek() == '*' || stack.peek() == '/')) {
                        out.append(' ').append(stack.pop());
                    }
                case '*':
                case '/':
                    out.append(' ');
                case '(':
                    stack.push(in[i]);
                case ' ':
                    break;
                case ')':
                    while (!stack.empty() && stack.peek() != '(') {
                        out.append(' ').append(stack.pop());
                    }
                    if (!stack.empty()) {
                        stack.pop();
                    }
                    break;
                default:
                    out.append(in[i]);
                    break;
            }
        }

        while (!stack.isEmpty()) {
            out.append(' ').append(stack.pop());
        }

        return out.toString();
    }

    public static double evalRPN(String[] tokens) {

        double returnValue = 0;

        String operators = "+-*/";

        Stack<String> stack = new Stack<String>();

        for (String t : tokens) {
            if (!operators.contains(t)) {
                stack.push(t);
            } else {
                double a = Double.valueOf(stack.pop());
                double b = Double.valueOf(stack.pop());
                int index = operators.indexOf(t);
                switch (index) {
                    case 0:
                        stack.push(String.valueOf(a + b));
                        break;
                    case 1:
                        stack.push(String.valueOf(b - a));
                        break;
                    case 2:
                        stack.push(String.valueOf(a * b));
                        break;
                    case 3:
                        if (a == 0) {
                            throw new ArithmeticException("cannot divide by zero");
                        }
                        stack.push(String.valueOf(b / a));
                        break;
                }
            }
        }
        
        for (int i = 0; i < tokens.length; i++) {
            System.out.println(tokens[i]);
        }

        returnValue = Double.valueOf(stack.pop());
        return returnValue;

    }

    public static void main(String[] args) {

        String s = "4+5+2/3-1";
        Parser newParser = new Parser(s);
        String str = s.replaceAll(" ", "");
        String[] result = Infix2RPN(str).split(" ");
        double curResult = evalRPN(result);
        System.out.println(curResult);
    }

}
