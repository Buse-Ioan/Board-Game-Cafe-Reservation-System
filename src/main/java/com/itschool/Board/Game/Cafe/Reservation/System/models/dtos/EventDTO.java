package com.itschool.Board.Game.Cafe.Reservation.System.models.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EventDTO {

    private Long id;
    @NotBlank(message = "This field is mandatory")
    private String name;
    private LocalDate eventDate;
    private int participants;
    private String gameCategory;
}