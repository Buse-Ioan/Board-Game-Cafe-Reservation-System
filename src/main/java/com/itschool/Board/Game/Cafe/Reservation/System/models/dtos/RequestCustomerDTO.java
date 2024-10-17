package com.itschool.Board.Game.Cafe.Reservation.System.models.dtos;

import lombok.Data;

@Data
public class RequestCustomerDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}