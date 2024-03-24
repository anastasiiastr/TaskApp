package ru.stmlabs.taskapp.user.mapper;

import ru.stmlabs.taskapp.user.dto.UserDto;
import ru.stmlabs.taskapp.user.dto.UserResponseDto;
import ru.stmlabs.taskapp.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "name", source = "login")
    @Mapping(target = "role", source = "role")
    User toEntity(UserDto user);

    @Mapping(target = "login", source = "name")
    UserDto toDto(User user);

    @Mapping(target = "login", source = "name")
    UserResponseDto toResponse(User user);

    UserResponseDto toResponse(UserDto user);
}
