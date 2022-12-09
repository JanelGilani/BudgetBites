package controllers;

import usecases.foodsuggestions.FoodSuggestionsInteractor;

public class FoodSuggestionsController {
    private FoodSuggestionsInteractor foodSuggestionsInteractor;

    public void setUseCase(FoodSuggestionsInteractor s){
        this.foodSuggestionsInteractor = s;
    }


    public void callUseCase(String username) {
        foodSuggestionsInteractor.toPresenter(username);
    }

}
