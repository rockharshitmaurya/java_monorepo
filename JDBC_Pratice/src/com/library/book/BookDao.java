package com.library.book;

import com.library.database.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private Connection connection;

    public BookDao() {
        this.connection = Database.getConnection();
    }

    public void addBook(Book book) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Books (title, author, genre, quantity) VALUES (?, ?, ?, ?)")) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getGenre());
            preparedStatement.setInt(4, book.getQuantity());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBook(Book book) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE Books SET title = ?, author = ?, genre = ?, quantity = ? WHERE book_id = ?")) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getGenre());
            preparedStatement.setInt(4, book.getQuantity());
            preparedStatement.setInt(5, book.getBookId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeBook(int bookId) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM Books WHERE book_id = ?")) {
            preparedStatement.setInt(1, bookId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Books")) {
            while (resultSet.next()) {
                Book book = new Book();
                book.setBookId(resultSet.getInt("book_id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setGenre(resultSet.getString("genre"));
                book.setQuantity(resultSet.getInt("quantity"));

                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
    public Book getBookById(int bookId) {
        Connection connection = Database.getConnection();
        Book book = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Books WHERE book_id = ?")) {
            preparedStatement.setInt(1, bookId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                book = new Book();
                book.setBookId(resultSet.getInt("book_id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setGenre(resultSet.getString("genre"));
                book.setQuantity(resultSet.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }
}
