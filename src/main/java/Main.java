import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Book> collectionOfBooks = new ArrayList<>();
        ArrayList<Teacher> teachersList = new ArrayList<>();
        ArrayList<Student> studentsList = new ArrayList<>();
        Library.selectingAMenuItem(collectionOfBooks, teachersList, studentsList);
    }
}