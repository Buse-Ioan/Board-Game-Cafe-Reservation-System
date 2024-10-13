package com.itschool.Board.Game.Cafe.Reservation.System.services;

import com.itschool.Board.Game.Cafe.Reservation.System.models.dtos.CustomerDTO;
import com.itschool.Board.Game.Cafe.Reservation.System.models.entities.Customer;

import java.util.List;

public interface CustomerService {

    CustomerDTO createCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getCustomers();
}