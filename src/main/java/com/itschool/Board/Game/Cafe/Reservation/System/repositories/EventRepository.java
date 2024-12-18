package com.itschool.Board.Game.Cafe.Reservation.System.repositories;

import com.itschool.Board.Game.Cafe.Reservation.System.models.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>, JpaSpecificationExecutor<Event> {

    List<Event> findEventByName(String name);

    List<Event> findByEventDate(LocalDate eventDate);
}