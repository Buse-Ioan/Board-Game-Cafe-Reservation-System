package com.itschool.Board.Game.Cafe.Reservation.System.controllers;

import com.itschool.Board.Game.Cafe.Reservation.System.models.dtos.CustomerDTO;
import com.itschool.Board.Game.Cafe.Reservation.System.models.entities.Customer;
import com.itschool.Board.Game.Cafe.Reservation.System.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService userService) {
        this.customerService = userService;
    }

    @PostMapping("/api/customers")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.createCustomer(customerDTO));
    }

    @GetMapping("/api/customers/{id}")
    public ResponseEntity<List<CustomerDTO>> getUsers(@PathVariable String id) {
        return ResponseEntity.ok(customerService.getCustomers());
    }
}