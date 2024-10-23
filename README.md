# Business Domain: Board Game Cafe Reservation System

The Board Game Café Reservation System is a Spring Boot-based web application designed to manage table bookings, game library inventories, and special game night events for a board game café.
This application provides a simple API for creating, updating, and retrieving information about games, events, and table bookings. (The app also includes dynamic search functionality for events based on name, game type, and event date.)


## Table of Contents
- [Tech Stack](#tech-stack)
- [Features](#features)
- [Project Structure](#project-structure)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Testing](#testing)
- [Error Handling](#error-handling)
- [Contributing](#contributing)

## Tech Stack
- **Java 17**
- **Spring Boot** 3.x
- **Maven** (for dependency management)
- **PostgreSQL** (for production database)
- **H2 Database** (for in-memory testing and development)
- **Spring Data JPA** (for repository pattern and data access)
- **Hibernate** (ORM)
- **MockMVC** (for integration tests)
- **JUnit 5** (for unit tests)
- **Mockito** (for mocking dependencies in tests)
- **Postman** (for API testing)

## Features
CRUD Operations:
- Manage board games (add, update, delete, and retrieve games).
- Manage table bookings for customers.
- Manage special game night events (search, create, update, delete).

Dynamic Search:
- Search events based on event name, game type, and event date with support for pagination.

Input Validation:
- Validates incoming data (e.g., game name cannot be blank, event date cannot be in the past).

Error Handling:
- Centralized exception handling with custom error messages and proper HTTP status codes.

## Project Structure
```bash
src/
├── main/
│   ├── java/com/boardgamecafe
│   │   ├── controllers/        # REST Controllers
│   │   ├── exceptions/         # Exception handling
│   │   ├── models/             # DTOs and Entity classes
│   │   ├── repositories/       # Data Repositories
│   │   └── services/           # Service implementations
│   └── resources/
│       ├── application.properties  # Configuration
│       └── data.sql                # Optional data script
└── test/                           # Unit and integration tests
```

## Running the Application
Run the application using Maven:
```bash
mvn spring-boot:run
```

Alternatively, run the JAR file:
```bash
java -jar target/Board-Game-Cafe-Reservation-System.jar
```
The app will be accessible at: http://localhost:8080

## API Endpoints
The system offers the following functionalities:
### Game Endpoints
- GET /api/games - Get all games.
- POST /api/games - Create a new game.
- PUT /api/games/{id} - Update a game.
- DELETE /api/games/{id} - Delete a game.

### Table Booking Endpoints
- GET /api/bookings - Get all bookings.
- POST /api/bookings - Create a new booking.
- PUT /api/bookings/{id} - Update a booking.
- DELETE /api/bookings/{id} - Delete a booking.

### Event Endpoints
- GET /api/events/search - Search events with optional filters for name, gameType, and eventDate.
- POST /api/events - Create an event.
- PUT /api/events/{id} - Update an event.
- DELETE /api/events/{id} - Delete an event.

Example Search Request
```http
GET http://localhost:8080/api/events/search?name=ChessNight&gameType=Strategy&eventDate=2024-10-22
```

## Testing
Run unit and integration tests using:
```bash
mvn test
```
- MockMVC for REST API tests.
- JUnit 5 for unit tests.
- Mockito for mocking services.

## Error Handling
All exceptions are centrally handled using @ControllerAdvice.

- 404 Not Found for missing resources (games, events, etc.).
- 400 Bad Request for invalid data input.
Example Error Response (Game Not Found):
```json
  {
  "message": "Game not found with ID: 123"
  }
```

## Contributing                                                       
Fork the repository and submit a pull request. For major changes, open an issue to discuss what you'd like to change.




