package search;

import search.contexts.NumberSearchContext;
import java.util.ArrayList;

public class MagicNumberSearch {
    public ArrayList<Integer> numberToSearch = new ArrayList<>();

    public void addSeed(Integer num) {
        this.numberToSearch.add(num);
    }

    /**
     * Linear search with integer data
     * @param key
     * @return ArrayList<Integer>
     */

    public ArrayList<NumberSearchContext> numSearch(Integer key) {
        ArrayList<NumberSearchContext> result = new ArrayList<>();
        for(int i  = 0; i < this.numberToSearch.size(); i++) {
            Integer currentNum = this.numberToSearch.get(i);
            if(currentNum == key) {
                result.add(new NumberSearchContext(currentNum, i));
            }
        }
        return result;
    }
}
