package com.itschool.Board.Game.Cafe.Reservation.System.models.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EventDTO {

    private Long id;

    @NotBlank(message = "This field is mandatory")
    private String name;

    @NotNull(message = "Event date is required")
    private LocalDate eventDate;

    @Min(value = 2, message = "The minimum number of participants must be at least 2")
    @Max(value = 10, message = "The maximum number of participants cannot exceed 10")
    private int participants;

    @NotBlank(message = "Event genre cannot be blank")
    private String genre;

    @NotBlank(message = "Event description is required")
    private String description;
}