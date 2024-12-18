package com.itschool.Board.Game.Cafe.Reservation.System.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.Board.Game.Cafe.Reservation.System.exceptions.GameNotFoundException;
import com.itschool.Board.Game.Cafe.Reservation.System.models.dtos.EventDTO;
import com.itschool.Board.Game.Cafe.Reservation.System.models.entities.Event;
import com.itschool.Board.Game.Cafe.Reservation.System.repositories.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    private static final Logger log = LoggerFactory.getLogger(EventServiceImpl.class);
    private final ObjectMapper objectMapper;
    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(ObjectMapper objectMapper, EventRepository eventRepository) {
        this.objectMapper = objectMapper;
        this.eventRepository = eventRepository;
    }

    @Override
    public EventDTO createEvent(EventDTO eventDTO) {
        Event event = objectMapper.convertValue(eventDTO, Event.class);
        Event createdEvent = eventRepository.save(event);
        log.info("Event saved successfully with ID: {}", createdEvent.getId());

        return objectMapper.convertValue(createdEvent, EventDTO.class);
    }

    @Override
    public List<EventDTO> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        log.info("Found {} events", events.size());

        return events.stream()
                .map(event -> objectMapper.convertValue(event, EventDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EventDTO getEventById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException("Event not found with ID: " + id));
        log.info("Event found: {}", event.getName());

        return objectMapper.convertValue(event, EventDTO.class);
    }

    @Override
    public List<EventDTO> getEventByName(String name) {
        List<Event> events = eventRepository.findEventByName(name);
        log.info("Found {} events with name: {}", events.size(), name);

        return events.stream()
                .map(event -> objectMapper.convertValue(event, EventDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EventDTO> getByEventDate(LocalDate eventDate) {
        List<Event> events = eventRepository.findByEventDate(eventDate);

        return events.stream()
                .map(event -> objectMapper.convertValue(event, EventDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EventDTO> getEvents(String name, String genre) {
        Specification<Event> spec = Specification
                .where(EventSpecification.nameContains(name))
                .and(EventSpecification.genreContains(genre));

        return eventRepository.findAll(spec).stream()
                .map(event -> objectMapper.convertValue(event, EventDTO.class))
                .toList();
    }

    @Override
    public EventDTO updateEvent(Long id, EventDTO eventDTO) {
        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException("Event not found with ID: " + id));

        existingEvent.setName(eventDTO.getName());
        existingEvent.setEventDate(eventDTO.getEventDate());
        existingEvent.setParticipants(eventDTO.getParticipants());
        existingEvent.setGenre(eventDTO.getGenre());

        Event updatedEvent = eventRepository.save(existingEvent);
        log.info("Event updated successfully: {}", updatedEvent.getName());

        return objectMapper.convertValue(updatedEvent, EventDTO.class);
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException("Event not found with ID: " + id));
        eventRepository.deleteById(id);
        log.info("Event deleted successfully");
    }
}