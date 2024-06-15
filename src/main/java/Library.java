import entity.Book;
import entity.Member;
import entity.Student;
import entity.Teacher;
import execption.BookAlreadyBorrowedException;
import execption.BookNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    List<Book> collectionOfBooks = new ArrayList<>();
    List<Member> membersList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Library library = new Library();
        library.selectingAMenuItem();
    }

    public void selectingAMenuItem()  {
        Scanner scanner = new Scanner(System.in);
        displayingMenuItems();
        int userMenuItemNumber = scanner.nextInt();

        switch (userMenuItemNumber) {
            case 1 -> {
                addBook();
                selectingAMenuItem();
            }
            case 2 -> {
                System.out.println("enter book ID");
                try {
                    deleteBookById(scanner.nextInt());
                } catch (BookNotFoundException e) {
                    System.out.println("ошибка: " + e.getMessage());
                }
                selectingAMenuItem();
            }
            case 3 -> {
                addNewMember();
                selectingAMenuItem();
            }
            case 4 -> {
                System.out.println("id");
                deleteMemberById(scanner.nextInt() - 1);
                selectingAMenuItem();
            }
            case 5 -> {
                listOfAllReaders(membersList);
                selectingAMenuItem();
            }
            case 6 -> {
                System.out.println("enter book ID");
                try {
                    takeBook(collectionOfBooks.get(scanner.nextInt() - 1));
                } catch (BookAlreadyBorrowedException e) {
                    System.out.println("ошибка: " + e.getMessage());
                }
                selectingAMenuItem();
            }
            case 7 -> {
                System.out.println("enter book ID");
                returnBookById(scanner.nextInt());
                selectingAMenuItem();
            }
            case 0 -> {}
            default -> {
                System.out.println("введите номер пункта от 0 до 7");
                selectingAMenuItem();
            }
        }
    }

    public void displayingMenuItems() {
        System.out.println("""
                Меню\s
                1. Добавить новую книгу\s
                2. Удаление книги (id)\s
                3. Добавить нового читателя\s
                4. Удалить читателя (id)\s
                5. Отобразить всех читателей\s
                6. Взять книгу\s
                7. Возврат книги в библиотеку\s
                0. Выйти\s
                Введите номер пункта:\s""");
    }

    public void takeBook(Book book) throws BookAlreadyBorrowedException {
        if(!book.getIsAvailable()) {
            throw new BookAlreadyBorrowedException("Книга занята");
        } else {
            System.out.println("enter member ID");
            membersList.get(scanner.nextInt() - 1).addBorrowedBook(book);
            book.setIsAvailable(false);
        }
    }

    public void addBook() {
        Scanner scanner = new Scanner(System.in);
        Book newBook = new Book("", "", "", true);
        System.out.println("title");
        newBook.setTitle(scanner.nextLine());
        System.out.println("author");
        newBook.setAuthor(scanner.nextLine());
        newBook.setId(Integer.toString(collectionOfBooks.size() + 1));
        collectionOfBooks.add(newBook);
    }

    public void deleteBookById(int bookId) throws BookNotFoundException {
        if (collectionOfBooks.size() >= bookId) {
            collectionOfBooks.remove(bookId - 1);
            System.out.println("Удалено");
        } else {
            throw new BookNotFoundException ("Книга не найдена");
        }
    }

    public void returnBookById(int bookId) {
        collectionOfBooks.get(bookId - 1).setIsAvailable(true);
        System.out.println("id member");
        membersList.get(scanner.nextInt() - 1).returnBorrowedBook(collectionOfBooks.get(bookId - 1));
        collectionOfBooks.get(bookId - 1).setIsAvailable(true);
    }

    public void addNewMember() {
        System.out.println("teacher or student");
        String user = scanner.nextLine();
        List<Book> memberBooks = new ArrayList<>();

        if (user.equalsIgnoreCase("teacher")) {
            Teacher newTeacher = new Teacher("", "",memberBooks ,"");
            System.out.println("name:");
            newTeacher.setName(scanner.nextLine());
            newTeacher.setId(Integer.toString(membersList.size() + 1));
            System.out.println("subject:");
            newTeacher.setSubject(scanner.nextLine());
            membersList.add(newTeacher);
        } else if (user.equalsIgnoreCase("student")) {
            Student newStudent = new Student("", "", memberBooks,0);
            System.out.println("name:");
            newStudent.setName(scanner.nextLine());
            newStudent.setId(Integer.toString(memberBooks.size() + 1));
            System.out.println("grade level:");
            newStudent.setGradeLevel(scanner.nextInt());
            membersList.add(newStudent);
        } else {
            System.out.println("error");
        }
    }

    public void listOfAllReaders(List<Member> membersList) {
        for (Member member : membersList) {
            System.out.println(member.getInfo());
        }
    }

    public void deleteMemberById(int memberId) { membersList.remove(memberId); }
}