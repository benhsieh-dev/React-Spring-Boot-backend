package com.starbucks.backend.services.impl;

import com.starbucks.backend.dto.CustomerDTO;
import com.starbucks.backend.dto.LoginDTO;
import com.starbucks.backend.entities.Customer;
import com.starbucks.backend.payloadresponse.LoginMessage;
import com.starbucks.backend.repositories.CustomerRepository;
import com.starbucks.backend.response.LoginResponse;
import com.starbucks.backend.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public LoginResponse loginCustomer(LoginDTO loginDTO) {
        String msg = "";
        Customer customer1 = customerRepository.findByEmail(loginDTO.getEmail());
        if (customer1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = customer1.getPassword();
            Boolean isPwdCorrect = passwordEncoder.matches(password, encodedPassword);
            if (isPwdCorrect) {
                Optional<Customer> customer = customerRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (customer.isPresent()) {
                    return new LoginResponse("Login Successful!", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("Password does not match", false);
            }
        } else {
            return new LoginResponse("Email does not exist", false);
        }
    }

}
