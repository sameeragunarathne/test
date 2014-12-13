
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class PizzaOrderForm extends JFrame {

    private final String sizesArr[] = {"10", "12", "14", "16"};		//Pizza sizes
    private final String crustTypeArr[] = {"hand-tossed", "deep-dish", "thin crust"};	//available crust types
    private final String toppingsArr[] = {"Mushrooms", "Onions", "Sausage", "Pineapple", "Spinach"};

    private JComboBox<String> size_combo;
    private JComboBox<String> crustTypeComboBox;
    private JTextField customer_name;
    private JCheckBox[] toppings;
    private JButton submitButton;
    private JButton cancelButton;
    private JTextArea finalOrder;
    private final Color panelColor = Color.decode("#F0F5F2");
    private JPanel main_panel;

    public PizzaOrderForm() {
        super("Pizza Order");
        InitComponents();		//gui components creation
    }

    //method for gui component creation
    private void InitComponents() {

        this.panelSetup();
        this.comboMenuCreator();
        this.ToppingOptionCreator();
        this.orderDisplay();
     //   this.buttonCreator();

        //adding main panel to the JFrame
        add(main_panel);
    }

    //method for setting up initial panels
    private void panelSetup() {
        JPanel main_container = new JPanel(new FlowLayout(FlowLayout.CENTER));
        main_container.setSize(600, 600);
        GridLayout grid;

        main_panel = new JPanel();
        main_panel.setSize(new Dimension(400, 600));
        main_panel.setBackground(panelColor);
        main_panel.setAlignmentX(100);
        main_panel.setAlignmentY(20);
        main_container.add(main_panel);

        JLabel nameLabel = new JLabel();
        nameLabel.setText("Your Name:");
        customer_name = new JTextField();

        JPanel sub_panel4 = new JPanel();
        sub_panel4.setBackground(panelColor);
        sub_panel4.setPreferredSize(new Dimension(600, 25));
        grid = new GridLayout(1, 2);
        grid.setHgap(100);
        sub_panel4.setLayout(grid);

        sub_panel4.add(nameLabel);
        sub_panel4.add(customer_name);
        main_panel.add(sub_panel4);
    }

    //method for creating combo menus
    private void comboMenuCreator() {

        JLabel sizeLabel = new JLabel();
        sizeLabel.setText("Pizza Size:");
        size_combo = new JComboBox<String>(sizesArr);

        JPanel subpanel_1 = new JPanel();
        subpanel_1.setPreferredSize(new Dimension(600, 25));

        GridLayout grid = new GridLayout(1, 4);
        grid.setHgap(100);
        subpanel_1.setLayout(grid);
        subpanel_1.add(sizeLabel);
        subpanel_1.setBackground(panelColor);
        subpanel_1.add(size_combo);
        main_panel.add(subpanel_1);

        //input for crust type
        JLabel crustLabel = new JLabel();
        crustLabel.setText("Crust Type:");
        crustTypeComboBox = new JComboBox<String>(crustTypeArr);
        JPanel subpanel_2 = new JPanel();
        subpanel_2.setBackground(panelColor);
        subpanel_2.setPreferredSize(new Dimension(600, 25));
        grid = new GridLayout(1, 2);
        grid.setHgap(100);
        subpanel_2.setLayout(grid);

        subpanel_2.add(crustLabel);
        subpanel_2.add(crustTypeComboBox);
        main_panel.add(subpanel_2);

    }

    private void ToppingOptionCreator() {

        JLabel toppingsLabel = new JLabel();
        toppingsLabel.setText("Toppings");

        JPanel toppings_panel = new JPanel();
        GridLayout grid = new GridLayout(5, 2);
        grid.setHgap(200);
        toppings_panel.setLayout(grid);

        toppings = new JCheckBox[toppingsArr.length];

        for (int i = 0; i < toppings.length; i++) {

            String toppingName = toppingsArr[i];
            toppings[i] = new JCheckBox(toppingName);
            toppings[i].setAlignmentX(CENTER_ALIGNMENT);
            toppings_panel.add(toppings[i]);

        }

        JPanel subpanel_3 = new JPanel();
        subpanel_3.setBackground(panelColor);
        subpanel_3.setPreferredSize(new Dimension(600, 125));

        grid = new GridLayout(1, 2);
        grid.setHgap(100);
        subpanel_3.setLayout(grid);

        subpanel_3.add(toppingsLabel);
        subpanel_3.add(toppings_panel);
        main_panel.add(subpanel_3);

    }

    private void buttonCreator(JPanel panel) {

        Font font = new Font("Arial", 1, 16);
        submitButton = new JButton();
        submitButton.setText("Submit");
        submitButton.setFont(font);
        submitButton.setBackground(Color.decode("#7DF9FF"));
        submitButton.addActionListener(new ButtonActionListener());

        cancelButton = new JButton("Cancel");
        cancelButton.setFont(font);
        cancelButton.setBackground(Color.LIGHT_GRAY);
        cancelButton.addActionListener(new ButtonActionListener());

        JPanel subpanel_5 = new JPanel();
        subpanel_5.setBackground(panelColor);
        subpanel_5.setPreferredSize(new Dimension(200, 200));

        GridLayout grid = new GridLayout(4, 0);
        grid.setVgap(5);

        subpanel_5.setLayout(grid);
        subpanel_5.add(submitButton);
        subpanel_5.add(cancelButton);
        panel.add(subpanel_5);
        //       main_panel.add(subpanel_5);
    }

    //method to set order display gui components
    private void orderDisplay() {
        GridLayout grid;

        finalOrder = new JTextArea();
        finalOrder.setEditable(false);
        finalOrder.setBorder(BorderFactory.createLineBorder(Color.black));
        finalOrder.setBackground(Color.decode("#DDE4E1"));
        finalOrder.setForeground(Color.BLUE);

        JPanel subpanel_6 = new JPanel();
        subpanel_6.setBackground(panelColor);
        subpanel_6.setPreferredSize(new Dimension(600, 150));
        grid = new GridLayout(0, 2);
        grid.setHgap(10);
        subpanel_6.setLayout(grid);
        subpanel_6.add(finalOrder);
        subpanel_6.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), "Order Details"));
        buttonCreator(subpanel_6);
        main_panel.add(subpanel_6);

    }

    private class ButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == submitButton) {

                int size = Integer.parseInt(size_combo.getSelectedItem().toString());	//getting pizza size
                String type = crustTypeComboBox.getSelectedItem().toString();	//getting crust type
                String name = customer_name.getText().toString();		//getting user name
                PizzaOrder order = new PizzaOrder(size, type, name);
                for (JCheckBox topping : toppings) {
                    if (topping.isSelected()) {
                        order.addTopping(topping.getText());
                    }
                }
                finalOrder.setText(order.getOrderDetails());//display output
            } //resetting the elements when the cancel button is pressed
            else if (evt.getSource() == cancelButton) {

                customer_name.setText("");
                size_combo.setSelectedIndex(0);
                crustTypeComboBox.setSelectedIndex(0);
                for (JCheckBox topping : toppings) {
                    topping.setSelected(false);
                }
                finalOrder.setText("");
            }
        }
    }

    public static void main(String[] args) {
        PizzaOrderForm order = new PizzaOrderForm();
        order.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        order.setSize(800, 450);
        order.setVisible(true);
    }
}
