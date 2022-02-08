package com.ersen.springbootarchitecture.controller;

import com.ersen.springbootarchitecture.dto.UserDto;
import com.ersen.springbootarchitecture.dto.request.CreateUserRequest;
import com.ersen.springbootarchitecture.entity.User;
import com.ersen.springbootarchitecture.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@Api
public class UserController {

    private final UserService userService;

    @PostMapping
    @ApiOperation(value = "Save User")
    ResponseEntity<UserDto> saveUser(@RequestBody CreateUserRequest createUserRequest){
        return ResponseEntity.ok(userService.saveUser(createUserRequest));
    }

    @GetMapping
    @ApiOperation(value = "Get All User")
    ResponseEntity<List<UserDto>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Get User By Id ")
    ResponseEntity<UserDto> getUserById(@PathVariable UUID id){
        return ResponseEntity.ok(userService.getUserById(id));
    }


    @PutMapping("{id}")
    @ApiOperation(value = "Update User")
    ResponseEntity<UserDto> updateUser(@PathVariable UUID id, @RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.updateUser(id,userDto));
    }


    @DeleteMapping("{id}")
    @ApiOperation(value = "Delete User")
    void deleteUser(@PathVariable UUID id){
        userService.deleteUser(id);
    }



}
