package controller;

import java.util.*;
import hook.*;
import model.*;

public class TransactionController {
    // view all transaction
    public static void viewAllTransaction(ArrayList<Transaction> transactions) {
        Util.clearConsole();
        System.out.println("============ Data Buku =============");
        for(Transaction  transaction : transactions){
            System.out.println("Id            : " + transaction.id);
            System.out.println("Nama peminjam : " + transaction.student.name);
            System.out.println("NIM peminjam  : " + transaction.student.nim);
            System.out.println("Nama buku     : " + transaction.book.title);
            System.out.println("Kode buku     : " + transaction.book.code);
            System.out.println("Jumlah pinjam : " + transaction.amount);
            Util.printSimpleLine();
        }
        Util.printSpace();
    }
    
    // add one transaction
    public static void addTransaction(Scanner scanner,
                                        ArrayList<Transaction> transactions,
                                        ArrayList<Student> students,
                                        ArrayList<Book> books) {
        Util.clearConsole();

        Student student = null;
        Book book = null;
        int amount;
        // find student
        System.out.println("========= Input Data Transaksi ========= ");
        while(student == null) {
            System.out.print("Masukan keyword [nama/nim/id] murid  : ");
            String keyword = scanner.nextLine();
            int studentId = StudentController.findToId(students, keyword);
            if(studentId >= 0) {
                student = students.get(studentId);
            } else {
                System.out.println("Murid " + keyword + " tidak terdaftar");
            }
        }

        // find book
        while(book == null) {
            System.out.print("Masukan keyword [judul/kode/id] buku : ");
            String keyword = scanner.nextLine();
            int bookId = BookController.findToId(books, keyword);
            if(bookId >= 0) {
                book = books.get(bookId);
            } else {
                System.out.println("Buku " + keyword + " tidak terdaftar");
            }
        }

        // insert amount
        System.out.print("Masukan jumlah pinjam                : ");
        amount = Integer.parseInt(scanner.nextLine());
        // attach to transation
        transactions.add(new Transaction((transactions.size() + 1), student, book, amount));
        System.out.println("Berhasil menambah transaksi");
        Util.printLine();
    }

    // remove transaction by keyword
    public static void removeTransaction(Scanner scanner, ArrayList<Transaction>transactions) {
        String keyword;
        Util.clearConsole();
        System.out.println("========= Hapus Data Transaksi ========= ");
        System.out.print("Masukan keyword [id] : ");
        keyword = scanner.nextLine();
        // loop and delete
        int targetId = findToId(transactions, keyword);
        if(targetId >= 0) {
            Transaction currentTransaction = transactions.get(targetId);
            System.out.println("Deleting transaction : "
                                + targetId
                                + " student : "
                                + currentTransaction.student.name
                                + ", book : "
                                + currentTransaction.book.title
                                + ", amount : "
                                + currentTransaction.amount);
            transactions.remove(targetId);
        } 
    }

    // find transaction
    public static int findToId(ArrayList<Transaction> transactions, String keyword) {
        for(int i = 0; i < transactions.size(); i++) {
            if((i + 1) == Integer.parseInt(keyword)) {
                return i;
            }
        }
        return -1;
    }
}
