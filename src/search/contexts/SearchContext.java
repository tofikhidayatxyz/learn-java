package search.contexts;

import search.models.User;

public class SearchContext {
    public User user;
    public Integer index;
    public Integer searchIndex;

    public SearchContext(User user, Integer index, Integer searchIndex) {
        this.user = user;
        this.index = index;
        this.searchIndex = searchIndex;
    }
}
