package com.ersen.springbootarchitecture.mappers;


import com.ersen.springbootarchitecture.dto.PostDto;
import com.ersen.springbootarchitecture.dto.request.CreatePostRequest;
import com.ersen.springbootarchitecture.dto.request.CreateUserRequest;
import com.ersen.springbootarchitecture.entity.Post;
import com.ersen.springbootarchitecture.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);


    PostDto postToDto(Post post);

    Post dtoToPost(PostDto postDto);


}
