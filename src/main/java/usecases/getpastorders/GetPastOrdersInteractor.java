package usecases.getpastorders;

import entities.FoodItem;
import entities.Order;
import entities.PastOrders;
import gateways.MainMongoDB;
import usecases.PastOrdersDAI;

import java.util.ArrayList;


public class GetPastOrdersInteractor {
    private final PastOrders pastOrders;

    /**
     * Instantiating past orders interactor
     * @param username input the current user
     */
    public GetPastOrdersInteractor(String username) {
        PastOrdersDAI pastOrdersDAI = new MainMongoDB();
        this.pastOrders = pastOrdersDAI.findPastOrders(username);
    }

    /**
     * Return an array list of string for past order
     * @return Array list of strings
     */
    public ArrayList<String> getPastOrder() {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder eachPastOrder = new StringBuilder();
        for (Order currOrder : pastOrders.getPastOrdersMap().values()) {
            eachPastOrder.append(currOrder.dateOrdered, 5, 10);
            eachPastOrder.append("   ");
            eachPastOrder.append(currOrder.restaurantName);
            eachPastOrder.append("   ");

            for(FoodItem food : currOrder.getOrderedItems()) {
                result.add(eachPastOrder + food.getItemName());
            }

            eachPastOrder = new StringBuilder();
        }

        return result;
    }

}
