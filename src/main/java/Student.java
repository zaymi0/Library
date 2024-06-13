import java.util.ArrayList;

public class Student extends Member {

    protected int gradeLevel;

    public Student(String name, String id, ArrayList<Book> borrowedBooks, int gradeLevel) {
        super(name, id, borrowedBooks);
        this.gradeLevel = gradeLevel;
    }

    public String getInfo() {
        return String.format("mame: %s, id: %s, gradeLevel: %d", name, id, gradeLevel);
    }
}
