package com.itschool.Board.Game.Cafe.Reservation.System.services;

import com.itschool.Board.Game.Cafe.Reservation.System.models.dtos.BookingDTO;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {

    BookingDTO createBooking(BookingDTO bookingDTO);

    List<BookingDTO> getAllBookings();

    BookingDTO getBookingById(Long id);

    List<BookingDTO> getBookingByEmail(String Email);

    List<BookingDTO> getByBookingDate(LocalDate reservationDate);

    BookingDTO updateBooking(Long id, BookingDTO bookingDTO);

    void deleteBooking(Long id);

    List<BookingDTO> getBookingByCustomerName(String customerName);

    List<BookingDTO> getBookings(String name, String email);
}