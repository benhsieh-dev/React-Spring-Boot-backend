package com.starbucks.backend.services;

import com.starbucks.backend.dto.UserDto;
import com.starbucks.backend.exceptions.AppException;
import com.starbucks.backend.re.UserRepository;
import com.starbucks.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserDto fingByLogin(String login) {
        User user = userRepository.findByLogin(login)
                .orElseThrow( ()-> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }
}
