package com.ersen.springbootarchitecture.exception;


import com.ersen.springbootarchitecture.exception.comment.CommentAlreadyExistException;
import com.ersen.springbootarchitecture.exception.comment.CommentNotFoundException;
import com.ersen.springbootarchitecture.exception.post.PostNotFoundException;
import com.ersen.springbootarchitecture.exception.user.UserNotFoundException;
import com.ersen.springbootarchitecture.util.response.ErrorResponse;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleExceptions(UserNotFoundException exception, WebRequest webRequest) {
        return new ResponseEntity<Object>(new ErrorResponse(exception.getMessage()), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<Object> handleExceptions(PostNotFoundException exception, WebRequest webRequest) {
        return new ResponseEntity<Object>(new ErrorResponse(exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CommentNotFoundException.class)
    public ResponseEntity<Object> handleExceptions(CommentNotFoundException exception, WebRequest webRequest) {
        return new ResponseEntity<Object>(new ErrorResponse(exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CommentAlreadyExistException.class)
    public ResponseEntity<Object> handleExceptions(CommentAlreadyExistException exception, WebRequest webRequest) {
        return new ResponseEntity<Object>(new ErrorResponse(exception.getMessage()), HttpStatus.NOT_FOUND);
    }
}
