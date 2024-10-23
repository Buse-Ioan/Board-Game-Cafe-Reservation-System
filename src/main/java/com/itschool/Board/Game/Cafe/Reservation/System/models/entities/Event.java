package com.itschool.Board.Game.Cafe.Reservation.System.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long id;

    @NotBlank(message = "Event name cannot be blank")
    @Column(name = "event_name")
    private String name;

    @Column(name = "event_date", nullable = false)
    private LocalDate eventDate;

    @Column(name = "participants", nullable = false)
    private int participants;

    @Column(name = "game_category", nullable = false)
    private String gameCategory;

    @Column(name = "description")
    private String description;
}