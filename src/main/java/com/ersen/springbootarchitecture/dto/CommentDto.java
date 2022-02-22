package com.ersen.springbootarchitecture.dto;


import com.ersen.springbootarchitecture.entity.Post;
import com.ersen.springbootarchitecture.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private UUID id;
    private String text;
    private UserDto user;
    private PostDto post;
}
