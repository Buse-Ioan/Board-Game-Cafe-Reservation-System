### Business Domain: Board Game Cafe Reservation System

A reservation system for board game cafés to manage table bookings, game library inventories, and special game night events.

### 1. Tech Stack Implementation
   Spring Boot: The main framework to build the REST APIs and backend logic.
   Java 17: Set as the project’s JDK version.
   Maven: Manage dependencies and build the project.
   PostgreSQL: The primary database for the application. Configure it in application.properties for production.
   H2 In-Memory Database: Used for development and testing environments (switch configurations via profiles).
   MockMVC: Used in integration tests to mock HTTP requests and verify responses.
   JUnit and Mockito: For unit testing, to mock dependencies and test the behavior of services and controllers.
   Hibernate: Used as the default ORM for database interaction.

### Core Functionalities
The system offers the following functionalities:

1.Customer Management
• Register, update, and delete customer profiles.
• Retrieve customer information.

2.Reservation Management
• Make, update, or cancel table reservations.
• Check table availability.

3.Game Library Management
• Add, update, or remove board games from the café’s inventory.
• Track the availability of each game.

4.Special Events Management
• Create and manage special game night events.
• Register customers for events and manage their attendance.

### Features:
//## Feature 1: Book Management (CRUD)
//Users (library staff) should be able to add new books to the inventory.
//Users should be able to view all available books.
//Users should be able to update book details (e.g., changing the number of available copies after restocking).
//Users should be able to delete a book if there are no copies available and no pending borrows.

//## Feature 2: Customer Management (CRUD)
//Users should be able to register new customers by adding their personal information.
//Users should be able to view all customers.
//Users should be able to update customer information.
//Users should be able to delete a customer if they have no active book borrowings.

//## Feature 3: Borrowing Activity
//Customers should be able to borrow available books.
//The system should update the number of available copies when a book is borrowed.
//If no copies are available, the system should not allow borrowing.
//Users should be able to return borrowed books, which will update the available copies.

//## Optional Extension:
Add an entity for Borrow Records to track when books were borrowed and returned. This could create relationships between Book and Customer entities.