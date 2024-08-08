package com.project.application.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.application.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
