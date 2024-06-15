package entity;

import java.util.List;

public class Member  {
    private String name;
    private String id;
    private List<Book> borrowedBooks;

     public Member(String name, String id, List<Book> borrowedBooks) {
        this.name = name;
        this.id = id;
        this.borrowedBooks = borrowedBooks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void returnBorrowedBook(Book book) {
        this.borrowedBooks.remove(book);
    }

    public void addBorrowedBook(Book borrowedBook) {
        this.borrowedBooks.add(borrowedBook);
    }

    public String getInfo() {
        return String.format("mame: %s, id: %s", getName(), getId());
    }
}
