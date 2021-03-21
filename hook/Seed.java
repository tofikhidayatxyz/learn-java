package hook;
import java.util.*;
import model.*;

public class Seed {
    public static void seedStudent(ArrayList<Student> students) {
        students.add(new Student((students.size() + 1), "Arifa", "1"));
        students.add(new Student((students.size() + 1), "Stevanie", "2"));
        students.add(new Student((students.size() + 1), "Julius", "3"));
    }

    public static void seedBook(ArrayList<Book> books) {
        books.add(new Book((books.size() + 1), "Harry potter", "1"));
        books.add(new Book((books.size() + 1), "Jelly potter", "2"));
        books.add(new Book((books.size() + 1), "The history of jane doe", "3"));
    }

    public static void seedTransaction(ArrayList<Transaction> transactions,
                                        ArrayList<Book> books,
                                        ArrayList<Student> students) {
                                            
        transactions.add(new Transaction((transactions.size() + 1), students.get(0), books.get(0), 1));
        transactions.add(new Transaction((transactions.size() + 1), students.get(1), books.get(1), 3));
        transactions.add(new Transaction((transactions.size() + 1), students.get(2), books.get(2), 4));
        
    }
}
