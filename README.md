# Business Domain: Board Game Cafe Reservation System

The Board Game Café Reservation System is a Spring Boot-based web application designed to manage table bookings, game library inventories, and special game night events for a board game café.
This application provides a simple API for creating, updating, and retrieving information about games, events, and table bookings.

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
- **Game Management**: Create, update, retrieve, and delete games.
- **Booking Management**: Manage table reservations and retrieve bookings by customer details or reservation date.
- **Event Management**: Create, update, retrieve, and delete events. Search for events by name, date, and game genre.
- **Custom Exceptions**: Handle exceptions with meaningful messages, including custom exceptions for game and event management.
- **Validation**: Ensure valid inputs using `@Valid`, `@NotNull`, `@Min`, `@Max`, and other validation annotations.
- **Testing**: Comprehensive unit and integration testing using MockMVC, JUnit, and Mockito.


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

### Prerequisites
- **Java 17**
- **PostgreSQL**
- **Maven**

### Steps

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/board-game-cafe-reservation-system.git

2. **Configure PostgreSQL:**
- Set up a PostgreSQL database. You can name it boardgamecafe.
- Update the credentials in application.properties to match your PostgreSQL setup:
- Replace `your_db_user` and `your_db_password` with your actual PostgreSQL username and password.

3. **Run the application using Maven:**
```bash
mvn spring-boot:run
```

3. **Access the APIs using Postman or your preferred HTTP client.**


4. **Alternatively, run the JAR file:**
```bash
java -jar target/Board-Game-Cafe-Reservation-System.jar
```

### API Documentation
The app will be accessible at:
```bash
http://localhost:8080
```

## API Endpoints
The system offers the following functionalities:
### Game Endpoints
- POST /api/games - Create a new game.
- GET /api/games - Get all games.
- GET /api/games - Get a game by ID.
- GET /api/games - Get a game by name.
- PUT /api/games/{id} - Update a game.
- DELETE /api/games/{id} - Delete a game.

### Booking Endpoints
- POST /api/bookings - Create a new booking.
- GET /api/bookings - Get all bookings.
- GET /api/bookings - Get a booking by ID.
- GET /api/bookings - Get a booking by email.
- GET /api/bookings - Get a booking by date.
- GET /api/bookings -Get bookings by customer name.
- PUT /api/bookings/{id} - Update a booking.
- DELETE /api/bookings/{id} - Delete a booking.

### Event Endpoints
- POST /api/events - Create an event.
- GET /api/events/search - Get a list of all events.
- GET /api/events/search - Get an event by ID.
- GET /api/events/search - Get an event by name.
- GET /api/events/search - Get an event by date.
- PUT /api/events/{id} - Update an event.
- DELETE /api/events/{id} - Delete an event.

Example Search Request
```http
GET http://localhost:8080/api/events/search?name=ChessNight&gameType=Strategy&eventDate=2024-10-22
```

## Testing
Run unit and integration tests using the following command::
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




