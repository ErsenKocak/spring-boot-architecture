package com.ersen.springbootarchitecture.service;


import com.ersen.springbootarchitecture.dto.CommentDto;
import com.ersen.springbootarchitecture.dto.PostDto;
import com.ersen.springbootarchitecture.dto.UserDto;
import com.ersen.springbootarchitecture.dto.request.CreateCommentRequest;
import com.ersen.springbootarchitecture.dto.request.UpdateCommentRequest;
import com.ersen.springbootarchitecture.entity.Comment;

import com.ersen.springbootarchitecture.entity.Post;
import com.ersen.springbootarchitecture.entity.User;
import com.ersen.springbootarchitecture.exception.comment.CommentAlreadyExistException;
import com.ersen.springbootarchitecture.exception.comment.CommentNotFoundException;
import com.ersen.springbootarchitecture.mappers.CommentMapper;
import com.ersen.springbootarchitecture.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostService postService;
    private final UserService userService;

    public List<CommentDto> getAllComments() {


        return commentRepository.findAll().stream().map(CommentMapper.INSTANCE::commentToDto).collect(Collectors.toList());
    }

    public CommentDto getCommentById(UUID id) {
        Comment comment = getComment(id);
        return CommentMapper.INSTANCE.commentToDto(comment);
    }


    public CommentDto updateComment(UUID id, UpdateCommentRequest updateCommentRequest) {
        Comment comment = getComment(id);
        comment.setText(updateCommentRequest.getText());
        Comment updatedComment = commentRepository.save(comment);
        return CommentMapper.INSTANCE.commentToDto(updatedComment);

    }


    public void deleteComment(UUID id) {
        commentRepository.deleteById(id);
    }


    private Comment getComment(UUID id) {
        return commentRepository.findById(id).orElseThrow(() -> new CommentNotFoundException("İlgili yorum bulunamadı :  " + id));
    }


    public CommentDto addComment(CreateCommentRequest createCommentRequest) {
        PostDto post = postService.getPostById(createCommentRequest.getPostId());
        UserDto userDto = userService.getUserById(createCommentRequest.getUserId());
        CommentDto commentDto = CommentDto.builder()
                .user(userDto)
                .post(post)
                .text(createCommentRequest.getText())
                .build();
        Comment addedComment = commentRepository.save(CommentMapper.INSTANCE.dtoToComment(commentDto));


        return CommentMapper.INSTANCE.commentToDto(addedComment);
    }
}
