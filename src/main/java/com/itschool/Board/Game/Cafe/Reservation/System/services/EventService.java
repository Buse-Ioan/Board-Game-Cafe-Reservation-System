package com.itschool.Board.Game.Cafe.Reservation.System.services;

import com.itschool.Board.Game.Cafe.Reservation.System.models.dtos.EventDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface EventService {

    EventDTO saveEvent(EventDTO eventDTO);

    List<EventDTO> findAllEvents();

    EventDTO findEventById(Long id);

    List<EventDTO> findEventByName(String name);

    EventDTO updateEvent(Long id, EventDTO eventDTO);

    void deleteEvent(Long id);

    List<EventDTO> findByEventDate(LocalDate eventDate);

//    List<EventDTO> getEvents(String name, LocalDate eventDate, int participants);

//    List<EventDTO> getEvents(String name, LocalDate eventDate);
}