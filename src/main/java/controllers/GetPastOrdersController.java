package controllers;

import usecases.getpastorders.GetPastOrdersInteractor;

import javax.swing.*;



public class GetPastOrdersController {
    private final GetPastOrdersInteractor getPastOrdersInteractor;

    public GetPastOrdersController(String currUser){
        this.getPastOrdersInteractor = new GetPastOrdersInteractor(currUser);
    }

    public DefaultListModel<String> getPastOrder(){
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String s:
                getPastOrdersInteractor.getPastOrder()) {
            model.addElement(s);
        }
        return model;
    }
}
