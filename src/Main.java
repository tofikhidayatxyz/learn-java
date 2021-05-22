import java.util.ArrayList;
import java.util.Arrays;

import sort.MagicSort;

public class Main {
    public static void main(String[] args) {
        Integer sourceData[] = {10, 11, 2, 3, 5, 7, 3, 1};
        MagicSort magicSort = new MagicSort(sourceData);

        // Normal ascending
        System.out.println("Normal Ascending");
        MagicSort normalAsc = magicSort.manualAsc();
        System.out.println("Result         : " + Arrays.toString(normalAsc.getResult()));
        System.out.println("Swapped        : " + normalAsc.getTotalSwaped());
        System.out.println("Execution Time : " + normalAsc.getExecutionTime(false) + " Nano Second");
        System.out.println("===========================");

        // normal descending
        System.out.println("Normal Descending");
        MagicSort normalDesc = magicSort.manualDesc();
        System.out.println("Result         : " + Arrays.toString(normalDesc.getResult()));
        System.out.println("Swapped        : " + normalDesc.getTotalSwaped());
        System.out.println("Execution Time : " + normalDesc.getExecutionTime(false) + " Nano Second");
        System.out.println("===========================");


        // Auto ascending
        System.out.println("Auto Ascending");
        MagicSort autoAsc = magicSort.autoAsc();
        System.out.println("Result         : " + Arrays.toString(autoAsc.getResult()));
        System.out.println("Swapped        : " + autoAsc.getTotalSwaped());
        System.out.println("Execution Time : " + autoAsc.getExecutionTime(false) + " Nano Second");
        System.out.println("===========================");


        // Auto ascending
        System.out.println("Auto Descending");
        MagicSort autoDesc = magicSort.autoDesc();
        System.out.println("Result         : " + Arrays.toString(autoDesc.getResult()));
        System.out.println("Swapped        : " + autoDesc.getTotalSwaped());
        System.out.println("Execution Time : " + autoDesc.getExecutionTime(false) + " Nano Second");
        System.out.println("===========================");



    }
}
