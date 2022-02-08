package com.ersen.springbootarchitecture.dto.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserRequest {
    private String email;
    private String password;
    private String userName;
    private String name;
    private String surName;
}
