package ui;
import controllers.FoodSuggestionsController;
import presenters.FoodSuggestionViewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings({"ALL", "unused"})
public class userSuggestionFrame extends JFrame implements FoodSuggestionViewer, ActionListener {

    private static JButton button;
    private static JButton backButton;
    private static JLabel label;

    private FoodSuggestionsController foodSuggestionsController;
    private ArrayList<String> returnArrayList;

    private JList<String> list;
    private JScrollPane scroll;

    private JPanel panel;

    private JPanel top;
    private JPanel bottom;
    private String currentUser;

    public void setFoodSuggestionsController(FoodSuggestionsController foodSuggestionsController) {
        this.foodSuggestionsController = foodSuggestionsController;
    }

    /**
     * Creating UI JPanel and Jframe
     * @param currentUser
     */

    public userSuggestionFrame(String currentUser) {
        this.currentUser = currentUser;
        panel = new JPanel();
        top = new JPanel();
        bottom = new JPanel();
        this.setBackground(Color.WHITE);
        this.setTitle("BudgetBites - Suggestions");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setSize(new Dimension(420,600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setSize(new Dimension(420,450));

        top.setSize(new Dimension(420, 75));
        bottom.setSize(new Dimension(420, 75));

        DefaultListModel<String> model = new DefaultListModel<>();
        scroll = new JScrollPane();
        list = new JList<>(model);
        scroll.setViewportView(list);
        panel.add(scroll);

        // Label for action performed on button click
        label = new JLabel("xxx");
        label.setBounds(10, 20, 100, 25);

        button = new JButton("Display Suggestions");
        button.setBounds(100, 200, 200, 25);
        button.addActionListener(this);

        backButton = new JButton("Back");
        button.setBounds(100, 200, 200, 25);
        button.addActionListener(this);

        top.add(button);
        bottom.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
                RestaurantListFrame restaurantListFrame = new RestaurantListFrame(currentUser);
            }
        });
        this.add(top);
        this.add(panel);
        this.add(bottom);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultListModel<String> model = new DefaultListModel<>();
        for(String val : returnArrayList)
            model.addElement(val);
        list = new JList<>(model);
        scroll.setViewportView(list);

        list.setLayoutOrientation(JList.VERTICAL);
        System.out.println(returnArrayList.toString());
        this.validate();

    }
    @Override
    public void viewData(ArrayList<String> viewData) {
        returnArrayList = viewData;
    }

    private void exit() {
        this.setVisible(false);
        this.dispose();
    }
}
