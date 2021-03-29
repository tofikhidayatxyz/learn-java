import java.util.Scanner;

import com.property.controllers.TellerController;

public class Main {

    public static void main(String[] args) {
        final Integer maxQueueInLine = 10;
        Integer propmt = 1;
        Scanner scan  = new Scanner(System.in);
        TellerController teller = new TellerController(maxQueueInLine);

        /**
         * Run seed for first run
         */

        teller.runSeed();

        /**
         * Run main action
         */
        while (propmt > 0 && propmt < 5) {
            System.out.println("===== Mangkiri Antrian Menu =====");
            System.out.println("1. Tampilkan antrian");
            System.out.println("2. Tambah antrian");
            System.out.println("3. Hapus antrian");
            System.out.println("4. Hapus semua antrian");

            /**
             * Trying to parse input to Integer
             */
            System.out.print("Masukan nomor menu : ");
            try {
                propmt = Integer.parseInt(scan.nextLine());
            } catch(NumberFormatException e) {
                propmt = 0;
            }

            switch (propmt) {
                case 1 -> teller.viewAll();
                case 2 -> teller.addQueue(scan);
                case 3 -> teller.removeQueue(scan);
                case 4 -> teller.removeAll(scan);
            }

        }

        scan.close();
        System.out.println("Program Ended");
    }
}
