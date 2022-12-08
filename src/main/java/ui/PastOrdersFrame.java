package ui;

import controllers.GetPastOrdersController;
import presenters.GetPastOrdersPresenter;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PastOrdersFrame extends JFrame {
    private GetPastOrdersPresenter getPastOrdersPresenter;
    private GetPastOrdersController getPastOrdersController;
    private JButton backButton;
    private String currentUser;

    public PastOrdersFrame(String currentUser) {
        this.currentUser = currentUser;
        this.getPastOrdersController = new GetPastOrdersController(currentUser);
        this.getPastOrdersPresenter = new GetPastOrdersPresenter(getPastOrdersController);
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();

        this.setTitle("BudgetBites-Past Orders");
        this.setSize(420, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();;
        backButton = new JButton("Back");
        backButton.setBounds(10, 140, 165, 25);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
                UserPageFrame userPageFrame = new UserPageFrame(currentUser);
            }
        });
        bottom.add(backButton);

        getPastOrdersPresenter.foodInCart();

        this.add(top);
        this.add((JPanel) getPastOrdersPresenter);
        this.add(bottom);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new PastOrdersFrame("aryangoel24");
    }

    private void exit() {
        this.setVisible(false);
        this.dispose();
    }
}
