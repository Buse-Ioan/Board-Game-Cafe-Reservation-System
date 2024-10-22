package com.itschool.Board.Game.Cafe.Reservation.System.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.Board.Game.Cafe.Reservation.System.exceptions.GameNotFoundException;
import com.itschool.Board.Game.Cafe.Reservation.System.models.dtos.TableBookingDTO;
import com.itschool.Board.Game.Cafe.Reservation.System.models.entities.TableBooking;
import com.itschool.Board.Game.Cafe.Reservation.System.repositories.TableBookingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TableBookingServiceImpl implements TableBookingService {

    private static final Logger log = LoggerFactory.getLogger(TableBookingServiceImpl.class);
    private final ObjectMapper objectMapper;
    private final TableBookingRepository tableBookingRepository;

    @Autowired
    public TableBookingServiceImpl(ObjectMapper objectMapper, TableBookingRepository tableBookingRepository) {
        this.objectMapper = objectMapper;
        this.tableBookingRepository = tableBookingRepository;
    }

    @Override
    public TableBookingDTO saveBooking(TableBookingDTO bookingDTO) {
        log.info("Saving new booking for customer: {}", bookingDTO.getCustomerName());
        TableBooking booking = objectMapper.convertValue(bookingDTO, TableBooking.class);
        TableBooking savedBooking = tableBookingRepository.save(booking);
        log.info("Booking saved successfully with ID: {}", savedBooking.getId());
        return objectMapper.convertValue(savedBooking, TableBookingDTO.class);
    }

    @Override
    public List<TableBookingDTO> findAllBookings() {
        List<TableBooking> bookings = tableBookingRepository.findAll();
        log.info("Found {} table bookings", bookings.size());
        return bookings.stream()
                .map(booking -> objectMapper.convertValue(booking, TableBookingDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TableBookingDTO findBookingById(Long id) {
        TableBooking booking = tableBookingRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException("Booking not found with ID: " + id));
        log.info("Booking found: {}", booking.getCustomerName());
        return objectMapper.convertValue(booking, TableBookingDTO.class);
    }

    @Override
    public List<TableBookingDTO> findBookingByCustomerEmail(String customerEmail) {
        List<TableBooking> bookings = tableBookingRepository.findBookingByCustomerEmail(customerEmail);
        log.info("Found {} bookings for customer email: {}", bookings.size(), customerEmail);
        return bookings.stream()
                .map(booking -> objectMapper.convertValue(booking, TableBookingDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<TableBookingDTO> findByReservationTime(LocalDateTime reservationTime) {
        List<TableBooking> bookings = tableBookingRepository.findByReservationTime(reservationTime);
        return bookings.stream()
                .map(booking -> objectMapper.convertValue(booking, TableBookingDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TableBookingDTO updateBooking(Long id, TableBookingDTO bookingDTO) {
        TableBooking existingBooking = tableBookingRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException("Booking not found with ID: " + id));

        existingBooking.setCustomerName(bookingDTO.getCustomerName());
        existingBooking.setCustomerEmail(bookingDTO.getCustomerEmail());
        existingBooking.setReservationTime(bookingDTO.getReservationTime());
        existingBooking.setNumberOfPeople(bookingDTO.getNumberOfPeople());

        TableBooking updatedBooking = tableBookingRepository.save(existingBooking);
        log.info("Booking updated successfully for customer: {}", updatedBooking.getCustomerName());
        return objectMapper.convertValue(updatedBooking, TableBookingDTO.class);
    }

    @Override
    public void deleteBooking(Long id) {
        tableBookingRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException("Booking not found with ID: " + id));
        tableBookingRepository.deleteById(id);
        log.info("Booking deleted successfully");
    }


}