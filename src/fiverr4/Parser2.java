package fiverr4;

import java.util.Stack;

public class Parser2 {

    private int pos = 0;
    private int len = 0;
    private String s;

    Parser2(String inp) {
        this.s = inp;
        this.pos = 0;
        this.len = inp.length();
    }

    public Expr parse() throws ParseError {
        
        String[] tokens=Infix2RPN(s);
        String operators = "+-*/";

        Stack<Expr> stack = new Stack<Expr>();

        for (String t : tokens) {
            try{
            
            if (!operators.contains(t)) {
                stack.push(new Integer2(Integer.valueOf(t)));
            } else {
                Expr e=stack.pop();
                Expr next=stack.pop();
                int index = operators.indexOf(t);
                switch (index) {
                    case 0:
                        stack.push(new Plus( next,e));
                        break;
                    case 1:
                        stack.push(new Minus(next,e));
                        break;
                    case 2:
                        stack.push(new Times(next,e));
                        break;
                    case 3:
                        stack.push(new Divide(next,e));
                        break;
                }
            }
            }catch(Exception e){
                throw new ParseError("parse error");
            }
        }
        return stack.peek();
    }
    
        private static String[] Infix2RPN(String input) {
        if (input == null) {
            return null;
        }
        char[] in = input.toCharArray();
        Stack<Character> stack = new Stack<Character>();
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

        return out.toString().split(" ");
    }

       public static void main(String[] args) throws ParseError {

        String s = "4*(23-)*6";
        Parser2 newParser = new Parser2(s);        
        System.out.println(newParser.parse().toString());
     
    }
}
