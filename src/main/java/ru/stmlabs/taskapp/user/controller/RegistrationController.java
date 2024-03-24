package ru.stmlabs.taskapp.user.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import ru.stmlabs.taskapp.user.dto.UserDto;
import ru.stmlabs.taskapp.user.dto.UserResponseDto;
import ru.stmlabs.taskapp.user.util.UserRolesEnum;
import ru.stmlabs.taskapp.user.mapper.UserMapper;
import ru.stmlabs.taskapp.user.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class RegistrationController {

    private final UserService service;

    @Qualifier("userMapper")
    private final UserMapper mapper;

    @GetMapping("/registration")
    public String registration() {

        return "registration";
    }

    @PostMapping("/create")
    public UserResponseDto addUser(@RequestBody @Valid UserDto user) {

        return service.save(user);

//        return "redirect:/login";
    }

    @GetMapping("/{login}")
    public UserResponseDto getByUserName(@PathVariable("login") @NotEmpty String login) {

        return mapper.toResponse(service.getByUserName(login));
    }

    @PostMapping("/{login}/{password}/{role}")
    public UserResponseDto addRole(@PathVariable("login") @NotEmpty String login,
                                   @PathVariable("password") @NotEmpty String password,
                                   @PathVariable("role") @NonNull UserRolesEnum role) {

        return service.setRole(login, password, role);
    }

    @PostMapping("/add/{userId}/favourite/{taskId}")
    public UserResponseDto addFavourite(@PathVariable("taskId") Long taskId,
                                        @PathVariable("userId") Long userId) {

        return service.addFavourite(taskId, userId);
    }
}
