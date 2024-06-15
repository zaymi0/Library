package entity;

import java.util.List;

public class Teacher extends Member {
    private String subject;

    public Teacher(String name, String id, List<Book> borrowedBooks, String subject) {
        super(name, id, borrowedBooks);
        this.subject = subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String getInfo() {
        return String.format(" mame: %s, id: %s, subject: %s,  (teacher)", getName(), getId(), subject);
    }
}
