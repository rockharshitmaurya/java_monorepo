import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Update Quantity");
            System.out.println("4. View Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = ValidateInput.getUserChoice(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter item price: ");
                    double itemPrice = ValidateInput.getUserDouble(scanner);
                    System.out.print("Enter item quantity: ");
                    int itemQuantity = ValidateInput.getUserInt(scanner);
                    cart.addItem(new Item(itemName, itemPrice, itemQuantity));
                    break;
                case 2:
                    System.out.print("Enter item name to remove: ");
                    String itemToRemove = scanner.nextLine();
                    cart.removeItem(itemToRemove);
                    break;
                case 3:
                    System.out.print("Enter item name to update quantity: ");
                    String itemToUpdate = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = ValidateInput.getUserInt(scanner);
                    cart.updateQuantity(itemToUpdate, newQuantity);
                    break;
                case 4:
                    cart.viewCart();
                    break;
                case 5:
                    cart.checkout();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
}