package com.itschool.Board.Game.Cafe.Reservation.System.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.Board.Game.Cafe.Reservation.System.models.dtos.CustomerDTO;
import com.itschool.Board.Game.Cafe.Reservation.System.models.entities.Customer;
import com.itschool.Board.Game.Cafe.Reservation.System.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ObjectMapper objectMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ObjectMapper objectMapper) {
        this.customerRepository = customerRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        if (customerDTO.getEmail().length() < 3) {
            throw new RuntimeException("Invalid email!");
        }
        Customer customerEntityToBeSaved = objectMapper.convertValue(customerDTO, Customer.class);
        Customer customerResponseEntity = customerRepository.save(customerEntityToBeSaved);
        log.info("Created customer with id: {}", customerResponseEntity.getId());

        return objectMapper.convertValue(customerResponseEntity, CustomerDTO.class);
    }

    @Override
    public List<CustomerDTO> getCustomers() {
        List<Customer> customers = customerRepository.findAll();

        return customers.stream()
                .map(customer -> objectMapper.convertValue(customer, CustomerDTO.class))
                .toList();
    }
}