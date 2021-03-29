package com.property.controllers;
import com.property.services.TellerQueueService;
import com.property.models.TellerQueue;
import java.util.ArrayList;
import java.util.Scanner;

public class TellerController {

    private Integer maxItemInlist;
    private String fakeQueueData[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private TellerQueueService teller;

    // constructor
    public TellerController(Integer maxItemInlist) {
        this.maxItemInlist = maxItemInlist;
        this.teller = new TellerQueueService(maxItemInlist);
    }

    // run seeder
    public void runSeed() {
        for (String itm : this.fakeQueueData) {
            this.teller.addQueue(itm, teller.lastQueueNumber());
        }
    }

    // view all queues
    public void viewAll() {
        System.out.println("===== Daftar Antrian =====");
        Integer currentList = 1;
        if(this.teller.viewAll().size() == 0) {
            System.out.println("---- Tidak ada data ---");
        } else {
            for (ArrayList<TellerQueue> list : this.teller.viewAll()) {
                System.out.println("\n== Antrian Level ke " + currentList + " ==\n");
                Integer currentItm = 1;
                for (TellerQueue itm : list) {
                    System.out.println("-------------------");
                    System.out.println("Antrian ke     : " + currentItm);
                    System.out.println("Nomor antrian  : " + itm.queueNumber);
                    System.out.println("Nama Pengantri : " + itm.name);
                    System.out.println("-------------------");
                    currentItm++;
                }
                currentList++;
            }
        }
    }

    // add new queue
    public void addQueue(Scanner scan) {
        String name;
        Integer queueNumber = this.teller.lastQueueNumber();
        System.out.println("===== Input Antrian =====");
        System.out.print("Masukan nama pengantri : ");
        name = scan.nextLine();
        this.teller.addQueue(name, queueNumber);
        System.out.println("===== Berhasil input antrian =====");
    }

    // remove queue
    public void removeQueue(Scanner scan) {
        String keyword;
        System.out.println("===== Hapus antrian =====");
        System.out.println("Keyword[no antrian, nama] [C Batal], [Blank hapus data pertama]");
        System.out.print("Masukan Keyword : ");
        keyword = scan.nextLine();
        if(keyword.equalsIgnoreCase("c")) {
            System.out.println("Batal menghapus antrian");
        } else if(keyword.isBlank()) {
            this.teller.remove();
        } else {
            this.teller.remove(keyword);
        }
    }

    // remove all queues
    public void removeAll(Scanner scan) {
        String arg;
        System.out.println("===== Hapus semua antrian =====");
        System.out.println("Yakin untuk menghapus semua antrian");
        System.out.print("[Y/N] : ");
        arg = scan.nextLine();

        if (arg.equalsIgnoreCase("y")) {
            this.teller.removeAll();
            System.out.println("Berhasil menghapus semua data");
        } else {
            System.out.println("Batal menghapus semua data");
        }

    }
}
