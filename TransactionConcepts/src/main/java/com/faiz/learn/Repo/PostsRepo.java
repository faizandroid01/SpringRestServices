package com.faiz.learn.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faiz.learn.Entity.Posts;

public interface PostsRepo extends JpaRepository<Posts, Long> {

}
