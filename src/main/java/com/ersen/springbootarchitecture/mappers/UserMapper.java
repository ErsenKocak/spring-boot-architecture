package com.ersen.springbootarchitecture.mappers;


import com.ersen.springbootarchitecture.dto.UserDto;
import com.ersen.springbootarchitecture.dto.request.CreateUserRequest;
import com.ersen.springbootarchitecture.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User requestToUser(CreateUserRequest createUserRequest);

    UserDto userToDto(User user);

    User dtoToUser(UserDto userDto);

}
