package ru.stmlabs.taskapp.user.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.stmlabs.taskapp.user.dto.UserDto;
import ru.stmlabs.taskapp.user.dto.UserResponseDto;
import ru.stmlabs.taskapp.user.entity.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-01T16:26:47+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (JetBrains s.r.o.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDto user) {
        if ( user == null ) {
            return null;
        }

        User user1 = new User();

        user1.setName( user.getLogin() );
        user1.setRole( user.getRole() );
        user1.setId( user.getId() );
        user1.setPassword( user.getPassword() );
        user1.setActive( user.getActive() );

        return user1;
    }

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setLogin( user.getName() );
        userDto.setId( user.getId() );
        userDto.setPassword( user.getPassword() );
        userDto.setActive( user.getActive() );
        userDto.setRole( user.getRole() );

        return userDto;
    }

    @Override
    public UserResponseDto toResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setLogin( user.getName() );
        userResponseDto.setActive( user.getActive() );
        userResponseDto.setRole( user.getRole() );

        return userResponseDto;
    }

    @Override
    public UserResponseDto toResponse(UserDto user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setLogin( user.getLogin() );
        userResponseDto.setActive( user.getActive() );
        userResponseDto.setRole( user.getRole() );

        return userResponseDto;
    }
}
