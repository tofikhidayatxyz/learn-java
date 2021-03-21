package model;


public class Transaction {
    public int id;
    public Student student;
    public Book book;
    public int amount;
    
    public Transaction(int id, Student student, Book book, int amount) {
        this.id = id;
        this.student = student;
        this.book = book;
        this.amount = amount;
    }
}
