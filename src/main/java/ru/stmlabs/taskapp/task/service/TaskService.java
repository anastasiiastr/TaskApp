package ru.stmlabs.taskapp.task.service;

import ru.stmlabs.taskapp.task.dto.TaskDtoFromRequest;
import ru.stmlabs.taskapp.task.dto.TaskResponseDto;

import java.util.List;

public interface TaskService {

    TaskResponseDto save(TaskDtoFromRequest dto);

    List<TaskResponseDto> getByAuthorName(String authorName, String password);

    TaskResponseDto update(Long taskId, TaskDtoFromRequest task, String userName, String password);

    List<TaskResponseDto> getAllByTag(String tag, String userName, String password);
}
