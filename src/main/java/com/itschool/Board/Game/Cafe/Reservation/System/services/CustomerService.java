package com.itschool.Board.Game.Cafe.Reservation.System.services;

import com.itschool.Board.Game.Cafe.Reservation.System.models.dtos.RequestCustomerDTO;
import com.itschool.Board.Game.Cafe.Reservation.System.models.dtos.ResponseCustomerDTO;

import java.util.List;

public interface CustomerService {

    ResponseCustomerDTO createCustomer(RequestCustomerDTO requestCustomerDTO);
}