package com.starbucks.backend.mappers;

import com.starbucks.backend.dto.UserDto;
import com.starbucks.backend.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);
}
