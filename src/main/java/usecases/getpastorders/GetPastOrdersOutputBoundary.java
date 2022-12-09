package usecases.getpastorders;

import javax.swing.*;

public interface GetPastOrdersOutputBoundary {
    void foodInCart();

    JList<String> getList();
}
