package com.library.book;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private String genre;

    public Book(int bookId, String title, String author, String genre, int quantity) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.quantity = quantity;
    }

    public Book() {
    }

    private int quantity;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
