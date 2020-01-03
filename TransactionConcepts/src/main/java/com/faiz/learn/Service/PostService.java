package com.faiz.learn.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.faiz.learn.Entity.Posts;

@Service
public interface PostService {

	List<Posts> createPostsForUser(String userPid, List<Posts> posts);

}
