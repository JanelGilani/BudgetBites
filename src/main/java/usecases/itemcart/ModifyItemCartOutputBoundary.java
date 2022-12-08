package usecases.itemcart;

import javax.swing.*;

public interface ModifyItemCartOutputBoundary {
    void foodInCart();

    JList<String> getList();
}
