package usecases.getpastorders;

import entities.FoodItem;
import entities.Order;
import entities.PastOrders;
import gateways.MainMongoDB;
import usecases.PastOrdersDAI;

import java.util.ArrayList;


public class GetPastOrdersInteractor {
    private PastOrders pastOrders;
    private final PastOrdersDAI pastOrdersDAI = new MainMongoDB();

    public GetPastOrdersInteractor(String username) {
        this.pastOrders = pastOrdersDAI.findPastOrders(username);
    }

    public ArrayList<String> getPastOrder() {
        ArrayList<String> result = new ArrayList<>();
        String eachPastOrder = "";
        for (Order currOrder : pastOrders.getPastOrdersMap().values()) {
            eachPastOrder += currOrder.dateOrdered.substring(5,10);
            eachPastOrder += "   ";
            eachPastOrder += currOrder.restaurantName;
            eachPastOrder += "   ";

            for(FoodItem food : currOrder.getOrderedItems()) {
                result.add(eachPastOrder + food.getItemName());
            }

            eachPastOrder = "";
        }

        return result;
    }

}
