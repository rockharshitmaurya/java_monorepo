package com.library.borrower;

import java.util.ArrayList;
import java.util.List;

public class Borrower {
    public Borrower(int borrowerId, String name, String email, String borrowedBook) {
        this.borrowerId = borrowerId;
        this.name = name;
        this.email = email;
        this.borrowedBook = borrowedBook;
    }

    public Borrower(){

    }
    private int borrowerId;
    private String name;
    private String email;

    public int getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(int borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBorrowedBook() {
        return borrowedBook;
    }

    public void setBorrowedBook(String borrowedBook) {
        this.borrowedBook = borrowedBook;
    }

    private String borrowedBook;

    // Constructor, getters, setters
}
