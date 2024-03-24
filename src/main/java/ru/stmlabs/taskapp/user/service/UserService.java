package ru.stmlabs.taskapp.user.service;

import ru.stmlabs.taskapp.user.dto.UserDto;
import ru.stmlabs.taskapp.user.dto.UserResponseDto;
import ru.stmlabs.taskapp.user.util.UserRolesEnum;

public interface UserService {

    UserResponseDto save(UserDto dto);

    UserDto getByUserName(String userName);

    UserResponseDto update(UserDto dto);

    UserResponseDto setRole(String userName, String password, UserRolesEnum role);

    UserResponseDto authorizeUser(String userName, String password);

    UserResponseDto addFavourite(Long taskId, Long userId);
}
