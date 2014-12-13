package fiverr4;

public class Test {

    public static void main(String[] args) throws NotAnIntegerException, ParseError {

        /**
         * *******TEST CASES FOR Expr class********
         */
        System.out.println("--------TEST CASES FOR Expr class------");
        Expr test1 = new Minus(new Integer2(1), new Integer2(1));
        System.out.println("#Test1: " + Expr.evalToInt(test1));   //expected result: -1

        Expr test2 = new Plus(new Integer2(5), new Integer2(3));
        System.out.println("#Test2: " + Expr.evalToInt(test2));   //expected result: 8

        Expr test3 = new Times(new Integer2(5), new Integer2(3));
        System.out.println("#Test3: " + Expr.evalToInt(test3));//expected result: 15

        Expr test4 = new Plus(new Integer2(3), new Minus(new Integer2(1), new Integer2(1)));
        System.out.println("#Test4: " + Expr.evalToInt(test4));//expected result: 15

        try {
            Expr test5 = new Minus(new Integer2(1), new Times(new Integer2(1), new Divide(new Integer2(3), new Integer2(2))));
            System.out.println("#Test5: " + Expr.evalToInt(test5));//expected result: NotAnIntegerException
        } catch (NotAnIntegerException e) {
            System.out.println("#Test5: " + e);
        }

        Expr test6 = new Minus(new Integer2(1), new Times(new Integer2(1), new Divide(new Integer2(3), new Integer2(2))));
        System.out.println("#Test6: " + Expr.evalToFloat(test6));//expected result: -0.5

        Expr test7 = new Plus(new Integer2(1), new Divide(new Integer2(1), new Divide(new Integer2(3), new Integer2(2))));
        System.out.println("#Test7: " + Expr.evalToFloat(test7));//expected result: 1.66666666

        Expr test8 = new Plus(new Integer2(1), new Divide(new Integer2(1), new Integer2(4)));
        System.out.println("#Test8: " + Expr.evalToFloat(test8));//expected result: 1.25
        try {
            Expr test9 = new Plus(new Integer2(1), new Divide(new Integer2(1), new Integer2(0)));
            System.out.println("#Test9: " + Expr.evalToFloat(test9));//expected result: ArithmeticException 
        } catch (ArithmeticException e) {
            System.out.println("#Test9: " + e);
        }
        System.out.println();
        /**
         * ***** TEST CASES FOR Evaluate class **********
         */
        
        System.out.println("--------TEST CASES FOR Evaluate class-------");
        String s1 = "1-(3+67)";
        Evaluate evaluator = new Evaluate(s1, Mode.INTEGER);
        System.out.println("#Test1: " + ((IntVal) evaluator.eval()).getVal());//expected result: -69

        s1 = "1+2+3/3";
        Evaluate evaluator2 = new Evaluate(s1, Mode.INTEGER);
        System.out.println("#Test2: " + ((IntVal) evaluator2.eval()).getVal());//expected result: 2

        s1 = "1+(2*3+2)";
        Evaluate evaluator3 = new Evaluate(s1, Mode.INTEGER);
        System.out.println("#Test3: " + ((IntVal) evaluator3.eval()).getVal());//expected result: 9

        s1 = "1+(2*3+3)/9";
        Evaluate evaluator4 = new Evaluate(s1, Mode.INTEGER);
        try {
            System.out.println("#Test4: " + ((IntVal) evaluator4.eval()).getVal());//expected result: floating point
        } catch (Exception e) {
        }
        
        s1 ="1+2/0";
         Evaluate evaluator5 = new Evaluate(s1, Mode.INTEGER);
        try {
            System.out.println("#Test5: " + ((IntVal) evaluator5.eval()).getVal());//expected result: ArithMeticException
        } catch (ArithmeticException e) {
            System.out.println("#Test5: " +e);
        }
        
        s1 = "1+2+3/5";
        Evaluate evaluator6 = new Evaluate(s1, Mode.FLOAT);
        System.out.println("#Test6: " + ((DblVal) evaluator6.eval()).getVal());//expected result: 1.2
        
        s1 = "1+(2*3+3)/9";
        Evaluate evaluator7 = new Evaluate(s1, Mode.FLOAT);
        System.out.println("#Test7: " + ((DblVal) evaluator7.eval()).getVal());//expected result: 1.1111111
        
         s1 ="1+2/0";
         Evaluate evaluator8 = new Evaluate(s1, Mode.FLOAT);
        try {
            System.out.println("#Test8: " + ((DblVal) evaluator8.eval()).getVal());//expected result: ArithMeticException
        } catch (ArithmeticException e) {
            System.out.println("#Test8: " +e);
        }

    }

}
