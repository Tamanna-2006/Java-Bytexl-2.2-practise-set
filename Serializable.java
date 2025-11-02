import java.io.*;
import java.util.Scanner;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private int studentID;
    private String name;
    private char grade;

    public Student(int studentID, String name, char grade) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + ", Name: " + name + ", Grade: " + grade;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Grade (A/B/C...): ");
        char grade = scanner.next().charAt(0);

        Student student = new Student(id, name, grade);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.dat"))) {
            oos.writeObject(student);
            System.out.println("Student object serialized successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.dat"))) {
            Student deserializedStudent = (Student) ois.readObject();
            System.out.println("Student object deserialized successfully!");
            System.out.println("Retrieved Data: " + deserializedStudent);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
