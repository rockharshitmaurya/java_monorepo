package com.library.borrower;

import com.library.book.Book;
import com.library.book.BookDao;

import java.util.List;
import java.util.Scanner;

public class BorrowerManagementHandler {
    private static final BorrowerDao borrowerDao = new BorrowerDao();
    private static final BookDao bookDao = new BookDao();
    public static void displayBorrowerManagementMenu() {
        System.out.println("Borrower Management Menu:");
        System.out.println("1. Add Borrower");
        System.out.println("2. Borrow Book");
        System.out.println("3. Return Book");
        System.out.println("4. Display All Borrowers");
        System.out.println("5. Exit");
    }

    public static void addBorrower(Scanner scanner) {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        Borrower newBorrower = new Borrower();
        newBorrower.setName(name);
        newBorrower.setEmail(email);

        borrowerDao.addBorrower(newBorrower);
        System.out.println("Borrower added successfully!");
    }

    public static void borrowBook(Scanner scanner) {
        System.out.print("Enter Book ID to borrow: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Borrower ID: ");
        int borrowerId = scanner.nextInt();
        scanner.nextLine();


        Book bookToBorrow = bookDao.getBookById(bookId);
        if (bookToBorrow != null && bookToBorrow.getQuantity() > 0) {

            bookToBorrow.setQuantity(bookToBorrow.getQuantity() - 1);
            bookDao.updateBook(bookToBorrow);


            borrowerDao.borrowBook(bookId, borrowerId);
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Book is not available for borrowing or does not exist.");
        }
    }


    public static void returnBook(Scanner scanner) {
        System.out.print("Enter Book ID to return: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Borrower ID: ");
        int borrowerId = scanner.nextInt();
        scanner.nextLine();

        // Check if the book was borrowed by the specified borrower
        boolean isBookBorrowed = borrowerDao.isBookBorrowedByBorrower(bookId, borrowerId);
        if (isBookBorrowed) {
            Book bookToReturn = bookDao.getBookById(bookId);
//          System.out.println("Here i Am"+bookToReturn);
            bookToReturn.setQuantity(bookToReturn.getQuantity() + 1);
            bookDao.updateBook(bookToReturn);


            borrowerDao.returnBook(bookId, borrowerId);
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Book was not borrowed by this borrower or does not exist.");
        }
    }


    public static void displayAllBorrowers() {
        List<Borrower> borrowers = borrowerDao.getAllBorrowers();
        if (borrowers.isEmpty()) {
            System.out.println("No borrowers available.");
        } else {
            System.out.println("List of all borrowers and their borrowed books:");
            for (Borrower borrower : borrowers) {
                System.out.println("Borrower ID: " + borrower.getBorrowerId());
                System.out.println("Name: " + borrower.getName());
                System.out.println("Email: " + borrower.getEmail());
                System.out.println("Books Borrowed:");
                List<String[]> borrowedBooks = borrowerDao.getBooksBorrowedByBorrower(borrower.getBorrowerId());
                if (borrowedBooks.isEmpty()) {
                    System.out.println("None");
                } else {
                    for (String book[] : borrowedBooks) {
                        System.out.print("- " + book[0]);
                        if(book[1]==null){
                            System.out.println(" : Not Returned");
                        }else{
                            System.out.println(" : Returne Data: "+book[1]);
                        }
                    }
                }
                System.out.println();
            }
        }
    }

}
