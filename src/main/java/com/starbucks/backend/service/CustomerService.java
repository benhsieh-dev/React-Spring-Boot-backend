package com.starbucks.backend.service;

import com.starbucks.backend.dto.CustomerDTO;
import com.starbucks.backend.dto.LoginDTO;
import com.starbucks.backend.response.LoginResponse;

public interface CustomerService {


    String addCustomer(CustomerDTO customerDTO);

    LoginResponse loginCustomer(LoginDTO loginDTO);
}
