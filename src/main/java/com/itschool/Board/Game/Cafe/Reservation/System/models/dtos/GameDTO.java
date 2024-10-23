package com.itschool.Board.Game.Cafe.Reservation.System.models.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GameDTO {

    private Long id;

    @NotBlank(message = "Game name cannot be blank")
    private String name;

    @NotBlank(message = "Game genre cannot be blank")
    private String genre;

    @Min(value = 2, message = "Minimum number of players must be at least 2")
    @Max(value = 10, message = "Maximum number of players cannot exceed 10")
    private int minPlayers;

    @Min(value = 2, message = "Minimum number of players must be at least 2")
    @Max(value = 10, message = "Maximum number of players cannot exceed 10")
    private int maxPlayers;

    @NotNull(message = "Availability status is required")
    private Boolean availability;
}