package com.ersen.springbootarchitecture.service;


import com.ersen.springbootarchitecture.dto.UserDto;
import com.ersen.springbootarchitecture.dto.request.CreateUserRequest;
import com.ersen.springbootarchitecture.entity.User;
import com.ersen.springbootarchitecture.exception.UserNotFoundException;
import com.ersen.springbootarchitecture.mappers.UserMapper;
import com.ersen.springbootarchitecture.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    @PostConstruct
    public void  init(){
        User user = User.builder()
                .id(UUID.randomUUID())
                .userName("ErsenKocak")
                .email("ersenkocak9@gmail.com")
                .password("1234")
                .name("Ersen")
                .surName("Koçak")
                .build();

        userRepository.save(user);
    }

    public UserDto saveUser(CreateUserRequest createUserRequest) {
        User user = UserMapper.INSTANCE.requestToUser(createUserRequest);

        return  UserMapper.INSTANCE.userToDto(userRepository.save(user));
    }

    public List<UserDto> getAllUsers(){
//        return userRepository.findAll().stream().map(UserMapper.INSTANCE::userToDto
//        ).collect(Collectors.toList());
        return UserMapper.INSTANCE.usersToDto(userRepository.findAll());
    }


    public UserDto getUserById(UUID id) {
        return UserMapper.INSTANCE.userToDto(userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Kullanıcı Bulunamadı")));
    }
}
