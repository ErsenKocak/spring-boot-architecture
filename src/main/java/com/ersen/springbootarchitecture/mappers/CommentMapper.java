package com.ersen.springbootarchitecture.mappers;


import com.ersen.springbootarchitecture.dto.CommentDto;
import com.ersen.springbootarchitecture.dto.request.CreateCommentRequest;
import com.ersen.springbootarchitecture.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentDto commentToDto(Comment comment);

    Comment dtoToComment (CommentDto commentDto);





}
