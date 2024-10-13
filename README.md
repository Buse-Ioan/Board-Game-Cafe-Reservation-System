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
//• Add, update, or remove board games from the café’s inventory.?
//• Track the availability of each game.?

4.Special Events Management
• Create and manage special game night events.
• Register customers for events and manage their attendance.