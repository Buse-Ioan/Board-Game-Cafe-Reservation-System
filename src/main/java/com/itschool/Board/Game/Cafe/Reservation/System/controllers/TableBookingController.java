package com.itschool.Board.Game.Cafe.Reservation.System.controllers;

import com.itschool.Board.Game.Cafe.Reservation.System.models.dtos.TableBookingDTO;
import com.itschool.Board.Game.Cafe.Reservation.System.services.TableBookingService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class TableBookingController {

    private final TableBookingService tableBookingService;

    public TableBookingController(TableBookingService tableBookingService) {
        this.tableBookingService = tableBookingService;
    }

    @Operation(summary = "Create a new booking")
    @PostMapping
    public ResponseEntity<TableBookingDTO> createBooking(@Valid @RequestBody TableBookingDTO bookingDTO) {
        return ResponseEntity.ok(tableBookingService.saveBooking(bookingDTO));
    }

    @Operation(summary = "Retrieve all bookings")
    @GetMapping
    public ResponseEntity<List<TableBookingDTO>> getAllBookings() {
        return ResponseEntity.ok(tableBookingService.findAllBookings());
    }

    @Operation(summary = "Retrieve a booking by ID")
    @GetMapping("/{id}")
    public ResponseEntity<TableBookingDTO> getBookingById(@PathVariable Long id) {
        return ResponseEntity.ok(tableBookingService.findBookingById(id));
    }

    @Operation(summary = "Retrieve a booking by Email")
        @GetMapping("/customer")
    public ResponseEntity<List<TableBookingDTO>> getBookingsByCustomerEmail(@RequestParam String customerEmail) {
        return ResponseEntity.ok(tableBookingService.findBookingByCustomerEmail(customerEmail));
    }

    @Operation(summary = "Retrieve a booking by Date")
    @GetMapping("/reservation-time")
    public ResponseEntity<List<TableBookingDTO>> getBookingsByReservationTime(@RequestParam("time") LocalDateTime reservationTime) {
        return ResponseEntity.ok(tableBookingService.findByReservationTime(reservationTime));
    }

    @Operation(summary = "Update an existing booking by ID")
    @PutMapping("/{id}")
    public ResponseEntity<TableBookingDTO> updateBooking(@PathVariable Long id, @Valid @RequestBody TableBookingDTO bookingDTO) {
        return ResponseEntity.ok(tableBookingService.updateBooking(id, bookingDTO));
    }

    @Operation(summary = "Delete a booking by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        tableBookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}