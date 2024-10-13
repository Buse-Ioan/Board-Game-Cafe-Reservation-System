package com.itschool.Board.Game.Cafe.Reservation.System.repositories;

import com.itschool.Board.Game.Cafe.Reservation.System.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}