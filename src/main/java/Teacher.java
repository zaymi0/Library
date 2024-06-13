import java.util.ArrayList;

public class Teacher extends Member {
    protected String subject;
    public Teacher(String name, String id, ArrayList<Book> borrowedBooks, String subject) {
        super(name, id, borrowedBooks);
        this.subject = subject;
    }
    public String getInfo() {
        return String.format("mame: %s, id: %s, subject: %s", name, id, subject);
    }
}
