package ui;

import controllers.ItemCartController;
import controllers.PastOrderController;
import gateways.MainMongoDB;
import presenters.ItemCartPresenter;
import presenters.PastOrderPresenter;
import usecases.BudgetDAI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PastOrdersFrame extends JFrame {
    private PastOrderPresenter pastOrderPresenter;
    private PastOrderController pastOrderController;
    private JButton backButton;
    private String currentUser;

    public PastOrdersFrame(PastOrderController pastOrderController, String currentUser) {
        this.currentUser = currentUser;
        this.pastOrderController = pastOrderController;
        this.pastOrderPresenter = new PastOrderPanel(pastOrderController);
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

        pastOrderPresenter.foodInCart();

        this.add(top);
        this.add((JPanel) pastOrderPresenter);
        this.add(bottom);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        PastOrderController controller = new PastOrderController("aryangoel24");
        new PastOrdersFrame(controller, "aryangoel24");
    }

    private void exit() {
        this.setVisible(false);
        this.dispose();
    }
}
