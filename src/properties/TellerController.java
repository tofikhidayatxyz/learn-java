package properties;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;
import properties.TellerQueue;
import java.util.ArrayList;

public class TellerController {
    private String fakeQueueData[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    TellerQueue queues = new TellerQueue();

    public void runSeed() {
        for(String itm : this.fakeQueueData) {
            this.queues.addQueue(itm);
        }
    }

    public void showAll() {
        Integer list = 1;
        Integer itm = 1;
        System.out.println("=== Daftar antrian ===");

        if(this.queues.showAll().size() == 0) {
            System.out.println("Data nya di makan biawak  :v");
        } else {
            for(ArrayList<String> queueList : this.queues.showAll()) {
                System.out.println("---- Jalur " + list + " ----");
                for (String qq : queueList) {
                    System.out.println("-----------");
                    System.out.println("Antrian ke   : " + itm);
                    System.out.println("Nama Antrian : " + qq);
                    System.out.println("-----------");
                    itm++;
                }
                list++;
            }
        }
    }

    public void addQueue(Scanner scan) {
        String name;
        System.out.println("=== Input Daftar antrian ===");
        System.out.print("Nama Antrian : ");
        name = scan.nextLine();
        this.queues.addQueue(name);
        System.out.println("=== Berhasil input data ===");
    }

    public void removeQueue(Scanner scan) {
        String keyword;
        System.out.println("=== Hapus daftar antrian ===");
        System.out.println("[keyword], [Blank remove first]");
        System.out.print("Masukan keyword : ");
        keyword = scan.nextLine();

        if(keyword.isBlank()) {
            this.queues.removeQueue();
        } else {
            this.queues.removeQueue(keyword);
        }
    }

    public void removeAllQueue(Scanner scan) {
        String arg = "";
        System.out.println("=== Hapus semua antrian ===");
        System.out.print("Yakin hapus semua data ? [Y/N] : ");
        arg = scan.nextLine();

        if(arg.equalsIgnoreCase("y")) {
            this.queues.removeAll();
        } else {
            System.out.println("Batal menghapus data :)");
        }
    }
}
