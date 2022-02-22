package com.ersen.springbootarchitecture.exception.comment;

public class CommentAlreadyExistException extends RuntimeException {

    public CommentAlreadyExistException(String message){
        super(message);
    }
}
