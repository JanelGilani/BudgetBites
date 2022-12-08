package controllers;

import entities.PastOrders;
import gateways.MainMongoDB;
import usecases.FoodItemsDAI;
import usecases.PastOrdersDAI;

import java.util.ArrayList;

public class PastOrderController {
    private PastOrders pastOrders;
    private final PastOrdersDAI pastOrdersDAI = new MainMongoDB();

    public PastOrderController(String currUser){
        this.pastOrders = pastOrdersDAI.findPastOrders(currUser);
    }

    public PastOrders getItems(){
        return this.pastOrders;
    }
}
