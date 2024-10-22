package com.itschool.Board.Game.Cafe.Reservation.System.repositories;

import com.itschool.Board.Game.Cafe.Reservation.System.models.entities.TableBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TableBookingRepository extends JpaRepository<TableBooking, Long> {

    List<TableBooking> findByReservationTime(LocalDateTime reservationTime);

    List<TableBooking> findBookingByCustomerEmail(String customerEmail);
}