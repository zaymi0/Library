package entity;

import execption.BookAlreadyBorrowedException;
import execption.BookNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {
    private List<Book> collectionOfBooks = new ArrayList<>();
    private List<Member> membersList = new ArrayList<>();

    public void takeBook(Member member, Book book) throws BookAlreadyBorrowedException {
        if(!book.getIsAvailable()) {
            throw new BookAlreadyBorrowedException("Книга занята");
        } else {
            member.getBorrowedBooks().add(book);
            book.setIsAvailable(false);
        }
    }

    public void addBook(Book book) {
        collectionOfBooks.add(book);

    }

    public void deleteBookById(String bookId) {
        collectionOfBooks.removeIf(book -> book.getId().equals(bookId));
    }

    public void returnBook(Member member, Book book) {
        member.getBorrowedBooks().remove(book);
        book.setIsAvailable(true);
    }

    public void addNewMember(Member member) {
        membersList.add(member);
    }

    public void listOfAllReaders() {
        for (Member member : membersList) {
            System.out.println(member.getInfo());
        }
    }

    public void deleteMemberById(String memberId) {
        collectionOfBooks.removeIf(book -> book.getId().equals(memberId));
    }

    public void takeBook(Member member, String bookName) throws BookAlreadyBorrowedException, BookNotFoundException {
        takeBook(member, findBookByTitle(bookName));
    }

    public Book findBookByTitle(String bookName) throws BookNotFoundException {
        return collectionOfBooks.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(bookName))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("Книга не найдена"));
    }
}
