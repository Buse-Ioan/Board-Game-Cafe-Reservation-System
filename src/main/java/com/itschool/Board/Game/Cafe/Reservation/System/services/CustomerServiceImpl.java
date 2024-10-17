package com.itschool.Board.Game.Cafe.Reservation.System.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.Board.Game.Cafe.Reservation.System.exceptions.CustomerDuplicateEmailException;
import com.itschool.Board.Game.Cafe.Reservation.System.models.dtos.RequestCustomerDTO;
import com.itschool.Board.Game.Cafe.Reservation.System.models.dtos.ResponseCustomerDTO;
import com.itschool.Board.Game.Cafe.Reservation.System.models.entities.Customer;
import com.itschool.Board.Game.Cafe.Reservation.System.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final ObjectMapper objectMapper;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(ObjectMapper objectMapper, CustomerRepository customerRepository) {
        this.objectMapper = objectMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public ResponseCustomerDTO createCustomer(RequestCustomerDTO requestCustomerDTO) {
        validateEmailAddress(requestCustomerDTO);

        Customer customerEntity = objectMapper.convertValue(requestCustomerDTO, Customer.class);
        Customer customerEntityResponse = customerRepository.save(customerEntity);
        log.info("Customer with id {} was saved", customerEntityResponse.getId());

        return objectMapper.convertValue(customerEntityResponse, ResponseCustomerDTO.class);
    }

    private void validateEmailAddress(RequestCustomerDTO requestCustomerDTO) {
        Customer customer = customerRepository.findByEmail(requestCustomerDTO.getEmail());
        if (customer != null) {
            throw new CustomerDuplicateEmailException("Email address already exists");
        }
    }
}