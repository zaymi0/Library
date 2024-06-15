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

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }
    @Override
    public String getInfo() {
        return String.format("mame: %s, id: %s, gradeLevel: %d (entity.Student)", getName(), getId(), getGradeLevel());
    }
}
