package Use_Cases;

import Entities.Restaurant;
import java.util.ArrayList;
import java.util.HashMap;

public class priceFilter {

    private HashMap<String, ArrayList<Restaurant>> filter;

    private String filterName;

    public priceFilter(HashMap<String, ArrayList<Restaurant>> filter, String filterName) {
        this.filter = filter;
        this.filterName = filterName;
    }

    public ArrayList<Restaurant> filter(String p_range) {
        return filter.getOrDefault(p_range, null);
    }
}
