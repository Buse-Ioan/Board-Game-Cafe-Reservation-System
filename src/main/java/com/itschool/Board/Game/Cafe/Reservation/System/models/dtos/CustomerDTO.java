package com.itschool.Board.Game.Cafe.Reservation.System.models.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class CustomerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}