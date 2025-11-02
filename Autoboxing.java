import java.util.ArrayList;
import java.util.Scanner;

public class SumIntegersAutoboxing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        String input;
        
        System.out.println("Enter integers (type 'done' to finish):");

        // Reading multiple integers as strings
        while (true) {
            input = sc.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                // Parsing string to int and autoboxing into Integer
                Integer num = Integer.parseInt(input); // String parsing
                numbers.add(num); // Autoboxing happens here
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter an integer.");
            }
        }

        // Calculating sum using unboxing
        int sum = 0;
        for (Integer num : numbers) {
            sum += num; // Unboxing happens here
        }

        System.out.println("The total sum of integers is: " + sum);
        sc.close();
    }
}
