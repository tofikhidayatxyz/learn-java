import java.util.Scanner;

import properties.TellerController;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer prompt = 1;
        TellerController queue = new TellerController();

        // run seed
        queue.runSeed();
        // run action
        while (prompt > 0 && prompt < 5) {
            System.out.println("===== Daftar Antrian Bank Mangkiri =====");
            System.out.println("1. Tampilkan semua antrian");
            System.out.println("2. Tambah antrian");
            System.out.println("3. Hapus antrian");
            System.out.println("4. Hapus semua antrian");
            System.out.print("Pilih Menu : ");

            try {
                prompt = Integer.parseInt(scan.nextLine());
            } catch(NumberFormatException e) {
                prompt = 0;
            }

            switch (prompt) {
                case 1 :
                    queue.showAll();
                    break;
                case 2 :
                    queue.addQueue(scan);
                    break;
                case 3 :
                    queue.removeQueue(scan);
                    break;
                case 4 :
                    queue.removeAllQueue(scan);
            }
        }

        scan.close();

    }
}
