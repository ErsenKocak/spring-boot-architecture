package com.ersen.springbootarchitecture.repository;

import com.ersen.springbootarchitecture.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
}
