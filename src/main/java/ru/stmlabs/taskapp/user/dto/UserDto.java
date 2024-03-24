package ru.stmlabs.taskapp.user.dto;

import ru.stmlabs.taskapp.user.util.UserRolesEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    @NotEmpty
    private String login;

    @NotEmpty
    private String password;

    private Boolean active;

    @NotNull
    private UserRolesEnum role;
}
