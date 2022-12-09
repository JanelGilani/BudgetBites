package presenters;

import controllers.ModifyItemCartController;

import javax.swing.*;
import java.awt.*;

public class ModifyItemCartPresenter extends JPanel implements usecases.itemcart.ModifyItemCartOutputBoundary {
    private final JScrollPane scroll;
    private final ModifyItemCartController controller;
    private JList<String> list;

    public ModifyItemCartPresenter(ModifyItemCartController controller) {
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
        for(String val : controller.getItems())
            updatedModel.addElement(val);
        list = new JList<>(updatedModel);
        scroll.setViewportView(list);
    }

    @Override
    public JList<String> getList() {
        return list;
    }
}
