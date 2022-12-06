package ui;

import controllers.ItemCartController;
import presenters.ItemCartPresenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemCartFrame extends JFrame implements ActionListener {
    private static JButton backButton;
    private static JButton removeFromCartButton;
    private static JButton makeOrderButton;
    private ItemCartPresenter itemCartPresenter;
    private String restaurantName;
    private ItemCartController itemCartController;
    private String itemCartCost;
    private static JLabel itemCartCostLabel;

    public ItemCartFrame(ItemCartController itemCartController, String restaurantName) {
        this.restaurantName = restaurantName;
        this.itemCartController = itemCartController;
        this.itemCartPresenter = new ItemCartPanel(itemCartController);
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();

        this.setTitle("BudgetBites-ItemCart");
        this.setSize(420, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        itemCartCost = "Price of Cart: $" + itemCartController.getItemCartCost();
        itemCartCostLabel = new JLabel(itemCartCost);
        itemCartCostLabel.setBounds(10, 20, 120, 25);
        top.add(itemCartCostLabel);

        backButton = new JButton("Back");
        backButton.setBounds(10, 110, 160, 25);
        backButton.addActionListener(this);

        removeFromCartButton = new JButton("Remove From Cart");
        removeFromCartButton.setBounds(10, 110, 160, 25);
        removeFromCartButton.addActionListener(this);

        makeOrderButton = new JButton("Order");
        makeOrderButton.setBounds(10, 110, 160, 25);
        makeOrderButton.addActionListener(this);

        bottom.add(backButton);
        bottom.add(removeFromCartButton);
        bottom.add(makeOrderButton);

        itemCartPresenter.foodInCart();

        this.add(top);
        this.add((JPanel) itemCartPresenter);
        this.add(bottom);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        ItemCartController controller = new ItemCartController("Food from East");
        controller.addToItemCart("Chicken Shawarma - Price $5");
        new ItemCartFrame(controller, "Food from East");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == backButton) {
            exit();
            new FoodItemsFrame(restaurantName);
        } else if (obj == removeFromCartButton) {
            JList<String> selection = itemCartPresenter.getList();
            String choice = selection.getSelectedValue();
            itemCartController.removeFromItemCart(choice);
            itemCartPresenter.foodInCart();
            itemCartCost = "Price of Cart: $" + itemCartController.getItemCartCost();
            itemCartCostLabel.setText(itemCartCost);
            this.validate();
        }

    }

    private void exit() {
        this.setVisible(false);
        this.dispose();
    }
}
