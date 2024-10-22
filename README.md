# Business Domain: Board Game Cafe Reservation System

A reservation system for board game cafés to manage table bookings, game library inventories, and special game night events.


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
- **Maven**
- **PostgreSQL** (production)
- **H2** (testing)
- **Spring Data JPA**, **Hibernate**
- **MockMVC**, **JUnit 5**, **Mockito**

## Features
- **CRUD Operations** for managing games, bookings, and events.
- **Dynamic Search** for events by name, game type, and date with pagination.
- **Input Validation** for consistent data handling.
- **Centralized Error Handling** with custom exceptions.

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




