package entity;

import java.util.List;

public class Member  {
    private String name;
    private String id;
    private final List<Book> borrowedBooks;

     public Member(String name, String id, List<Book> borrowedBooks) {
        this.name = name;
        this.id = id;
        this.borrowedBooks = borrowedBooks;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public String getInfo() {
        return String.format("mame: %s, id: %s", getName(), getId());
    }
}
