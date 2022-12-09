package ui;

import controllers.ModifyItemCartController;
import presenters.PriceFilterPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
@SuppressWarnings({"ALL", "unused"})
public class FoodItemsFrame extends JFrame implements ActionListener {
    private static JLabel userPriceLabel;
    private static JComboBox userPriceText;
    private static JButton submitButton;
    private static JButton addToItemCartButton;
    private static JButton itemCartButton;
    private static JButton backButton;
    private PriceFilterPresenter priceFilterPresenter;
    private ModifyItemCartController modifyItemCartController;
    private String currentUser;
    private String restaurantName;

    public FoodItemsFrame(String restaurantName, String currentUser) {

        modifyItemCartController = new ModifyItemCartController(restaurantName);
        this.restaurantName = restaurantName;
        this.currentUser = currentUser;

        JPanel panel = new JPanel();
        JPanel bottom = new JPanel();
        this.setTitle("BudgetBites-Menu");
        this.setSize(420, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(100, 100));

        // the user label for user price preference text
        userPriceLabel = new JLabel("Price Preference");
        userPriceLabel.setBounds(10, 20, 120, 25);
        panel.add(userPriceLabel);
        // combobox for the user to choose their price preference
        String[] priceRanges = {"No Preference", "$0 to $5", "$5 to $10", "$10 to $15", "$15 to $20", "$20 to $25", "$25+"};
        userPriceText = new JComboBox(priceRanges);
        userPriceText.setBounds(140, 20 , 165, 25);
        panel.add(userPriceText);

        // Submit button.
        submitButton = new JButton("Submit Preferences");
        submitButton.setBounds(10, 110, 160, 25);
        submitButton.addActionListener(this);
        panel.add(submitButton);
        this.add(panel);

        backButton = new JButton("Back");
        backButton.setBounds(10, 150, 165, 25);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
                RestaurantListFrame restaurantListFrame = new RestaurantListFrame(currentUser);
            }
        });
        panel.add(backButton);

        priceFilterPresenter = new PriceFilterPresenter(restaurantName);
        priceFilterPresenter.allFoods();
        this.add((JPanel) priceFilterPresenter);

        addToItemCartButton = new JButton("Add to Item Cart");
        addToItemCartButton.setBounds(10, 110, 160, 25);
        addToItemCartButton.addActionListener(this);

        itemCartButton = new JButton("View Item Cart");
        itemCartButton.setBounds(10, 110, 160, 25);
        itemCartButton.addActionListener(this);

        bottom.add(addToItemCartButton);
        bottom.add(itemCartButton);
        this.add(bottom);
        this.pack();
        this.setVisible(true);

    }

    /*public static void Main(String[] args) {
        new FoodItemsFrame("Food from East", this.currentUser);
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == submitButton) {
            priceFilterPresenter.updateFoods((String) userPriceText.getSelectedItem());
            this.validate();
        }else if (obj == addToItemCartButton) {
            JList<String> selection = priceFilterPresenter.getList();
            String choice = selection.getSelectedValue();
            modifyItemCartController.addToItemCart(choice);
        }else if (obj == itemCartButton) {
            exit();
            new ItemCartFrame(modifyItemCartController, restaurantName, currentUser);
        }
    }
    private void exit() {
        this.setVisible(false);
        this.dispose();
    }
}
