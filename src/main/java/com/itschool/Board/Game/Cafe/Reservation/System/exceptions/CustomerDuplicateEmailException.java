package com.itschool.Board.Game.Cafe.Reservation.System.exceptions;

public class CustomerDuplicateEmailException extends RuntimeException {

    public CustomerDuplicateEmailException(String message) {
        super(message);
    }
}