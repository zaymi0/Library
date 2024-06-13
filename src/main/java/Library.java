import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    public static void selectingAMenuItem(ArrayList<Book> collectionOfBooks, ArrayList<Teacher> teachersList,
                                          ArrayList<Student> studentsList) throws Exception {
        Scanner scanner = new Scanner(System.in);
        displayingMenuItems();
        int userMenuItemNumber = scanner.nextInt();

        switch (userMenuItemNumber) {
            case 1 -> {
                WorkingWithBooks.addBook(collectionOfBooks);
                Library.selectingAMenuItem(collectionOfBooks, teachersList, studentsList);
            }
            case 2 -> {
                WorkingWithBooks.deleteBook(collectionOfBooks);
                Library.selectingAMenuItem(collectionOfBooks, teachersList, studentsList);
            }
            case 3 -> {
                System.out.println("teacher or student");
                Scanner scanner1 = new Scanner(System.in);
                String user = scanner1.nextLine();
                if (user.equalsIgnoreCase("teacher")) {
                    WorkingWithUsers.addNewTeacher(teachersList);
                } else if (user.equalsIgnoreCase("student")) {
                    WorkingWithUsers.addNewStudent(studentsList);
                } else {
                    System.out.println("error");
                }
                Library.selectingAMenuItem(collectionOfBooks, teachersList, studentsList);
            }
            case 4 -> {
                System.out.println("teacher or student");
                Scanner scanner1 = new Scanner(System.in);
                String user = scanner1.nextLine();
                if (user.equalsIgnoreCase("teacher")) {
                    WorkingWithUsers.deleteTeacher(teachersList);
                } else if (user.equalsIgnoreCase("student")) {
                    WorkingWithUsers.deleteStudent(studentsList);
                } else {
                    System.out.println("error");
                }
                Library.selectingAMenuItem(collectionOfBooks, teachersList, studentsList);
            }
            case 5 -> {
                WorkingWithUsers.listOfAllReaders(studentsList, teachersList);
                Library.selectingAMenuItem(collectionOfBooks, teachersList, studentsList);
            }
            case 6 -> {
                WorkingWithBooks.takeBook(collectionOfBooks);
                Library.selectingAMenuItem(collectionOfBooks, teachersList, studentsList);
            }
            case 7 -> {
                WorkingWithBooks.ReturnBook(collectionOfBooks);
                Library.selectingAMenuItem(collectionOfBooks, teachersList, studentsList);
            }
            case 0 -> {
            }
            default -> {
                System.out.println("введите номер пункта от 0 до 7");
                Library.selectingAMenuItem(collectionOfBooks, teachersList, studentsList);
            }
        }
    }

    public static void displayingMenuItems() {
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
}