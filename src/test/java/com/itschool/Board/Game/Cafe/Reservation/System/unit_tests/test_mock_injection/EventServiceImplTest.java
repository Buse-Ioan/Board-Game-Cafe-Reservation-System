package com.itschool.Board.Game.Cafe.Reservation.System.unit_tests.test_mock_injection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.Board.Game.Cafe.Reservation.System.models.dtos.EventDTO;
import com.itschool.Board.Game.Cafe.Reservation.System.models.entities.Event;
import com.itschool.Board.Game.Cafe.Reservation.System.repositories.EventRepository;
import com.itschool.Board.Game.Cafe.Reservation.System.services.EventServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EventServiceImplTest {

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventServiceImpl eventService;

    @Test
    public void testCreateEvent() {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(1L);
        eventDTO.setName("Catan Tournament");
        eventDTO.setGameGenre("Strategy");
        eventDTO.setEventDate(LocalDate.of(2024, 10, 30));
        eventDTO.setParticipants(30);  // Assuming this field exists
        eventDTO.setDescription("The tournament will take place over two days with an initial round and a final.");

        Event eventEntity = new Event();
        eventEntity.setId(1L);
        eventEntity.setName("Catan Tournament");
        eventEntity.setEventDate(LocalDate.of(2024, 10, 30));
        eventEntity.setParticipants(10);
        eventEntity.setGameGenre("Strategy");
        eventEntity.setDescription("The tournament will take place over two days with an initial round and a final.");


        when(eventRepository.save(any(Event.class))).thenReturn(eventEntity);
        when(objectMapper.convertValue(eventDTO, Event.class)).thenReturn(eventEntity);
        when(objectMapper.convertValue(eventEntity, EventDTO.class)).thenReturn(eventDTO);

        EventDTO createdEvent = eventService.createEvent(eventDTO);

        verify(eventRepository, times(1)).save(eventEntity)
        assertEquals("Catan Tournament", createdEvent.getName());
        assertEquals("Strategy", createdEvent.getGameGenre());
        assertEquals(LocalDate.of(2024, 10, 30), createdEvent.getEventDate());
        assertEquals(30, createdEvent.getParticipants());
        assertEquals("The tournament will take place over two days with an initial round and a final.", createdEvent.getDescription());
    }
}