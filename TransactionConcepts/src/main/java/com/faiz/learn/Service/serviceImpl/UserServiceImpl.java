package com.faiz.learn.Service.serviceImpl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.faiz.learn.Entity.Posts;
import com.faiz.learn.Entity.User;
import com.faiz.learn.Models.UserWithPosts;
import com.faiz.learn.Service.PostService;
import com.faiz.learn.Service.UserService;
import com.faiz.learn.dao.UserDao;

@Component
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Autowired
	private PostService postService;

	@Override
	public User createUser(User user) {
		LOGGER.info("Inside UserServiceImpl - createUser() ");

		return userDao.createUser(user);
	}

	@Override
	public User findUserByUserPid(String userPid) {
		LOGGER.info("Inside UserServiceImpl - findUserByUserPid() ");

		return userDao.findUserWith(userPid);
	}

	@Override
	public UserWithPosts createUserWithPosts(UserWithPosts userWithPosts) throws SQLException {
		LOGGER.info("Inside UserServiceImpl - createUserWithPosts() ");

		UserWithPosts newUserWithPosts = new UserWithPosts();

		userWithPosts.getUser().setCreatedOn(new Timestamp(new Date().getTime()));
		userWithPosts.getUserPosts().forEach(post -> post.setCreatedOn(new Timestamp(new Date().getTime())));

		User createdUser = createUser(userWithPosts.getUser());

//		Activate the below lines of code to generate and throw a runtime exception . 
		// createdUser = null;
		if (null == createdUser)
			throw new RuntimeException("Sql Error - SaveUser");

		List<Posts> userPosts = postService.createPostsForUser(createdUser.getUserPid(), userWithPosts.getUserPosts());

		if (null == userPosts)
			throw new RuntimeException("Sql Error - Save UserPosts");

		newUserWithPosts.setUser(createdUser);
		newUserWithPosts.setUserPosts(userPosts);

		return newUserWithPosts;
	}

}
