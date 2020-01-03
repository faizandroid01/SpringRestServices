package com.faiz.learn.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.faiz.learn.Entity.Posts;
import com.faiz.learn.Repo.PostsRepo;
import com.faiz.learn.dao.PostsDao;

@Component
public class PostsDaoImpl implements PostsDao {

	@Autowired
	private PostsRepo postRepo;

	@Override
	public List<Posts> createPostForUserWith(String userPid, List<Posts> posts) {

		return postRepo.saveAll(posts);
		
	}

}
