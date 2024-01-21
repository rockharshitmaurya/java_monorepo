package com.library.borrower;

import com.library.database.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BorrowerDao {
    private Connection connection;

    public BorrowerDao() {
        this.connection = Database.getConnection();
    }

    public void addBorrower(Borrower borrower) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Borrowers (name, email) VALUES (?, ?)")) {
            preparedStatement.setString(1, borrower.getName());
            preparedStatement.setString(2, borrower.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void borrowBook(int bookId, int borrowerId) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO BorrowedBooks (book_id, borrower_id, borrow_date) VALUES (?, ?, ?)")) {
            preparedStatement.setInt(1, bookId);
            preparedStatement.setInt(2, borrowerId);
            preparedStatement.setDate(3, new Date(System.currentTimeMillis()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void returnBook(int bookId, int borrowerId) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE BorrowedBooks SET return_date = ? WHERE book_id = ? AND borrower_id = ?")) {
            preparedStatement.setDate(1, new Date(System.currentTimeMillis()));
            preparedStatement.setInt(2, bookId);
            preparedStatement.setInt(3, borrowerId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Borrower> getAllBorrowers() {
        List<Borrower> borrowers = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Borrowers")) {
            while (resultSet.next()) {
                Borrower borrower = new Borrower();
                borrower.setBorrowerId(resultSet.getInt("borrower_id"));
                borrower.setName(resultSet.getString("name"));
                borrower.setEmail(resultSet.getString("email"));

                borrowers.add(borrower);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return borrowers;
    }

    public List<String[]> getBooksBorrowedByBorrower(int borrowerId) {
        List<String[]> borrowedBooks = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT b.title,bb.return_date FROM Books b " +
                        "JOIN BorrowedBooks bb ON b.book_id = bb.book_id " +
                        "WHERE bb.borrower_id = ?")) {
            preparedStatement.setInt(1, borrowerId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                borrowedBooks.add(new String[]{resultSet.getString("title"),resultSet.getString("return_date")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return borrowedBooks;
    }
    public boolean isBookBorrowedByBorrower(int bookId, int borrowerId) {
        Connection connection = Database.getConnection();
        boolean isBorrowed = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM BorrowedBooks WHERE book_id = ? AND borrower_id = ? AND return_date is NULL")) {
            preparedStatement.setInt(1, bookId);
            preparedStatement.setInt(2, borrowerId);
            ResultSet resultSet = preparedStatement.executeQuery();

            isBorrowed = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isBorrowed;
    }
}
