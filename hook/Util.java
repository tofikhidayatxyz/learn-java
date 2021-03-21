package hook;

import java.util.*;

public class Util {
    public static void printLine() {
        System.out.println("====================================");
    }
    
    public static void printSimpleLine() {
        System.out.println("------------------------------------");
    }

    public static void clearConsole() {
        System.out.print("\033\143");
    }

    public static void  printSpace() {
        System.out.println("");
    }

    public static void showMenu() {
        System.out.println("========== Daftar Menu ==========");
        System.out.println("1. Tampilkan Data Mahasiswa");
        System.out.println("2. Tambah Data Mahasiswa");
        System.out.println("3. Hapus Data Mahasiswa");
        System.out.println("4. Tampilkan Data Buku");
        System.out.println("5. Tambah Data Buku");
        System.out.println("6. Hapus Data Buku");
        System.out.println("7. Tampilkan Transaksi");
        System.out.println("8. Tambah Transaksi");
        System.out.println("9. Hapus Transaksi");
        System.out.println("NA. Exit");
    }

    // propmt to user
    public static String promptMenu(String text, Scanner scanner) {
        System.out.print(text);
        String prompt = scanner.nextLine();
        return prompt;
    }

}
