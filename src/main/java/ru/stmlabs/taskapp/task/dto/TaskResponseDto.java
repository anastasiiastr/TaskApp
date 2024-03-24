package ru.stmlabs.taskapp.task.dto;

import ru.stmlabs.taskapp.user.dto.UserResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponseDto {

    private String text;

    private String tag;

    private UserResponseDto author;
}
