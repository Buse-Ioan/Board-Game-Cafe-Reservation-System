package com.itschool.Board.Game.Cafe.Reservation.System.controllers;

import com.itschool.Board.Game.Cafe.Reservation.System.models.dtos.EventDTO;
import com.itschool.Board.Game.Cafe.Reservation.System.services.EventService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @Operation(summary = "Create a new event")
    @PostMapping
    public ResponseEntity<EventDTO> createEvent(@Valid @RequestBody EventDTO eventDTO) {
        return ResponseEntity.ok(eventService.createEvent(eventDTO));
    }

    @Operation(summary = "Get a list of all events")
    @GetMapping
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @Operation(summary = "Get an event by ID")
    @GetMapping("/id/{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.getEventById(id));
    }

    @Operation(summary = "Get an event by name")
    @GetMapping("/name/{name}")
    public ResponseEntity<List<EventDTO>> getEventsByName(@PathVariable String name) {
        return ResponseEntity.ok(eventService.getEventByName(name));
    }

    @Operation(summary = "Get an event by date")
    @GetMapping("/date/{date}")
    public ResponseEntity<List<EventDTO>> getEventsByDate(@PathVariable LocalDate date) {
        return ResponseEntity.ok(eventService.getByEventDate(date));
    }

    @Operation(summary = "Update an existing event by ID")
    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> updateEvent(@PathVariable Long id, @Valid @RequestBody EventDTO eventDTO) {
        return ResponseEntity.ok(eventService.updateEvent(id, eventDTO));
    }

    @Operation(summary = "Delete an event by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get all events by name and genre filters")
    @GetMapping("/search")
    public ResponseEntity<List<EventDTO>> getEvents(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "genre", required = false) String genre) {

        return ResponseEntity.ok(eventService.getEvents(name, genre));
    }
}