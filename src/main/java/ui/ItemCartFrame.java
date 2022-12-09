package ui;

import controllers.ModifyItemCartController;
import entities.Budget;
import entities.PastOrders;
import gateways.MainMongoDB;
import presenters.ModifyItemCartPresenter;
import usecases.BudgetDAI;
import usecases.budgeting.BudgetingInteractor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
@SuppressWarnings({"ALL", "unused"})
public class ItemCartFrame extends JFrame implements ActionListener {
    private final BudgetDAI budgetDAI = new MainMongoDB();
    private final BudgetingInteractor budgetingInteractor = new BudgetingInteractor();
    private static JButton backButton;
    private static JButton removeFromCartButton;
    private static JButton makeOrderButton;
    private ModifyItemCartPresenter modifyItemCartPresenter;
    private String restaurantName;
    private ModifyItemCartController modifyItemCartController;
    private String itemCartCost;
    private static JLabel itemCartCostLabel;
    private String currentUser;

    public ItemCartFrame(ModifyItemCartController modifyItemCartController, String restaurantName, String currentUser) {
        this.currentUser = currentUser;
        this.restaurantName = restaurantName;
        this.modifyItemCartController = modifyItemCartController;
        this.modifyItemCartPresenter = new ModifyItemCartPresenter(modifyItemCartController);
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();

        this.setTitle("BudgetBites-ItemCart");
        this.setSize(420, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        itemCartCost = "Price of Cart: $" + modifyItemCartController.getItemCartCost();
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

        modifyItemCartPresenter.foodInCart();

        this.add(top);
        this.add((JPanel) modifyItemCartPresenter);
        this.add(bottom);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        ModifyItemCartController controller = new ModifyItemCartController("Food from East");
        controller.addToItemCart("Chicken Shawarma - Price $5");
        new ItemCartFrame(controller, "Food from East", "mann1234");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == backButton) {
            exit();
            new FoodItemsFrame(restaurantName, currentUser);
        } else if (obj == removeFromCartButton) {
            JList<String> selection = modifyItemCartPresenter.getList();
            String choice = selection.getSelectedValue();
            modifyItemCartController.removeFromItemCart(choice);
            modifyItemCartPresenter.foodInCart();
            itemCartCost = "Price of Cart: $" + modifyItemCartController.getItemCartCost();
            itemCartCostLabel.setText(itemCartCost);
            this.validate();
        } else if (obj == makeOrderButton) {
            modifyItemCartController.makeOrder(restaurantName, currentUser);
            Budget userBudget = budgetDAI.getUserBudget(currentUser);
            PastOrders orders = (PastOrders) budgetDAI.findPastOrders(currentUser);
            BudgetingInteractor.orderedMealsBudget(userBudget, orders);
            budgetDAI.updateAttributeByUsername(currentUser, "budget", userBudget);
            exit();
            new UserPageFrame(currentUser);
        }

    }

    private void exit() {
        this.setVisible(false);
        this.dispose();
    }
}
