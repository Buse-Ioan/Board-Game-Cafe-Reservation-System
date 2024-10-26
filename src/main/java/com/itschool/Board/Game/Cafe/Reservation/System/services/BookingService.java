package com.itschool.Board.Game.Cafe.Reservation.System.services;

import com.itschool.Board.Game.Cafe.Reservation.System.models.dtos.BookingDTO;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {

    BookingDTO createBooking(BookingDTO bookingDTO);

    List<BookingDTO> findAllBookings();

    BookingDTO findBookingById(Long id);

    List<BookingDTO> findBookingByEmail(String Email);

    List<BookingDTO> findByBookingDate(LocalDate reservationDate);

    BookingDTO updateBooking(Long id, BookingDTO bookingDTO);

    void deleteBooking(Long id);

    List<BookingDTO> findBookingByCustomerName(String customerName);

    List<BookingDTO> getBookings(String name, String email);
}