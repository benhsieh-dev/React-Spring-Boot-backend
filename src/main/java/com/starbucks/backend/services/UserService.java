package com.starbucks.backend.services;

import com.starbucks.backend.dto.CredentialsDto;
import com.starbucks.backend.dto.UserDto;
import com.starbucks.backend.entities.User;
import com.starbucks.backend.exceptions.AppException;
import com.starbucks.backend.mappers.UserMapper;
import com.starbucks.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserDto fingByLogin(String login) {
        User user = userRepository.findByLogin(login)
                .orElseThrow( ()-> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }

    public UserDto login(CredentialsDto credentialsDto) {
        User user = userRepository.findByLogin(credentialsDto.getLogin())
                .orElseThrow( ()-> new AppException("Unknown user", HttpStatus.NOT_FOUND));

    }
}
