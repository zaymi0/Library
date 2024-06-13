import java.util.ArrayList;
import java.util.Scanner;

public class WorkingWithBooks {

    public static void addBook(ArrayList<Book> collectionOfBooks) {
        Scanner scanner = new Scanner(System.in);
        Book newBook = new Book("", "", "", true);
        System.out.println("title");
        newBook.title = scanner.nextLine();
        System.out.println("author");
        newBook.author = scanner.nextLine();
        newBook.id = Integer.toString(collectionOfBooks.size() + 1);
        collectionOfBooks.add(newBook);
    }
    public static void deleteBook(ArrayList<Book> collectionOfBooks) {
        Scanner scanner = new Scanner(System.in);
        int idOfTheBookToBeDeleted;
        System.out.println("id удаляемой книги");
        idOfTheBookToBeDeleted = scanner.nextInt();

        if (collectionOfBooks.size() >= idOfTheBookToBeDeleted) {
            collectionOfBooks.remove(idOfTheBookToBeDeleted - 1);
            System.out.println("Удалено");
        } else {
            System.out.println("Книга с таким id отсуствует");
        }
    }
    public static void takeBook(ArrayList<Book> collectionOfBooks) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("id книги");
        int bookId = scanner.nextInt();

        if (!collectionOfBooks.get(bookId - 1).isAvailable) {
            throw new Exception ("Книга занята");
        } else {
            collectionOfBooks.get(bookId - 1).isAvailable = false;
            System.out.println("Книга у вас!");
        }

    }
    public static void ReturnBook(ArrayList<Book> collectionOfBooks) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("id книги");
        int bookId = scanner.nextInt();
        collectionOfBooks.get(bookId - 1).isAvailable = true;
    }

}
