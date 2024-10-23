package com.itschool.Board.Game.Cafe.Reservation.System.repositories;

import com.itschool.Board.Game.Cafe.Reservation.System.models.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findBookingByCustomerEmail(String customerEmail);

    List<Booking> findByBookingDate(LocalDate bookingDate);
}