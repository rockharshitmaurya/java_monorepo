package com.library.book;

import java.util.List;
import java.util.Scanner;

public class BookManagementHandler {
    private static final BookDao bookDao = new BookDao();
    public static void displayBookManagementMenu() {
        System.out.println("Book Management Menu:");
        System.out.println("1. Add Book");
        System.out.println("2. Update Book");
        System.out.println("3. Remove Book");
        System.out.println("4. Display All Books");
        System.out.println("5. Exit");
    }

    public static void addBook(Scanner scanner) {
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Book newBook = new Book();
        newBook.setTitle(title);
        newBook.setAuthor(author);
        newBook.setGenre(genre);
        newBook.setQuantity(quantity);

        bookDao.addBook(newBook);
        System.out.println("Book added successfully!");
    }

    public static void updateBook(Scanner scanner) {
        System.out.print("Enter Book ID to update: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter new Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter new Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter new Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Book updatedBook = new Book();
        updatedBook.setBookId(bookId);
        updatedBook.setTitle(title);
        updatedBook.setAuthor(author);
        updatedBook.setGenre(genre);
        updatedBook.setQuantity(quantity);

        bookDao.updateBook(updatedBook);
        System.out.println("Book updated successfully!");
    }


    public static void removeBook(Scanner scanner) {
        System.out.print("Enter Book ID to remove: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        bookDao.removeBook(bookId);
        System.out.println("Book removed successfully!");
    }


    public static void displayAllBooks() {
        List<Book> books = bookDao.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("List of all available books:");
            for (Book book : books) {
                System.out.println(book.toString());
            }
        }
    }

}
