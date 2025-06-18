Library Book Tracker

Overview

The Library Book Tracker is a desktop application developed using Java Swing and MySQL to assist small libraries in managing book borrowing activities. It allows administrators to handle book inventory, create accounts, manage transactions, and lets users track their borrowed books. The system separates admin and user roles, ensuring efficient and organized book management.

Features

CRUD Operations: can add, view, update, or delete books and user records.
Search Function: can easily find books by typing in keywords.
GUI Interface: The app uses buttons, tables, and text fields for an easy-to-use layout.
MySQL Integration: All data is saved and loaded from a MySQL database.
OOP Principles: The code is organized using classes to keep everything neat and easy to manage.

Technology Used

Java (JDK 8 or higher)
Java Swing (for GUI)
MySQL Database
JDBC (Java Database Connectivity)
NetBeans IDE



Database Schema

CREATE TABLE inventory (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    category VARCHAR(50),
    quantity INT,
    price DOUBLE
);


Project Structure

DBConnection.java – Centralized handler for connecting to the MySQL database.
Library.java – Login interface that routes users to either admin or user dashboards.
Librarian.java – Admin menu panel with navigation to account creation, book inventory, borrowing, and logs.
CreateUser.java – Form interface for registering new library users.
BookInvetory.java – Inventory GUI and logic for adding, updating, deleting, and searching book records.
BorrowBook.java – Enables admins to assign books to users and track borrowing.
BorrowerLog.java – Displays logs of borrowed books and allows for returns.
User.java – Interface showing students their currently borrowed books.



How to Run

Clone this repository:
https://github.com/jumicking/FinalProject/tree/main/Malilong-Final-Project

Steps to Run:
Download or clone the project from the GitHub repository.
Locate the provided .sql file in the repository and import it into your MySQL server using phpMyAdmin or the MySQL CLI:
SOURCE path/to/library.sql;
Open the project in NetBeans.
In DBconnection.java, ensure the database credentials match your local MySQL setup (e.g., username = "root", password = "root").
Run the main class MalilongFinalProject.java to launch the application.
Log in with the default admin credentials admin / admin123 or create a new user account.

