package com.ersen.springbootarchitecture.dto;

import com.ersen.springbootarchitecture.entity.Comment;
import com.ersen.springbootarchitecture.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private UUID id;
    private String title;
    private String description;
    private User user;
    private List<Comment> comments;

}
