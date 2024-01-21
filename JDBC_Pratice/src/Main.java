import com.library.book.BookManagementHandler;
import com.library.borrower.BorrowerManagementHandler;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static  final BookManagementHandler bookHandler=new BookManagementHandler();
    private static final BorrowerManagementHandler borrowerHandler=new BorrowerManagementHandler();

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    handleBookManagement();
                    break;
                case 2:
                    handleBorrowerManagement();
                    break;
                case 3:
                    System.out.println("Exiting Library Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("Library Management System Menu:");
        System.out.println("1. Book Management");
        System.out.println("2. Borrower Management");
        System.out.println("3. Exit");
    }

    private static void handleBookManagement() {
        int bookChoice;
        do {
            bookHandler.displayBookManagementMenu();
            System.out.print("Enter your choice: ");
            bookChoice = scanner.nextInt();
            scanner.nextLine();

            switch (bookChoice) {
                case 1:
                    bookHandler.addBook(scanner);
                    break;
                case 2:
                    bookHandler.updateBook(scanner);
                    break;
                case 3:
                    bookHandler.removeBook(scanner);
                    break;
                case 4:
                    bookHandler.displayAllBooks();
                    break;
                case 5:
                    System.out.println("Exiting Book Management.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (bookChoice != 5);
    }



    private static void handleBorrowerManagement() {
        int borrowerChoice;
        do {
            borrowerHandler.displayBorrowerManagementMenu();
            System.out.print("Enter your choice: ");
            borrowerChoice = scanner.nextInt();
            scanner.nextLine();

            switch (borrowerChoice) {
                case 1:
                    borrowerHandler.addBorrower(scanner);
                    break;
                case 2:
                    borrowerHandler.borrowBook(scanner);
                    break;
                case 3:
                    borrowerHandler.returnBook(scanner);
                    break;
                case 4:
                    borrowerHandler.displayAllBorrowers();
                    break;
                case 5:
                    System.out.println("Exiting Borrower Management.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (borrowerChoice != 5);
    }

}
