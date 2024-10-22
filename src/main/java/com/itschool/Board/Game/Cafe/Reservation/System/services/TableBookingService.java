package com.itschool.Board.Game.Cafe.Reservation.System.services;

import com.itschool.Board.Game.Cafe.Reservation.System.models.dtos.TableBookingDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface TableBookingService {

    TableBookingDTO saveBooking(TableBookingDTO bookingDTO);

    List<TableBookingDTO> findAllBookings();

    TableBookingDTO findBookingById(Long id);

    List<TableBookingDTO> findBookingByCustomerEmail(String customerEmail);

    List<TableBookingDTO> findByReservationTime(LocalDateTime reservationTime);

    TableBookingDTO updateBooking(Long id, TableBookingDTO bookingDTO);

    void deleteBooking(Long id);



}