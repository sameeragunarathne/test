package fiverr4;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.util.function.Predicate;

public class CalculatorFrame extends JFrame {

    private static final int NUMBER_PAD_WIDTH = 4;
    private static final int NUMBER_PAD_HEIGHT = 5;
    private Mode mode;
    private static final int CALCULATOR_WIDTH = 1;
    private static final int CALCULATOR_HEIGHT = 2;
    private boolean intMode = false;
    private boolean isErrorOccured = false;
    private String prevResult;
    /* In the end this is what we're looking for
     *    -------------------
     *    |               0 |
     *    -------------------
     *    | ( | ) | % | AC  |
     *    -------------------
     *    | 7 | 8 | 9 |  /  |
     *    -------------------
     *    | 4 | 5 | 6 |  *  |
     *    -------------------
     *    | 1 | 2 | 3 |  -  |
     *    -------------------
     *    | 0 | . | = |  +  |
     *    -------------------
     */
    private static final long serialVersionUID = 1L;

    private JPanel mainPanel, resultPanel, numberPanel;

    private static Set<String> operators = new HashSet<String>();
    private static Set<String> digits = new HashSet<String>();

    // Static blocks work like a constructor, but are outside out constructor
    // and typically only used for variable initialization. Lets create a set
    // for our symbols and operators!
    static {

        for (String x : new String[]{"(", ")", "+", "-", "*", "/", "B", "M", "=", "AC"}) {
            operators.add(x);
        }

        for (int i = 0; i < 10; i++) {
            digits.add(Integer.toString(i));
        }
    }

    // The indicates whether the next digit-press should clear the screen or not.
    private boolean clearResultField = true;

    // The first number entered and stored into our calculator.
    private Integer firstNumber = null;

    // The action/operation entered and stored into our calculator.
    private String action = null;

    /* We could have made use of other things such as JLabel, JRadioButton, and JCheckBox etc */

    /* and finally we need a JTextField to hold our results */
    private JTextField resultField;

    public CalculatorFrame() {

        /* Set the title of the window. */
        super("Simple Calculator");

        /* result panel */
        resultPanel = new JPanel();

        /* FlowLayout positions components row wise from left to right */
        resultPanel.setLayout(new FlowLayout());

        /* We want it to initially say 0 and have a width of about 20 columns */
        resultField = new JTextField("", 20);

        /* Add the text field to its panel */
        resultPanel.add(resultField);

        /* Set the alignment */
        resultField.setHorizontalAlignment(JTextField.RIGHT);

        /* We don't want it to be editable we just want to display results */
        resultField.setEditable(false);

        /* number panel*/
        numberPanel = new JPanel();

        numberPanel.setLayout(new GridLayout(NUMBER_PAD_HEIGHT, NUMBER_PAD_WIDTH));

        Map<String, JButton> buttons = new HashMap<String, JButton>();

        // Lets build the buttons for digits.
        for (String x : digits) {
            buttons.put(x, new JButton(x));
        }

        // Lets build the buttons for operators.
        for (String x : operators) {
            buttons.put(x, new JButton(x));
        }

        // The numbers will appear organized as we have them here. This does not have
        // to be a 2-dimensional array, but it helps visualize things better.
        String[][] buttonOrder = new String[][]{
            {"(", ")", "B", "AC"},
            {"7", "8", "9", "/"},
            {"4", "5", "6", "*"},
            {"1", "2", "3", "-"},
            {"0", "M", "=", "+"}
        };

        // Lets add our rows to the number panel!
        for (int i = 0; i < NUMBER_PAD_HEIGHT; i++) {
            for (int j = 0; j < NUMBER_PAD_WIDTH; j++) {
                numberPanel.add(buttons.get(buttonOrder[i][j]));
            }
        }

        // Create and add a digit listener to each digit button. Check the implementation
        // of buildDigitListener() below!
        ActionListener digitListener = buildDigitListener();

        for (String x : digits) {
            buttons.get(x).addActionListener(digitListener);
        }

        // Create and add an operator listener to each operator button. Check the implementation
        // of buildOperatorListener() below!
        ActionListener operatorListener = buildOperatorListener();

        for (String x : operators) {
            buttons.get(x).addActionListener(operatorListener);
        }

        /* we then create our mainPanel which we're going to add everything else to */
        mainPanel = new JPanel();

        /* we make it have 2 rows and 1 column so we can stack our panels */
        mainPanel.setLayout(new GridLayout(CALCULATOR_HEIGHT, CALCULATOR_WIDTH));

        /* and we add both in the order we want them to be displayed */
        mainPanel.add(resultPanel);
        mainPanel.add(numberPanel);

        /* We add our mainPanel to the JFrame */
        add(mainPanel);

        /* Specify that the window should close when the exit button provided by the OS is clicked. */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* We then call pack() which causes the window to be sized
         * to fit the preferred size and layouts of its subcomponents
         */
        pack();

        /* and finally set it's visibility to true */
        setVisible(true);
    }

    /**
     * Creates an action listener for digits. This should only be called once!
     *
     * @return An action listener for digits.
     */
    private ActionListener buildDigitListener() {

        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                 * We know only JButtons will trigger this event, so it is safe to type case
                 * the 'source' of the event to a JButton type.
                 */
                JButton j = (JButton) e.getSource();

                // If the result field should be cleared, do so while adding this digit. Lets also
                // prevent leading zeroes.
                if (clearResultField || resultField.getText().equals("")) {

                    // We probably should not be relying on the text in the digit as our 'identifier'
                    // for that button, but it is sufficient for our purposes for now.
                    resultField.setText(resultField.getText() + j.getText());
                    clearResultField = false;
                } else {
                    resultField.setText(resultField.getText() + j.getText());
                }
            }
        };
    }

    //first class function for changing the mode
    public static void evaluate(Boolean mode, int a, Predicate<Character> predicate) {

        Character n = 'M';
        if (predicate.test(n)) {
            mode = !mode;
        }
    }

    /**
     * Creates an action listener for operators. This should only be called
     * once!
     *
     * @return An action listener for operators.
     */
    private ActionListener buildOperatorListener() {

        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {        //modified with the relevant logic

                JButton j = (JButton) e.getSource();
                String operator = j.getText();

                if (isErrorOccured && operator.charAt(0) == 'B') {
                    resultField.setText(prevResult);

                    isErrorOccured = false;
                } else if (operator.charAt(0) == 'B') {
                    String temp = resultField.getText().substring(0, resultField.getText().length() - 1);
                    resultField.setText(temp);
                }
                
                //first class function call for case 'M'
                evaluate(intMode,(n)->n==operator.charAt(0));
                switch (operator.charAt(0)) {

                    case 'A': // The clear operation.

                        resultField.setText("");
                        action = null;
                        firstNumber = null;

                        break; // If you are missing 'break', the next case will execute too!

                    case '=':

                        if (action != null && firstNumber != null) {

                            resultField.setText("");
                            action = null;
                        }
                        String s1 = resultField.getText();

                        Parser p = new Parser(s1);
                        try {
                            Expr exp = p.parse();
                            if (intMode) {

                                double value = Double.valueOf(Expr.evalToInt(exp));
                                resultField.setText(resultField.getText() + "=" + (int) value);
                            } else {
                                double value = Expr.evalToFloat(exp);
                                resultField.setText(resultField.getText() + "=" + value);
                            }
                        } catch (ParseError ex) {
                            isErrorOccured = true;
                            prevResult = resultField.getText();
                            resultField.setText(resultField.getText() + "=syntax error");
                        } catch (NotAnIntegerException ex) {
                            resultField.setText(resultField.getText() + "=fraction");
                        } catch (ArithmeticException ex) {
                            if (intMode) {
                                resultField.setText(resultField.getText() + "=fraction");
                            } else {
                                resultField.setText("NaN");
                            }
                        } catch (Exception ex) {
                            isErrorOccured = true;
                            prevResult = resultField.getText();
                            resultField.setText(resultField.getText() + "=syntaxError");
                        }

                        clearResultField = true;
                        break;

                    // This case 'falls through'. If +, -, %, / or * are entered, they all execute the same case!
                    case '+':
                    case '-':
                    case 'B':
                    case '/':
                    case '*':

                        // If there was already a pending operation, perform it. This can make calculations
                        // easier for the user to do quickly.
                        if (action != null && firstNumber != null) {
                            action = operator;
                        } else {

                            // Otherwise, parse and store the first number and operator.
                            //firstNumber = Integer.parseInt(resultField.getText());
                            action = operator;
                            if (!operator.equals("B")) {
                                resultField.setText(resultField.getText() + operator);
                            } else {
                                resultField.setText(resultField.getText());
                            }
                            break;
                        }

                    default:
                        resultField.setText(resultField.getText() + operator);
                }
            }
        };
    }

    public static void main(String[] args) {
        //initializing gui
        CalculatorFrame calculatorFrame = new CalculatorFrame();
    }
}
