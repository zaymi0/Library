package entity;

import java.util.List;

public class Student extends Member {
    private int gradeLevel;

    public Student(String name, String id, List<Book> borrowedBooks, int gradeLevel) {
        super(name, id, borrowedBooks);
        this.gradeLevel = gradeLevel;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    @Override
    public String getInfo() {
        return String.format("mame: %s, id: %s, gradeLevel: %d (Student)", getName(), getId(), getGradeLevel());
    }
}
