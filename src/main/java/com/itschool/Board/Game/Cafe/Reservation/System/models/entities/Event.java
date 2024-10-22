package com.itschool.Board.Game.Cafe.Reservation.System.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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

    @Column(name = "event_name")
    @NotBlank(message = "Event name cannot be blank")
    private String name;

    @Column(name = "event_date", nullable = false)
    private LocalDate eventDate;

    @Min(value = 2, message = "The minimum number of participants must be at least 2")
    @Max(value = 10, message = "The maximum number of participants cannot exceed 10")
    @Column(name = "participants", nullable = false)
    private int participants;

    @Column(name = "game_category", nullable = false)
    private String gameCategory;

    @Column(name = "description")
    private String description;
}