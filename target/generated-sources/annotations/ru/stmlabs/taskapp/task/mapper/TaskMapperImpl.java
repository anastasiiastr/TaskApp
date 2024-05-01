package ru.stmlabs.taskapp.task.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.stmlabs.taskapp.task.dto.TaskDtoFromRequest;
import ru.stmlabs.taskapp.task.dto.TaskResponseDto;
import ru.stmlabs.taskapp.task.entity.Task;
import ru.stmlabs.taskapp.user.dto.UserResponseDto;
import ru.stmlabs.taskapp.user.entity.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-12T10:12:09+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public TaskDtoFromRequest toDto(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskDtoFromRequest taskDtoFromRequest = new TaskDtoFromRequest();

        taskDtoFromRequest.setId( task.getId() );
        taskDtoFromRequest.setText( task.getText() );
        taskDtoFromRequest.setTag( task.getTag() );

        return taskDtoFromRequest;
    }

    @Override
    public Task toEntity(TaskDtoFromRequest dto) {
        if ( dto == null ) {
            return null;
        }

        Task task = new Task();

        task.setId( dto.getId() );
        task.setText( dto.getText() );
        task.setTag( dto.getTag() );

        return task;
    }

    @Override
    public TaskResponseDto toResponse(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskResponseDto taskResponseDto = new TaskResponseDto();

        taskResponseDto.setText( task.getText() );
        taskResponseDto.setTag( task.getTag() );
        taskResponseDto.setAuthor( userToUserResponseDto( task.getAuthor() ) );

        return taskResponseDto;
    }

    @Override
    public List<TaskResponseDto> toResponseList(List<Task> tasks) {
        if ( tasks == null ) {
            return null;
        }

        List<TaskResponseDto> list = new ArrayList<TaskResponseDto>( tasks.size() );
        for ( Task task : tasks ) {
            list.add( toResponse( task ) );
        }

        return list;
    }

    protected UserResponseDto userToUserResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setActive( user.getActive() );
        userResponseDto.setRole( user.getRole() );

        return userResponseDto;
    }
}
