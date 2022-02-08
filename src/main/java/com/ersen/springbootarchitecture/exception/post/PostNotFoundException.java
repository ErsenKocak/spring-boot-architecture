package com.ersen.springbootarchitecture.exception.post;

public class PostNotFoundException extends  RuntimeException {

    public PostNotFoundException(String message){
        super(message);
    }
}
