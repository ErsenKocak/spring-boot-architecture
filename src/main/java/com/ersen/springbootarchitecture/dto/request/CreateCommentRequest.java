package com.ersen.springbootarchitecture.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCommentRequest {

    private String text;
    private UUID userId;
    private UUID postId;
}
