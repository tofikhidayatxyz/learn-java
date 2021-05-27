package search;

import java.util.ArrayList;
import java.util.Locale;

import search.contexts.SearchContext;
import search.models.User;

public class MagicSearch {
    public ArrayList<User> userToSearch = new ArrayList<>();

    public void addSeed(User user) {
        this.userToSearch.add(user);
    }

    /**
     * Linear search with user data
     * @param name
     * @return ArrayList<SearchContext>
     */

    public ArrayList<SearchContext> strictSearch(String name) {
        ArrayList<SearchContext> result = new ArrayList<>();
        for(int i  = 0; i < this.userToSearch.size(); i++) {
            User currentUser = this.userToSearch.get(i);
            if(currentUser.name.indexOf(name) >= 0) {
                result.add(new SearchContext(currentUser, i, currentUser.name.indexOf(name)));
            }
        }
        return result;
    }

    public ArrayList<SearchContext> unStrictSearch(String name) {
        ArrayList<SearchContext> result = new ArrayList<>();
        for(int i  = 0; i < this.userToSearch.size(); i++) {
            User currentUser = this.userToSearch.get(i);
            if(currentUser.name.toLowerCase().indexOf(name.toLowerCase()) >= 0) {
                result.add(new SearchContext(currentUser,
                                                i,
                                                currentUser.name
                                                            .toLowerCase()
                                                            .indexOf(name.toLowerCase())
                ));
            }
        }
        return result;
    }


}
