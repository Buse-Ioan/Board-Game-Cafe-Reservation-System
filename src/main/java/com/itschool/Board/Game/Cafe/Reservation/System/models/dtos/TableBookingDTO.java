package com.itschool.Board.Game.Cafe.Reservation.System.models.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TableBookingDTO {

    private Long id;
    @NotBlank(message = "Customer name cannot be blank")
    private String customerName;
    @NotBlank(message = "Customer email cannot be blank")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email should be valid")
    private String customerEmail;
    private LocalDateTime reservationTime;
    @Min(value = 1, message = "There must be at least 1 person for a booking")
    @Max(value = 20, message = "There cannot be more than 20 people for a booking")
    private int numberOfPeople;
}