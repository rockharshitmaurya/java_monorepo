# Assignment-2 Repository

This repository contains solutions for Assignment-2, addressing the implementation of Threads, Runnable Interface, Synchronization, Thread Pool using Executor Framework, an Online Shopping Cart system, and a Library Management System using JDBC.

## Folder Structure Overview

### 1. JDBC_Practice
This folder contains a Java project for a Library Management System using JDBC.

- **src/com/library/book:** 
  - `Book.java`, `BookDao.java`, `BookManagementHandler.java`: Classes related to book management.
  
- **src/com/library/borrower:** 
  - `Borrower.java`, `BorrowerDao.java`, `BorrowerManagementHandler.java`: Classes for managing borrowers.

- **src/com/library/database:** 
  - `Database.java`: Contains the database connection logic.
  
- **Main.java**: Entry point for the JDBC project.

### 2. ShoppingCart
This directory includes an Online Shopping Cart Java project.

- **src/:** 
  - `Item.java`, `ShoppingCart.java`, `ValidateInput.java`: Classes for managing shopping cart functionality.
  
- **Main.java**: Entry point for the shopping cart project.

### 3. Threading_Practice
This folder contains a Java project demonstrating threading concepts.

- **src/com/worker/multiple:** 
  - `TestMultipleExecutorService.java`: Illustrates the use of `ExecutorService` with a fixed thread pool.

- **src/com/worker/single:** 
  - `TestRunnable.java`, `TestSingleExecutorService.java`: Implementation of single and runnable threads.

- **src/com/worker/synchronization:** 
  - `SynchronizationWithExecutor.java`: Shows synchronization techniques with `ExecutorService`.

- **Main.java**: Entry point for the threading project.

## Usage Guide

### Assignment-2 Problems
1. **Threads Implementation:**
   - Explains the implementations using Runnable, Synchronization, and Executor Framework.
  
2. **Online Shopping Cart:**
   - Details the functionalities (add, remove, view, update, checkout) and the respective classes.

3. **Library Management System:**
   - Describes book and borrower management using JDBC.

## Here's a representation of the tree structure within the README to visually guide users through the repository:

```
Assignment-2 Repository
|
├── JDBC_Practice
│   ├── src
│   │   ├── com
│   │   │   ├── library
│   │   │   │   ├── book
│   │   │   │   │   ├── Book.java
│   │   │   │   │   ├── BookDao.java
│   │   │   │   │   └── BookManagementHandler.java
│   │   │   │   ├── borrower
│   │   │   │   │   ├── Borrower.java
│   │   │   │   │   ├── BorrowerDao.java
│   │   │   │   │   └── BorrowerManagementHandler.java
│   │   │   │   └── database
│   │   │   │       └── Database.java
│   │   │   └── Main.java
│   └── ...
|
├── ShoppingCart
│   ├── src
│   │   ├── Item.java
│   │   ├── Main.java
│   │   ├── ShoppingCart.java
│   │   └── ValidateInput.java
│   └── ...
|
└── Threading_Practice
    ├── src
    │   ├── com
    │   │   ├── worker
    │   │   │   ├── multiple
    │   │   │   │   └── TestMultipleExecutorService.java
    │   │   │   ├── single
    │   │   │   │   ├── TestRunnable.java
    │   │   │   │   └── TestSingleExecutorService.java
    │   │   │   └── synchronization
    │   │   │       └── SynchronizationWithExecutor.java
    │   │   └── Main.java
    └── ...
```
