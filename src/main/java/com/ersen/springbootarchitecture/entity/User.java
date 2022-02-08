package com.ersen.springbootarchitecture.entity;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(length = 50,unique = true,nullable = false)
    private String email;

    @Column(length = 50,nullable = false)
    private String password;

    @Column(length = 20,unique = true,nullable = false)
    private String userName;

    @Column(length = 50,nullable = false)
    private String name;

    @Column(length = 50,nullable = false)
    private String surName;





}
