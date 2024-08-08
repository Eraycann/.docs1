package com.project.application.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.application.entities.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {

}
