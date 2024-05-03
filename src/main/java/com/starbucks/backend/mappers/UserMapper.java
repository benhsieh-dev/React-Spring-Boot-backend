package com.starbucks.backend.mappers;

import com.starbucks.backend.dto.SignUpDto;
import com.starbucks.backend.dto.UserDto;
import com.starbucks.backend.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto userDto);
}
