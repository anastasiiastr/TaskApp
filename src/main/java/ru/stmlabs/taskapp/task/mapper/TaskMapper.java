package ru.stmlabs.taskapp.task.mapper;

import ru.stmlabs.taskapp.task.dto.TaskDtoFromRequest;
import ru.stmlabs.taskapp.task.dto.TaskResponseDto;
import ru.stmlabs.taskapp.task.entity.Task;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDtoFromRequest toDto(Task task);

    Task toEntity(TaskDtoFromRequest dto);

    TaskResponseDto toResponse(Task task);

    List<TaskResponseDto> toResponseList(List<Task> tasks);
}

