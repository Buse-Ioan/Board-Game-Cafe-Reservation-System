package com.itschool.Board.Game.Cafe.Reservation.System.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.Board.Game.Cafe.Reservation.System.exceptions.GameNotFoundException;
import com.itschool.Board.Game.Cafe.Reservation.System.models.dtos.BookingDTO;
import com.itschool.Board.Game.Cafe.Reservation.System.models.entities.Booking;
import com.itschool.Board.Game.Cafe.Reservation.System.repositories.BookingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    private static final Logger log = LoggerFactory.getLogger(BookingServiceImpl.class);
    private final ObjectMapper objectMapper;
    private final BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(ObjectMapper objectMapper, BookingRepository bookingRepository) {
        this.objectMapper = objectMapper;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        Booking booking = objectMapper.convertValue(bookingDTO, Booking.class);
        Booking savedBooking = bookingRepository.save(booking);
        log.info("Booking saved successfully with ID: {}", savedBooking.getId());

        return objectMapper.convertValue(savedBooking, BookingDTO.class);
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        log.info("Found {} table bookings", bookings.size());

        return bookings.stream()
                .map(booking -> objectMapper.convertValue(booking, BookingDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookingDTO getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException("Booking not found with ID: " + id));
        log.info("Booking found: {}", booking.getCustomerName());

        return objectMapper.convertValue(booking, BookingDTO.class);
    }

    @Override
    public List<BookingDTO> getBookingByEmail(String email) {
        List<Booking> bookings = bookingRepository.findBookingByEmail(email);
        log.info("Found {} bookings for customer email: {}", bookings.size(), email);

        return bookings.stream()
                .map(booking -> objectMapper.convertValue(booking, BookingDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookingDTO> getByBookingDate(LocalDate bookingDate) {
        List<Booking> bookings = bookingRepository.findByBookingDate(bookingDate);

        return bookings.stream()
                .map(booking -> objectMapper.convertValue(booking, BookingDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookingDTO> getBookingByCustomerName(String customerName) {
        List<Booking> bookings = bookingRepository.findByCustomerNameContainingIgnoreCase(customerName);

        return bookings.stream()
                .map(booking -> objectMapper.convertValue(booking, BookingDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookingDTO> getBookings(String customerName, String email) {
        Specification<Booking> spec = Specification
                .where(BookingSpecification.customerNameContains(customerName))
                .and(BookingSpecification.emailContains(email));

        return bookingRepository.findAll(spec).stream()
                .map(booking -> objectMapper.convertValue(booking, BookingDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookingDTO updateBooking(Long id, BookingDTO bookingDTO) {
        Booking existingBooking = bookingRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException("Booking not found with ID: " + id));

        existingBooking.setCustomerName(bookingDTO.getCustomerName());
        existingBooking.setEmail(bookingDTO.getEmail());
        existingBooking.setBookingDate(bookingDTO.getBookingDate());
        existingBooking.setNumberOfPeople(bookingDTO.getNumberOfPeople());

        Booking updatedBooking = bookingRepository.save(existingBooking);
        log.info("Booking updated successfully for customer: {}", updatedBooking.getCustomerName());

        return objectMapper.convertValue(updatedBooking, BookingDTO.class);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException("Booking not found with ID: " + id));
        bookingRepository.deleteById(id);
        log.info("Booking deleted successfully");
    }
}