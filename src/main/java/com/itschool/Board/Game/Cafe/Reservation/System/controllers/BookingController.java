package com.itschool.Board.Game.Cafe.Reservation.System.controllers;

import com.itschool.Board.Game.Cafe.Reservation.System.models.dtos.BookingDTO;
import com.itschool.Board.Game.Cafe.Reservation.System.services.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Operation(summary = "Create a new booking")
    @PostMapping
    public ResponseEntity<BookingDTO> createBooking(@Valid @RequestBody BookingDTO bookingDTO) {
        return ResponseEntity.ok(bookingService.createBooking(bookingDTO));
    }

    @Operation(summary = "Get a list of all bookings")
    @GetMapping
    public ResponseEntity<List<BookingDTO>> getAllBookings() {
        return ResponseEntity.ok(bookingService.findAllBookings());
    }

    @Operation(summary = "Get a booking by ID")
    @GetMapping("/id/{id}")
    public ResponseEntity<BookingDTO> getBookingById(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.findBookingById(id));
    }

    @Operation(summary = "Get a booking by email")
    @GetMapping("/email/{email}")
    public ResponseEntity<List<BookingDTO>> getBookingsByCustomerEmail(@PathVariable String email) {
        return ResponseEntity.ok(bookingService.findBookingByCustomerEmail(email));
    }

    @Operation(summary = "Get a booking by date")
    @GetMapping("/date/{date}")
    public ResponseEntity<List<BookingDTO>> getBookingsByDate(@PathVariable LocalDate date) {
        return ResponseEntity.ok(bookingService.findByBookingDate(date));
    }

    @Operation(summary = "Get bookings by customer name")
    @GetMapping("/customer_name/{customerName}")
    public ResponseEntity<List<BookingDTO>> getBookingsByCustomerName(@PathVariable String customerName) {
        return ResponseEntity.ok(bookingService.findBookingByCustomerName(customerName));
    }

    @Operation(summary = "Update an existing booking by ID")
    @PutMapping("/{id}")
    public ResponseEntity<BookingDTO> updateBooking(@PathVariable Long id, @Valid @RequestBody BookingDTO bookingDTO) {
        return ResponseEntity.ok(bookingService.updateBooking(id, bookingDTO));
    }

    @Operation(summary = "Delete a booking by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}