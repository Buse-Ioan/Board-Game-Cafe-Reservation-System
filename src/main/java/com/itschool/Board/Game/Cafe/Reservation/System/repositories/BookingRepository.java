package com.itschool.Board.Game.Cafe.Reservation.System.repositories;

import com.itschool.Board.Game.Cafe.Reservation.System.models.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long>, JpaSpecificationExecutor<Booking> {

    List<Booking> findBookingByEmail(String customerEmail);

    List<Booking> findByBookingDate(LocalDate bookingDate);

    List<Booking> findByCustomerNameContainingIgnoreCase(String customerName);
}