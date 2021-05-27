import search.MagicNumberSearch;
import search.MagicSearch;
import search.contexts.NumberSearchContext;
import search.contexts.SearchContext;
import search.models.User;

import java.util.ArrayList;

public class Main {

    static void pritnResult(ArrayList<SearchContext> resultFromSearch, String searchKey) {
        System.out.println("===========================");
        System.out.println("Keyword : " + searchKey);
        System.out.println("===========================");
        if(resultFromSearch.size() == 0) {
            System.out.println("----------------------");
            System.out.println("No Data found");
            System.out.println("----------------------");
        } else {
            for(SearchContext context : resultFromSearch) {
                System.out.println("NIM          : " + context.user.nim);
                System.out.println("Name         : " + context.user.name);
                System.out.println("Address      : " + context.user.address);
                System.out.println("Search Index : " + (context.searchIndex + 1));
                System.out.println("Index        : " + (context.index + 1));
                System.out.println("--------------------------------");
            }
        }
    }


    static void userMagicSearch() {
        MagicSearch search = new MagicSearch();

        search.addSeed(new User("Andri Hariadi", "1102021", "BANDUNG"));
        search.addSeed(new User("Dewi Lestari", "1102022", "SURABAYA"));
        search.addSeed(new User("Dewi Agustin", "1102023", "MALANG"));
        search.addSeed(new User("Reni Indrayanti", "1102024", "MALANG"));
        search.addSeed(new User("Toni Sukmawan", "1102025", "SURABAYA"));
        search.addSeed(new User("Toni Gunawan", "1102026", "BANDUNG"));


        // main action
        System.out.println("===== Strict Search Data =====");
        String searchKey = "Toni";
        ArrayList<SearchContext> strictSearchResult = search.strictSearch(searchKey);
        pritnResult(strictSearchResult, searchKey);

        String fakeSearchKey = "Rudi";
        ArrayList<SearchContext> strictSearchResultNo = search.strictSearch(fakeSearchKey);
        pritnResult(strictSearchResultNo, fakeSearchKey);

        System.out.println("=========================================================");

        System.out.println("===== Non Strict Case Search Data =====");
        String searchKeyUnstrict = "toni";
        ArrayList<SearchContext> strictSearchUnstrictResult = search.unStrictSearch(searchKeyUnstrict);
        pritnResult(strictSearchUnstrictResult, searchKeyUnstrict);

        String fakeSearchKeyUnstrict = "rudi";
        ArrayList<SearchContext> strictSearchUnstrictResultNo = search.unStrictSearch(fakeSearchKeyUnstrict);
        pritnResult(strictSearchUnstrictResultNo, fakeSearchKeyUnstrict);
    }

    static void execNumSearch(MagicNumberSearch numberSearch, Integer numToSearch) {
        ArrayList<NumberSearchContext> resultFromSearch = numberSearch.numSearch(numToSearch);

        System.out.println("===========================");
        System.out.println("Keyword : " + numToSearch);
        System.out.println("===========================");
        if(resultFromSearch.size() == 0) {
            System.out.println("----------------------");
            System.out.println("No Data found");
            System.out.println("----------------------");
        } else {
            for(NumberSearchContext context : resultFromSearch) {
                System.out.println("Number       : " + context.num);
                System.out.println("Index        : " + (context.index + 1));
                System.out.println("--------------------------------");
            }
        }
    }

    static void numberMagicSearch() {
        MagicNumberSearch numberSearch = new MagicNumberSearch();
        for (int i = 0; i < 300; i++) {
            numberSearch.addSeed((int) Math.floor(Math.random() * 100) + 1);
        }


        execNumSearch(numberSearch, 10);
        execNumSearch(numberSearch, 21);
        execNumSearch(numberSearch, 23);
        execNumSearch(numberSearch, 13);
        execNumSearch(numberSearch, 48);


    }

    public static void main(String[] args) {

        /**
         * Magic search for number
         */
        numberMagicSearch();

        System.out.println("\n\n========================= Magic User Search ========================= \n\n");
        /**
         * Magic search for student
         */
        userMagicSearch();

    }
}
