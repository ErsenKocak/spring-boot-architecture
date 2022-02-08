package com.ersen.springbootarchitecture.dto;

import com.ersen.springbootarchitecture.entity.BaseEntity;
import com.ersen.springbootarchitecture.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserDto {

    private UUID id;
    private String email;
    private String password;
    private String userName;
    private String name;
    private String surName;

}
