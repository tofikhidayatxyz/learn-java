import recursive.Fibonaci;
import recursive.Name;
import recursive.Rank;
import recursive.Row;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // rank recursive
        System.out.println("----- Perpangkatan 2^12 -----");
        Integer rankResult = Rank.makeRank(2, 0, 0, 12);
        System.out.println(rankResult);

        // fibonaci arrays
        System.out.println("----- Fibonaci -----");
        ArrayList<Integer> fibonaciResults = Fibonaci.makeFibonaci(0,0, 0, 20, new ArrayList<>());
        System.out.println(fibonaciResults);

        // deret/rows
        System.out.println("----- Deret -----");
        ArrayList<Integer> rowResults = Row.makeRows(2, 1, 0, 50, new ArrayList<>());
        System.out.println(rowResults);

        // name loop 100x <binding arrays>
        System.out.println("----- Nama 100x -----");
        ArrayList<String> nameResults = Name.generateName("Tofik Hidayat", 0, 100, new ArrayList<>());
        System.out.println(nameResults);

    }
}
