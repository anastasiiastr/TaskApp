package ru.stmlabs.taskapp.task.service;

import ru.stmlabs.taskapp.exception.impl.AccessDeniedException;
import ru.stmlabs.taskapp.exception.impl.TaskExistException;
import ru.stmlabs.taskapp.task.dto.TaskDtoFromRequest;
import ru.stmlabs.taskapp.task.dto.TaskResponseDto;
import ru.stmlabs.taskapp.task.mapper.TaskMapper;
import ru.stmlabs.taskapp.task.repository.TaskRepository;
import ru.stmlabs.taskapp.user.util.UserRolesEnum;
import ru.stmlabs.taskapp.user.mapper.UserMapper;
import ru.stmlabs.taskapp.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    private final TaskMapper mapper;

    private final UserService userService;

    private final UserMapper userMapper;

    @Override
    public TaskResponseDto save(TaskDtoFromRequest dto) {

        var author = userService.getByUserName(dto.getAuthorName());

        var task = mapper.toEntity(dto);

        task.setAuthor(userMapper.toEntity(author));

        var response = mapper.toResponse(repository.save(task));

        response.setAuthor(userMapper.toResponse(author));

        return response;
    }

    @Override
    public List<TaskResponseDto> getByAuthorName(String authorName, String password) {

        var author = userService.authorizeUser(authorName, password);

        return mapper.toResponseList(repository.findAllByAuthorName(author.getLogin()));
    }

    @Override
    public TaskResponseDto update(Long taskId, TaskDtoFromRequest dto, String userName, String password) {

        if (!userService.authorizeUser(userName, password).getRole().equals(UserRolesEnum.ADMIN)) {

            throw new AccessDeniedException("Access denied for user " + userName + " insufficient access rights");
        }

        var task = repository.findById(taskId).orElseThrow(
                () -> {
                    throw new TaskExistException("Update task failed. No task found");
                });

        task.setText(Objects.toString(dto.getText(), task.getText()));
        task.setTag(Objects.toString(dto.getTag(), task.getTag()));

        return mapper.toResponse(repository.save(task));
    }

    @Override
    public List<TaskResponseDto> getAllByTag(String tag, String userName, String password) {

        var author = userService.authorizeUser(userName, password);

        var response = repository.findAllByTag(tag).stream().map(mapper::toResponse).toList();

        response.forEach(s -> s.setAuthor(author));

        return response;
    }
}
