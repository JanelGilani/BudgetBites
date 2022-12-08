package entities.designpatterns;

import entities.FoodItem;

import java.util.ArrayList;

public class CurrentOrderIterator implements FoodItemIterator {

    private int position = 0;
    private final ArrayList<FoodItem> currentOrder;

    public CurrentOrderIterator (ArrayList<FoodItem> currentOrder) {
        this.currentOrder = currentOrder;
    }

    public boolean hasNext() {
        return this.position < this.currentOrder.size();
    }

    public FoodItem next() {
        FoodItem currItem = this.currentOrder.get(position);
        this.position += 1;
        return currItem;
    }
}
