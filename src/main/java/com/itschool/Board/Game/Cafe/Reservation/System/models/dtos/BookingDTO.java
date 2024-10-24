package com.itschool.Board.Game.Cafe.Reservation.System.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingDTO {

    private Long id;

    @NotBlank(message = "Customer name cannot be blank")
    private String customerName;

    @NotBlank(message = "Customer email cannot be blank")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email should be valid")
    private String customerEmail;

    @NotNull(message = "Booking date is required")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate bookingDate;

//    @Max(value = 20, message = "There cannot be more than 20 people for a booking")
//    @Min(value = 1, message = "At least one person is required")
    private int numberOfPeople;
}