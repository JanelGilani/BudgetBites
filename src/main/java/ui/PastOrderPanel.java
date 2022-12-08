package ui;

import controllers.PastOrderController;
import presenters.PastOrderPresenter;

import javax.swing.*;
import java.awt.*;

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
        list = new JList<>(controller.getPastOrder());
        scroll.setViewportView(list);
    }

    @Override
    public JList<String> getList() {
        return list;
    }
}
