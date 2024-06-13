import java.util.ArrayList;
import java.util.Scanner;

public class WorkingWithUsers {
    public static void addNewTeacher(ArrayList<Teacher> teachersList) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> teacherBooks = new ArrayList<>();
        Teacher newTeacher = new Teacher("", "", teacherBooks,"");
        System.out.println("name:");
        newTeacher.name = scanner.nextLine();
        newTeacher.id = Integer.toString(teachersList.size() + 1);
        System.out.println("subject:");
        newTeacher.subject = scanner.nextLine();
        teachersList.add(newTeacher);
    }

    public static void addNewStudent(ArrayList<Student> studentsList) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> studentBooks = new ArrayList<>();
        Student newStudent = new Student("", "", studentBooks,0);
        System.out.println("name:");
        newStudent.name = scanner.nextLine();
        newStudent.id = Integer.toString(studentsList.size() + 1);
        System.out.println("grade level:");
        newStudent.gradeLevel = scanner.nextInt();
        studentsList.add(newStudent);
    }

    public static void listOfAllReaders(ArrayList<Student> studentsList, ArrayList<Teacher> teachersList) {
        System.out.println("students:");
        for (Student student : studentsList) {
            System.out.println(student.getInfo());
        }
        System.out.println("teachers:");
        for (Teacher teacher : teachersList) {
            System.out.println(teacher.getInfo());
        }
    }

    public static void deleteTeacher(ArrayList<Teacher> teachersList) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("id учителя");
        teachersList.remove(scanner.nextInt() - 1);
    }
    public static void deleteStudent(ArrayList<Student> studentsList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("id студента");
        studentsList.remove(scanner.nextInt() - 1);
    }
}
