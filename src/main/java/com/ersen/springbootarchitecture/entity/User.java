package com.ersen.springbootarchitecture.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","posts"})

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


    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)

    private List<Post> posts;

}
