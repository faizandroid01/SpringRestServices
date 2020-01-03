package com.faiz.learn.Service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.faiz.learn.Entity.Posts;
import com.faiz.learn.Service.PostService;
import com.faiz.learn.dao.PostsDao;

@Component
public class PostServiceImpl implements PostService {

	@Autowired
	private PostsDao postDao;

	@Override
	public List<Posts> createPostsForUser(String userPid, List<Posts> posts) {
		return postDao.createPostForUserWith(userPid, posts);
	}

}
