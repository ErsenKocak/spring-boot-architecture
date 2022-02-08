package com.ersen.springbootarchitecture.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Post{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String title;

    @Column(length = 1000)
    private String description;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

}
