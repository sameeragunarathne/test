
import java.util.ArrayList;

/**
 * This class stores pizza order information
 */
public class PizzaOrder {

    private final int size;  //sizes of pizza in inches
    private final String crustType; //type of crust requested
    private final String name;
    private final ArrayList<String> toppingsList;
    private double taxPrice = 0;

    public PizzaOrder(int size, String crustType, String name) {
        this.size = size;
        this.crustType = crustType;
        this.name = name;
        toppingsList = new ArrayList<String>();
    }

    public void addTopping(String topping) {
        toppingsList.add(topping);
    }

    /**
     * Calculates final price of order including tax
     */
    private double calculateOrderPrice() {
        double orderPrice = 0;

        orderPrice += size + 0.79;
        orderPrice += toppingsList.size() * 1.75;		//cost of toppings
        taxPrice = (orderPrice * 5.5) / 100.0;
        orderPrice += taxPrice;	//5.5% tax
        orderPrice = Math.round(orderPrice * 100.0) / 100.0;	//round to 2 dp
        return orderPrice;
    }

    /**
     * Returns string representation of the pizza order
     */
    public String getOrderDetails() {
        //create output string
        String str = "Name: " + name + "\n\n"
                + "Pizza Size: " + size + " inches" + "\n"
                + "Crust Type: " + crustType + "\n"
                + "Toppings : ";

        //add list of toppings
        for (int i = 0; i < toppingsList.size(); i++) {
            str += toppingsList.get(i);
            if (i < toppingsList.size() - 1) {
                str += ", ";
            }
        }

        if (toppingsList.size() == 0) {
            str += "None";
        }

        str += "\n\n";
        calculateOrderPrice();
        str += "Tax added = $" + taxPrice + "\n";
        str += "Total Price = $" + calculateOrderPrice() + "\n\n";

        return str;
    }
}
