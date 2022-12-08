package controllers;

import usecases.pastOrder.PastOrderInteractor;

import javax.swing.*;

public class PastOrderController {
    private PastOrderInteractor pastOrderInteractor;

    public PastOrderController(String currUser){
        this.pastOrderInteractor = new PastOrderInteractor(currUser);
    }

    public DefaultListModel<String> getPastOrder(){
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String s:
                pastOrderInteractor.getPastOrder()) {
            model.addElement(s);
        }
        return model;
    }
}
