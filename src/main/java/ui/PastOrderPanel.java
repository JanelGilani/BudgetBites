package ui;

import controllers.ItemCartController;
import controllers.PastOrderController;
import entities.FoodItem;
import entities.PastOrders;
import entities.Order;
import presenters.ItemCartPresenter;
import presenters.PastOrderPresenter;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PastOrderPanel extends JPanel implements PastOrderPresenter {
    private JScrollPane scroll;
    private PastOrderController controller;
    private JList<String> list;

    public PastOrderPanel(PastOrderController controller) {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(420,500));
        scroll = new JScrollPane();
        this.controller = controller;
        list = new JList<>();
        scroll.setViewportView(list);
        list.setLayoutOrientation(JList.VERTICAL);
        this.add(scroll);
    }
    @Override
    public void foodInCart() {
        DefaultListModel<String> updatedModel = new DefaultListModel<>();
        PastOrders pastOrders = controller.getItems();
        String eachPastOrder = "";
        for(Order currOrder : pastOrders.getPastOrdersMap().values()) {
            eachPastOrder += currOrder.dateOrdered.substring(5,10);
            eachPastOrder += "   ";
            eachPastOrder += currOrder.restaurantName;
            eachPastOrder += "   ";

            String t = eachPastOrder;
            for(FoodItem ft : currOrder.getOrderedItems()){
                t += ft.getItemName();
                updatedModel.addElement(t);
                t = eachPastOrder;
            }

            eachPastOrder = "";
        }
        list = new JList<>(updatedModel);
        scroll.setViewportView(list);
    }

    @Override
    public JList<String> getList() {
        return list;
    }
}
