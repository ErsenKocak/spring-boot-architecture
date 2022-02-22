package com.ersen.springbootarchitecture.controller;


import com.ersen.springbootarchitecture.dto.CommentDto;
import com.ersen.springbootarchitecture.dto.request.CreateCommentRequest;
import com.ersen.springbootarchitecture.dto.request.UpdateCommentRequest;
import com.ersen.springbootarchitecture.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;


    @GetMapping
    public ResponseEntity<List<CommentDto>> getAllComments() {

        return ResponseEntity.ok(commentService.getAllComments());
    }

    @GetMapping("{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable UUID id) {
        return ResponseEntity.ok(commentService.getCommentById(id));
    }

    @PostMapping
    public ResponseEntity<CommentDto> addComment(@RequestBody CreateCommentRequest createCommentRequest) {
        return ResponseEntity.ok(commentService.addComment(createCommentRequest));
    }


    @DeleteMapping("{id}")
    public void deleteComment(@PathVariable UUID id) {
        commentService.deleteComment(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable UUID id, @RequestBody UpdateCommentRequest updateCommentRequest) {

        return ResponseEntity.ok(commentService.updateComment(id, updateCommentRequest));
    }


}
