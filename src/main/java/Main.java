import entity.*;
import execption.BookAlreadyBorrowedException;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        List<Book> borrowedBooksVasya = new ArrayList<>();
        List<Book> borrowedBooksPetya = new ArrayList<>();
        List<Book> borrowedBooksPhilosophyTeacher = new ArrayList<>();
        List<Book> borrowedBooksMatchTeacher = new ArrayList<>();
        Member vasya = new Student("vasya", "123", borrowedBooksVasya, 11);
        Member petya = new Student("petya", "224783", borrowedBooksPetya, 17);
        Member philosophyTeacher = new Teacher("Masha", "235783", borrowedBooksPhilosophyTeacher, "philosophy");
        Member matchTeacher = new Teacher("Inna", "247833", borrowedBooksMatchTeacher, "match");
        Book javaBook = new Book("Thinking in Java","Bruce Eckel", "5645", true);
        Book pythonBook = new Book("Python Programming for the Absolute Beginner","Michael Dawson", "545", true);
        Book swiftBook = new Book("Swift Cookbook.","Chris Barker", "75758", true);

        library.addBook(javaBook);
        library.addBook(pythonBook);
        library.addBook(swiftBook);
        library.addNewMember(vasya);
        library.addNewMember(petya);
        library.addNewMember(philosophyTeacher);
        library.addNewMember(matchTeacher);
        library.listOfAllReaders();
        try {
            library.takeBook(petya, pythonBook);
            library.takeBook(vasya, "Thinking in Java");
        } catch (BookAlreadyBorrowedException e) {
            System.out.println("ошибка: " + e.getMessage());
        }
        library.returnBook(petya, pythonBook);
        library.deleteBookById("5645");
        library.deleteMemberById("247833");
    }
}
