package com.starbucks.backend.service.impl;

import com.starbucks.backend.dto.CustomerDTO;
import com.starbucks.backend.entity.Customer;
import com.starbucks.backend.repository.CustomerRepository;
import com.starbucks.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerImpl implements CustomerService {


    @Autowired
    private CustomerRepository customerRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getFirstName(),
                customerDTO.getLastName(),
                customerDTO.getEmail(),
                this.passwordEncoder.encode(customerDTO.getPassword())
        );

        customerRepository.save(customer);
        return customer.getFirstName();
    }
}
