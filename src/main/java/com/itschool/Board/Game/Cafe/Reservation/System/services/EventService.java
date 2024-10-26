package com.itschool.Board.Game.Cafe.Reservation.System.services;

import com.itschool.Board.Game.Cafe.Reservation.System.models.dtos.EventDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface EventService {

    EventDTO createEvent(EventDTO eventDTO);

    List<EventDTO> getAllEvents();

    EventDTO getEventById(Long id);

    List<EventDTO> getEventByName(String name);

    EventDTO updateEvent(Long id, EventDTO eventDTO);

    void deleteEvent(Long id);

    List<EventDTO> getByEventDate(LocalDate eventDate);

    List<EventDTO> getEvents(String name, String genre);
}