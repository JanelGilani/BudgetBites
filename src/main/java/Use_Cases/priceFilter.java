package Use_Cases;

import Entities.foodItem;
import java.util.ArrayList;
import java.util.HashMap;

public class priceFilter {

    private HashMap<String, ArrayList<foodItem>> filter;

    private String filterName;

    public priceFilter(HashMap<String, ArrayList<foodItem>> filter, String filterName) {
        this.filter = filter;
        this.filterName = filterName;
    }

    public ArrayList<foodItem> filter(String p_range) {
        return filter.getOrDefault(p_range, null);
    }
}
