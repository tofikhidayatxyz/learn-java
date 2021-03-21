package model;

public class Book {
    public int id;
    public String code;
    public String title;

    public Book(int id, String title, String code) {
        this.id = id;
        this.code = code;
        this.title = title;
    }
}
