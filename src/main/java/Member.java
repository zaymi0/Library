import java.util.ArrayList;

public class Member {
    String name;
    String id;
    ArrayList<Book> borrowedBooks;

    Member(String name, String id, ArrayList<Book> borrowedBooks) {
        this.name = name;
        this.id = id;
        this.borrowedBooks = borrowedBooks;
    }
}
