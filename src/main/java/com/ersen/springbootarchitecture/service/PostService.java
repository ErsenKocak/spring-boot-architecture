package com.ersen.springbootarchitecture.service;

import com.ersen.springbootarchitecture.dto.PostDto;
import com.ersen.springbootarchitecture.dto.request.CreatePostRequest;
import com.ersen.springbootarchitecture.entity.Post;
import com.ersen.springbootarchitecture.entity.User;
import com.ersen.springbootarchitecture.exception.post.PostNotFoundException;
import com.ersen.springbootarchitecture.mappers.PostMapper;
import com.ersen.springbootarchitecture.mappers.UserMapper;
import com.ersen.springbootarchitecture.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;

    @PostConstruct
    private void init(){
      /*  Post post = Post.builder()
                .id(UUID.randomUUID())
                .description("Description Test")
                .title("Title Test")
                .user(UserMapper.INSTANCE.dtoToUser(userService.getAllUsers().get(0)))
                .build();

            postRepository.save(post);*/


    }

    public List<PostDto> getAllPosts() {
        return postRepository.findAll().stream().map(PostMapper.INSTANCE::postToDto).collect(Collectors.toList());
    }


    public PostDto getPostById(UUID id){
        return PostMapper.INSTANCE.postToDto(getPost(id));
    }

    public PostDto savePost(CreatePostRequest request) {
        User user = UserMapper.INSTANCE.dtoToUser(userService.getUserById(request.getUserId()));
        Post post = Post.builder()
                .user(user)
                .description(request.getDescription())
                .title(request.getTitle())
                .build();

        return PostMapper.INSTANCE.postToDto(postRepository.save(post));
    }

    public PostDto updatePost(PostDto postDto){ // TODO: Kontrol Et
        Post post = getPost(postDto.getId());
        Post updatedPost = postRepository.save(post);
        return PostMapper.INSTANCE.postToDto(updatedPost);
    }

    public void deletePostById(UUID id){
        postRepository.deleteById(id);
    }

    private Post getPost(UUID id){
        return  postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("Post Bulunmamaktadır:"+ " " +id));
    }
}
