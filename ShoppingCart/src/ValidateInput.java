import java.util.Scanner;
import java.util.InputMismatchException;
public class ValidateInput {
    static int getUserChoice(Scanner scanner) {
        int choice = 0;
        while (true) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine();
                System.out.print("Enter your choice: ");
            }
        }
        return choice;
    }

    static int getUserInt(Scanner scanner) {
        int value = 0;
        while (true) {
            try {
                value = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.nextLine();
                System.out.print("Enter a valid number: ");
            }
        }
        return value;
    }

    static double getUserDouble(Scanner scanner) {
        double value = 0;
        while (true) {
            try {
                value = scanner.nextDouble();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine();
                System.out.print("Enter a valid number: ");
            }
        }
        return value;
    }
}
