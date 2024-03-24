package ru.stmlabs.taskapp.task.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDtoFromRequest {

    private Long id;

    @NotEmpty
    private String text;

    @NotEmpty
    private String tag;

    @NotEmpty
    private String authorName;
}
