package ru.stmlabs.taskapp.user.dto;

import ru.stmlabs.taskapp.user.util.UserRolesEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private String login;

    private Boolean active;

    private UserRolesEnum role;
}
