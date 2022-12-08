package presenters;

import controllers.GetPastOrdersController;

import javax.swing.*;
import java.awt.*;

public class GetPastOrdersPresenter extends JPanel implements usecases.getpastorders.GetPastOrdersOutputBoundary {
    private JScrollPane scroll;
    private GetPastOrdersController controller;
    private JList<String> list;

    public GetPastOrdersPresenter(GetPastOrdersController controller) {
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
