package fiverr4;

import java.util.Stack;

public class Evaluate {
    
    private Expr e;
    private Mode m;
    
    
    public Evaluate(String s, Mode m) throws ParseError{
        Parser newParser = new Parser(s);
        this.e = newParser.parse();
        this.m = m;
                
    }
    
    public Value eval(){
        String rpnString=Infix2(e.toString());
        String [] split=rpnString.split(" ");
        double curResult = evalRPN(split);
        Value val = null;
        
        if(m==Mode.INTEGER){
            if(curResult % 1 == 0){
                //System.out.println((int)curResult);
                val = new IntVal();
                ((IntVal)val).setVal((int)curResult);
            }else{
                System.out.println("floating point");
            }
        }
        else if(m==Mode.FLOAT){
           val = new DblVal();
           ((DblVal)val).setVal(curResult);
        }
        
        return val;
    }
    
    
    public static String Infix2(String input) {
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
                        if(a==0)throw new ArithmeticException("divide by zero");
                        stack.push(String.valueOf(b / a));
                        break;
                }
            }
        }

        returnValue = Double.valueOf(stack.pop());

        return returnValue;

    }
}
