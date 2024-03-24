package ru.stmlabs.taskapp.user.service;

import org.springframework.beans.factory.annotation.Qualifier;
import ru.stmlabs.taskapp.exception.impl.AccessDeniedException;
import ru.stmlabs.taskapp.exception.impl.UserExistException;
import ru.stmlabs.taskapp.user.dto.UserDto;
import ru.stmlabs.taskapp.user.dto.UserResponseDto;
import ru.stmlabs.taskapp.user.util.UserRolesEnum;
import ru.stmlabs.taskapp.user.mapper.UserMapper;
import ru.stmlabs.taskapp.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Qualifier("userMapper")
    private final UserMapper mapper;

    private final UserRepository userRepository;

    @Override
    public UserResponseDto save(UserDto dto) {

        if (userRepository.existsUserByName(dto.getLogin())) {

            throw new UserExistException("User with name " + dto.getLogin() + " already exist");
        }

        var user = userRepository.save(mapper.toEntity(dto));

        return mapper.toResponse(user);
    }

    @Override
    public UserDto getByUserName(String userName) {

        var user =  userRepository.findByName(userName).orElseThrow(
                () -> {
                    throw new UserExistException("User with name = " + userName + " not found");
                });

       return mapper.toDto(user);
    }

    @Override
    public UserResponseDto update(UserDto dto) {

        if(!Objects.equals(dto.getRole(), UserRolesEnum.ADMIN)) {

            throw new AccessDeniedException("Access denied. User has insufficient rights");
        }

        var user = userRepository.findByNameAndPassword(dto.getLogin(), dto.getPassword()).orElseThrow(
                () -> {
                    throw new UserExistException("Update failed. User with specified log data not found");
                });

        user.setPassword(Objects.toString(dto.getPassword(), user.getPassword()));

        if (dto.getActive() != null) {
            user.setActive(dto.getActive());
        }

        var response = userRepository.save(user);

        return mapper.toResponse(response);
    }

    @Override
    public UserResponseDto setRole(String userName, String password, UserRolesEnum role) {

        var user = userRepository.findByNameAndPassword(userName, password).orElseThrow(
                () -> {
                    throw new AccessDeniedException("Access denied for user " + userName + " check login and password");
                });

        if (!user.getRole().equals(UserRolesEnum.ADMIN)) {
            throw new AccessDeniedException("Access denied for user " + userName + " insufficient access rights");
        }

        user.setRole(role);

        return mapper.toResponse(userRepository.save(user));
    }

    @Override
    public UserResponseDto authorizeUser(String userName, String password) {

        var user = userRepository.findByNameAndPassword(userName, password).orElseThrow(
                () -> {
                    throw new AccessDeniedException("Access denied for user " + userName + " check login and password");
                });

        return mapper.toResponse(user);
    }

    @Override
    public UserResponseDto addFavourite(Long taskId, Long userId) {

        //todo Валидация пользователя
        //todo task valid

        //todo save request

        //todo return response
        return null;
    }
}
