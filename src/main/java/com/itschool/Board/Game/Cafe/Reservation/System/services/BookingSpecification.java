package com.itschool.Board.Game.Cafe.Reservation.System.services;

import com.itschool.Board.Game.Cafe.Reservation.System.models.entities.Booking;
import org.springframework.data.jpa.domain.Specification;

public class BookingSpecification {

    public static Specification<Booking> customerNameContains(String customerName) {
        return (booking, query, criteriaBuilder) -> customerName == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(booking.get("customerName")), "%" + customerName.toLowerCase() + "%");
    }

    public static Specification<Booking> emailContains(String email) {
        return (booking, query, criteriaBuilder) -> email == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(booking.get("email")), "%" + email.toLowerCase() + "%");
    }
}