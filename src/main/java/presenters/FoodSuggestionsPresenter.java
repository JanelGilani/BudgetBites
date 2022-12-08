package presenters;

import usecases.foodsuggestions.FoodSuggestionsOutputBoundary;

import java.util.ArrayList;

public class FoodSuggestionsPresenter implements FoodSuggestionsOutputBoundary {
    private FoodSuggestionViewer viewer;

    public void setViewer(FoodSuggestionViewer viewer) {
        this.viewer = viewer;
    }

    @Override
    public void presentData(ArrayList<String> data) {
        viewer.viewData(data);
    }
}
