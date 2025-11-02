import java.io.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "employees.txt";
        int choice;

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter Employee ID: ");
                String id = sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Designation: ");
                String designation = sc.nextLine();
                System.out.print("Enter Salary: ");
                String salary = sc.nextLine();

                try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
                    bw.write(id + "," + name + "," + designation + "," + salary);
                    bw.newLine();
                    System.out.println("Employee added successfully!");
                } catch (IOException e) {
                    System.out.println("Error writing to file.");
                }

            } else if (choice == 2) {
                try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                    String line;
                    System.out.println("\n--- Employee Records ---");
                    while ((line = br.readLine()) != null) {
                        String[] data = line.split(",");
                        System.out.println("ID: " + data[0] + " | Name: " + data[1] + " | Designation: " + data[2] + " | Salary: " + data[3]);
                    }
                } catch (IOException e) {
                    System.out.println("No employee records found.");
                }

            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;

            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }
        sc.close();
    }
}
