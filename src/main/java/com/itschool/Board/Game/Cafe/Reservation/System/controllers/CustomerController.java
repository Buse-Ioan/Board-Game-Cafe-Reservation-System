package com.itschool.Board.Game.Cafe.Reservation.System.controllers;

import com.itschool.Board.Game.Cafe.Reservation.System.models.dtos.RequestCustomerDTO;
import com.itschool.Board.Game.Cafe.Reservation.System.models.dtos.ResponseCustomerDTO;
import com.itschool.Board.Game.Cafe.Reservation.System.services.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Operation(summary = "Create a new customer")
    @PostMapping("/api/customers")
    public ResponseEntity<ResponseCustomerDTO> createCustomer(
            @RequestBody
            RequestCustomerDTO requestCustomerDTO) {
        return ResponseEntity.ok(customerService.createCustomer(requestCustomerDTO));
    }

//    @GetMapping("/api/customers/{id}")
//    public ResponseEntity<List<RequestCustomerDTO>> getCustomers(@PathVariable String id) {
//        return ResponseEntity.ok(customerService.getCustomers());
//    }
}