package com.faiz.learn.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.faiz.learn.Entity.Posts;

@Repository
public interface PostsDao {

	List<Posts> createPostForUserWith(String userPid, List<Posts> posts);

}
