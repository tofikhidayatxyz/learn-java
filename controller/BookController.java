package controller;

import java.util.*;
import hook.*;
import model.*;

public class BookController {

    // view all book
    public static void viewAllBook(ArrayList<Book> books) {
        Util.clearConsole();
        System.out.println("============ Data Buku =============");
        for(Book book : books) {
            System.out.println("Id        : " + book.id);
            System.out.println("Nama buku : " + book.title);
            System.out.println("Kode buku : " + book.code);
            Util.printSimpleLine();
        }
        Util.printSpace();
    }
    
    // add one book
    public static void addBook(Scanner scanner, ArrayList<Book> books) {
        Util.clearConsole();
        String title = "";
        String code = "";
        System.out.println("========= Input Data Buku ========= ");
        System.out.print("Masukan Nama Buku : ");
        title = scanner.nextLine();
        System.out.print("Masukan Kode Buku : ");
        code = scanner.nextLine();
        books.add(new Book((books.size() + 1), title, code));
        Util.printLine();
    }

    // remove book by keyword
    public static void removeBook(Scanner scanner, ArrayList<Book>books) {
        String keyword  = "";
        Util.clearConsole();
        System.out.println("========= Hapus Data Buku ========= ");
        System.out.print("Masukan keyword [title/kode/id] : ");
        keyword = scanner.nextLine();
        // loop and delete
        int targetId = findToId(books, keyword);
        if(targetId >= 0) {
            Book currentBook = books.get(targetId);
            System.out.println("Deleting name : " + currentBook.title + " nim : " + currentBook.code);
            books.remove(targetId);
        } else {
            System.out.println("Buku " + keyword + " tidak terdaftar");
        }
    }

    // find book
    public static int findToId(ArrayList<Book> books, String keyword) {
        for(int i = 0; i < books.size(); i++) {
            Book currentBook = books.get(i);
            if(currentBook.code.toLowerCase().equals(keyword)
                || currentBook.title.toLowerCase().equals(keyword)
                || currentBook.id == Integer.parseInt(keyword)
                ) {
                return i;
            }
        }
        return -1;
    }
}
