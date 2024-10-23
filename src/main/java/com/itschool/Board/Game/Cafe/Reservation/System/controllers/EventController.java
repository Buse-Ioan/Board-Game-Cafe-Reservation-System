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
        EventDTO createdEvent = eventService.saveEvent(eventDTO);

        return ResponseEntity.ok(eventService.saveEvent(eventDTO));
    }

    @Operation(summary = "Get and list all events")
    @GetMapping
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        List<EventDTO> events = eventService.findAllEvents();

        return ResponseEntity.ok(eventService.findAllEvents());
    }

    @Operation(summary = "Get an event by ID")
    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id) {
        EventDTO event = eventService.findEventById(id);

        return ResponseEntity.ok(eventService.findEventById(id));
    }

    @Operation(summary = "Get an event by name")
    @GetMapping("/name")
    public ResponseEntity<List<EventDTO>> getEventsByName(@RequestParam String name) {
        List<EventDTO> events = eventService.findEventByName(name);

        return ResponseEntity.ok(eventService.findEventByName(name));
    }

    @Operation(summary = "Get an event by date")
    @GetMapping("/date")
    public ResponseEntity<List<EventDTO>> getEventsByDate(@RequestParam("date") LocalDate eventDate) {

        return ResponseEntity.ok(eventService.findByEventDate(eventDate));
    }

    @Operation(summary = "Update an existing event by ID")
    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> updateEvent(@PathVariable Long id, @Valid @RequestBody EventDTO eventDTO) {
        EventDTO updatedEvent = eventService.updateEvent(id, eventDTO);
        return ResponseEntity.ok(eventService.updateEvent(id, eventDTO));
    }

    @Operation(summary = "Delete an event by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);

        return ResponseEntity.noContent().build();
    }
}
//    @Operation(summary = "Get all filtered events by name, date and participants")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Found the books",
//                    content = { @Content(mediaType = "application/json",
//                            schema = @Schema(implementation = Event.class)) }),
//            @ApiResponse(responseCode = "404", description = "Books not found",
//                    content = @Content) })

//    @GetMapping
//    public ResponseEntity<List<EventDTO>> getEvents(
//            @RequestParam(value = "name", required = false) String name,
//            @RequestParam(value = "event date", required = false) LocalDate eventDate) {
//        return ResponseEntity.ok(eventService.getEvents(name, eventDate));
//    }
