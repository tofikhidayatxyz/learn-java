package com.property.controller;

import java.util.Scanner;
import com.property.model.Playlist;
import com.property.stack.PlaylistStack;

public class PlaylistController {

    PlaylistStack playlist = new PlaylistStack();

    // seed
    public void runSeed() {
        playlist.setPlaylist("Clouds", "NF");
        playlist.setPlaylist("Lie", "NF");
        playlist.setPlaylist("LOST", "NF");
        playlist.setPlaylist("Time For Alone", "Tofik");
        playlist.setPlaylist("Me time", "Tofik");
    }

    // view all
    public void viewAll() {
        System.out.println("======== Data Playlist ========");
        if(playlist.playlists.size() > 0) {
            for(int i = 0; i < playlist.playlists.size(); i++) {
                Playlist currentPlaylist = playlist.playlists.get(i);
                System.out.println("Id    : " + (i + 1));
                System.out.println("Name  : " +  currentPlaylist.title);
                System.out.println("Owner : " +  currentPlaylist.owner);
                System.out.println("------------------------");
            }
        } else {
            System.out.println("Playlist kosong");
            System.out.println("----------##----------");
        }
    }

    // insert data
    public void storePlaylist(Scanner scanner) {
        String title = "";
        String owner = "";
        int index = 0;

        System.out.println("======== Input Playlist ========");
        System.out.print("Playlist title                    : ");
        title = scanner.nextLine();
        System.out.print("Playlist owner                    : ");
        owner = scanner.nextLine();
        System.out.print("Masukan di urutan tertentu [skip] : ");
        try {
            index = Integer.parseInt(scanner.nextLine());
        } catch(Exception e) { }

        System.out.println("----------##----------");
        if(index > 0) {
            if(playlist.setPlaylist(title, owner, (index - 1))) {
                System.out.println("Berhasil input playlist di index : " + index);
            } else {
                System.out.println("Gagal input playlist di index : " + index );
            }
        } else {
            if(playlist.setPlaylist(title, owner)) {
                System.out.println("Berhasil input playlist");
            } else {
                System.out.println("Gagal input playlist");
            }
        }
        System.out.println("----------##----------");
    }

    // delete one
    public void deletePlaylist(Scanner scan) {
        String keyword = "";
        System.out.println("======== Remove Playlist ========");
        System.out.println("## Jika di isi kosong akan menghapus data awal");
        System.out.print("Masukan keyword [title/owner/urutan (di mulai dari 1)]: ");
        keyword = scan.nextLine();

        System.out.println("----------##----------");
        if(keyword.isBlank()) {
            if(playlist.deletePlaylist()) {
                System.out.println("Berhasil menghapus playlist awal");
            } else {
                System.out.println("Gagal menghapus playlist awal");
            }
        } else {
            Playlist currentPlaylist = playlist.findPlaylist(keyword);
            if(currentPlaylist != null) {
                if(playlist.deletePlaylist(currentPlaylist.id)) {
                    System.out.println("Berhasil menghapus playlist title : " + currentPlaylist.title + " owner : " + currentPlaylist.owner);
                } else {
                    System.out.println("Gagal menghapus playlist title : " + currentPlaylist.title + " owner : " + currentPlaylist.owner);
                }
            } else {
                System.out.println("Playlist dengan keyword " + keyword + " Tidak ditemukan");
            }
        }
        System.out.println("----------##----------");
    }

    // delete all
    public void deleteAll(Scanner scan) {
        String deleteAll;
        System.out.println("======== Remove All Playlist ========");
        System.out.print("Yakin untuk hapus semua playlist [Y/N]: ");
        deleteAll = scan.nextLine();

        System.out.println("----------##----------");
        if(deleteAll.toLowerCase().equals("y")) {
            if(playlist.deletePlaylist(true)) {
                System.out.println("Berhasil menghapus semua data playlist");
            } else {
                System.out.println("Gagal menghapus semua data playlist");
            }
        } else  {
            System.out.print("Tindakan menghapus di undurkan");
        }
        System.out.println("----------##----------");
    }


}
