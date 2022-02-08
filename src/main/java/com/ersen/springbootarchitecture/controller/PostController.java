package com.ersen.springbootarchitecture.controller;


import com.ersen.springbootarchitecture.dto.PostDto;
import com.ersen.springbootarchitecture.dto.request.CreatePostRequest;
import com.ersen.springbootarchitecture.entity.Post;
import com.ersen.springbootarchitecture.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(name = "posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts(){
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable UUID id){
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PostMapping
    public ResponseEntity<PostDto> savePost(@RequestBody CreatePostRequest request){
        return new ResponseEntity(postService.savePost(request), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable UUID id, @RequestBody PostDto postDto){
        return ResponseEntity.ok(postService.updatePost(postDto));
    }

    @DeleteMapping("{id}")
    public void deletePostById(@PathVariable UUID id){
        postService.deletePostById(id);
    }




}
